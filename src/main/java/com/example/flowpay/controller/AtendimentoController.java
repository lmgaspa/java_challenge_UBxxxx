package com.example.flowpay.controller;

import com.example.flowpay.model.Solicitacao;
import com.example.flowpay.service.CentralAtendimento;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    private final CentralAtendimento centralAtendimento;

    public AtendimentoController() {
        this.centralAtendimento = new CentralAtendimento();
    }

    @PostMapping("/distribuir")
    public String distribuirSolicitacao(@RequestParam String assunto) {
        Solicitacao solicitacao = new Solicitacao(assunto);
        centralAtendimento.distribuirSolicitacao(solicitacao);
        return "Solicitação de '" + assunto + "' distribuída.";
    }

    @PostMapping("/liberar")
    public String liberarAtendente(@RequestParam String nomeAtendente, @RequestParam String tipo) {
        centralAtendimento.liberarAtendimento(nomeAtendente, tipo);
        return "Atendente '" + nomeAtendente + "' do time '" + tipo + "' liberado.";
    }
}
