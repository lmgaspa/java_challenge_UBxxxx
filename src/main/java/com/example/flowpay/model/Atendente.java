package com.example.flowpay.model;

public class Atendente {
    private String nome;
    private int capacidadeAtual = 0;

    public Atendente(String nome) {
        this.nome = nome;
    }

    public boolean podeAtender() {
        return capacidadeAtual < 3;
    }

    public void atender() {
        if (podeAtender()) {
            capacidadeAtual++;
        } else {
            throw new IllegalStateException("Atendente já está com capacidade máxima.");
        }
    }

    public void finalizarAtendimento() {
        if (capacidadeAtual > 0) {
            capacidadeAtual--;
        }
    }

    public String getNome() {
        return nome;
    }
}
