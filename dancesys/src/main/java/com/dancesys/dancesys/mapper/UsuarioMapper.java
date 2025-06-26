package com.dancesys.dancesys.mapper;

import com.dancesys.dancesys.dto.AlunoDTO;
import com.dancesys.dancesys.dto.LoginCookie;
import com.dancesys.dancesys.dto.LoginDTO;
import com.dancesys.dancesys.dto.UsuarioDTO;
import com.dancesys.dancesys.entity.Usuario;

public class UsuarioMapper {
        public static Usuario toEntity(UsuarioDTO dto) {
            if (dto == null) return null;

            Usuario entity = new Usuario();

            entity.setId(dto.getId());
            entity.setNome(dto.getNome());
            entity.setCpf(dto.getCpf());
            entity.setNumero(dto.getNumero());
            entity.setEmail(dto.getEmail());
            entity.setSenha(dto.getSenha());
            entity.setTipo(dto.getTipo());
            entity.setStatus(dto.getStatus());
            entity.setEndereco(dto.getEndereco());
            entity.setUrlFoto(dto.getUrlFoto());
            entity.setDataNascimento(dto.getDataNascimento());
            entity.setCriadoEm(dto.getCriadoEm());

            return entity;
        }

        public static UsuarioDTO toDTO(Usuario entity) {
            if (entity == null) return null;

            UsuarioDTO dto = new UsuarioDTO();

            dto.setId(entity.getId());
            dto.setNome(entity.getNome());
            dto.setCpf(entity.getCpf());
            dto.setNumero(entity.getNumero());
            dto.setEmail(entity.getEmail());
            dto.setSenha(entity.getSenha());
            dto.setTipo(entity.getTipo());
            dto.setStatus(entity.getStatus());
            dto.setEndereco(entity.getEndereco());
            dto.setUrlFoto(entity.getUrlFoto());
            dto.setDataNascimento(entity.getDataNascimento());
            dto.setCriadoEm(entity.getCriadoEm());

            return dto;
        }

        public static LoginCookie toLoginDTO(Usuario entity) {
            if (entity == null) return null;

            LoginCookie dto = new LoginCookie();

            dto.setId(entity.getId());
            dto.setTipo(entity.getTipo());

            return dto;
        }

        public static UsuarioDTO alunoDTOtoDto(AlunoDTO Adto){
            if (Adto == null) return null;

            UsuarioDTO dto = new UsuarioDTO();
            if(Adto.getUsuario() != null){
                dto.setId(Adto.getUsuario().getId());
            }
            dto.setNome(Adto.getNome());
            dto.setCpf(Adto.getCpf());
            dto.setNumero(Adto.getNumero());
            dto.setEmail(Adto.getEmail());
            dto.setSenha(Adto.getSenha());
            dto.setTipo(Adto.getTipo());
            dto.setStatus(Adto.getStatus());
            dto.setEndereco(Adto.getEndereco());
            dto.setUrlFoto(Adto.getUrlFoto());
            dto.setDataNascimento(Adto.getDataNascimento());
            dto.setCriadoEm(Adto.getCriadoEm());

            return dto;
        }

}
