package com.example.flowpay.service;

import com.example.flowpay.model.Atendente;
import com.example.flowpay.model.Solicitacao;

public class CentralAtendimento {
    private final TimeAtendimento timeCartoes;
    private final TimeAtendimento timeEmprestimos;
    private final TimeAtendimento timeOutros;

    public CentralAtendimento() {
        timeCartoes = new TimeAtendimento("Cartões");
        timeEmprestimos = new TimeAtendimento("Empréstimos");
        timeOutros = new TimeAtendimento("Outros Assuntos");

        timeCartoes.adicionarAtendente(new Atendente("João"));
        timeCartoes.adicionarAtendente(new Atendente("Maria"));

        timeEmprestimos.adicionarAtendente(new Atendente("Carlos"));
        timeEmprestimos.adicionarAtendente(new Atendente("Ana"));

        timeOutros.adicionarAtendente(new Atendente("Pedro"));
        timeOutros.adicionarAtendente(new Atendente("Paula"));
    }

    public void distribuirSolicitacao(Solicitacao solicitacao) {
        switch (solicitacao.getAssunto()) {
            case "Problemas com cartão":
                timeCartoes.distribuirSolicitacao(solicitacao);
                break;
            case "Contratação de empréstimo":
                timeEmprestimos.distribuirSolicitacao(solicitacao);
                break;
            default:
                timeOutros.distribuirSolicitacao(solicitacao);
                break;
        }
    }

    public void liberarAtendimento(String nomeAtendente, String tipo) {
    }
}
