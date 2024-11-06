package com.example.flowpay.service;

import com.example.flowpay.model.Atendente;
import com.example.flowpay.model.Solicitacao;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeAtendimento {
    private final String tipo;
    private final List<Atendente> atendentes;
    private final Queue<Solicitacao> filaEspera = new LinkedList<>();

    public TimeAtendimento(String tipo) {
        this.tipo = tipo;
        this.atendentes = new LinkedList<>();
    }

    public void adicionarAtendente(Atendente atendente) {
        atendentes.add(atendente);
    }

    public void distribuirSolicitacao(Solicitacao solicitacao) {
        for (Atendente atendente : atendentes) {
            if (atendente.podeAtender()) {
                atendente.atender();
                System.out.println("Solicitação de '" + solicitacao.getAssunto() + "' atribuída ao atendente " + atendente.getNome() + " do time " + tipo);
                return;
            }
        }
        filaEspera.add(solicitacao);
        System.out.println("Todos os atendentes do time " + tipo + " estão ocupados. Solicitação enfileirada.");
    }

    public void liberarAtendimento(Atendente atendente) {
        atendente.finalizarAtendimento();
        if (!filaEspera.isEmpty()) {
            Solicitacao proximaSolicitacao = filaEspera.poll();
            distribuirSolicitacao(proximaSolicitacao);
        }
    }
}
