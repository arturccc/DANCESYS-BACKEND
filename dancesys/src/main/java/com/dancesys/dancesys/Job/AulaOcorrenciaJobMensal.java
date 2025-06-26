package com.dancesys.dancesys.Job;

import com.dancesys.dancesys.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AulaOcorrenciaJobMensal {

    @Autowired
    private AulaService aulaService;

    @Scheduled(cron = "0 0 1 1 * *", zone = "America/Sao_Paulo")
    public void gerarAulasJobMensal() throws Exception{
        System.out.println("\n\n\n\n\n\n\n\n\n\nAulaOcorrenciaJob executando\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        aulaService.gerarAulasJobMensal();
    }
}
