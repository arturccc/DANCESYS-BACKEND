package com.dancesys.dancesys.service;

import com.dancesys.dancesys.dto.AlunoFilter;
import com.dancesys.dancesys.entity.Aluno;
import com.dancesys.dancesys.entity.Usuario;
import com.dancesys.dancesys.infra.PaginatedResponse;
import com.dancesys.dancesys.repository.AlunoRepository;
import com.dancesys.dancesys.repository.AlunoRepositoryCustom;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl{
    private final AlunoRepository alunoRepository;
    private final DividendoServiceImpl dividendoService;
    private final AlunoRepositoryCustom  alunoRepositoryCustom;

    public AlunoServiceImpl(
            AlunoRepository alunoRepository,
            @Lazy DividendoServiceImpl dividendoService,
            AlunoRepositoryCustom alunoRepositoryCustom
    ) {
        this.alunoRepository = alunoRepository;
        this.dividendoService = dividendoService;
        this.alunoRepositoryCustom = alunoRepositoryCustom;
    }

    public Aluno salvar(Aluno entity) throws Exception{

        try{
            if(entity.getTipo().equals(Aluno.fixo)){
                entity.setCreditos(0);
            }else{
                entity.setCreditos(Aluno.max_creditos);
            }
            Aluno newEntity = alunoRepository.save(entity);
            return newEntity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Aluno dimuirCredito(Aluno entity, Integer n){
        if(entity.getCreditos().equals(0)){
            throw new RuntimeException("Aluno ja com o minimo de craditos");
        }
        entity.setCreditos(entity.getCreditos() - n);
        return alunoRepository.save(entity);
    }

    public Aluno aumentarCredito(Aluno entity, Integer n){
        if(entity.getTipo().equals(Aluno.fixo)){
            throw new RuntimeException("Aluno do tipo fixo");
        }
        if(entity.getCreditos().equals(Aluno.max_creditos)){
            throw new RuntimeException("Aluno ja com creditos maximos");
        }

        entity.setCreditos(entity.getCreditos() + n);
        return alunoRepository.save(entity);
    }

    public void setMaxCreditos(Aluno entity){
        entity.setCreditos(Aluno.max_creditos);
        alunoRepository.save(entity);
    }

    public Aluno findById(Long id){
        return alunoRepository.findById(id);
    }

    public PaginatedResponse<Aluno> buscar(AlunoFilter filtro){
        return alunoRepositoryCustom.buscar(filtro);
    }

    public Aluno findByIdUsuario(Long idUsuario){
        return alunoRepository.findByIdUsuarioId(idUsuario);
    }

    public void gerarBoletosMenslaidadeJob() throws Exception {
        List<Aluno> alunos = alunoRepository.findByIdUsuarioStatus(Usuario.ativo);

        for(Aluno a : alunos){
            dividendoService.gerarMensalidade(a);
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nFinalizando job de boletos mensalidade\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
