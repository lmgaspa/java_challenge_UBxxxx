package com.example.flowpay;

import com.example.flowpay.model.Solicitacao;
import com.example.flowpay.service.CentralAtendimento;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		CentralAtendimento central = new CentralAtendimento();

		central.distribuirSolicitacao(new Solicitacao("Problemas com cartão"));
		central.distribuirSolicitacao(new Solicitacao("Contratação de empréstimo"));
		central.distribuirSolicitacao(new Solicitacao("Problemas com cartão"));
		central.distribuirSolicitacao(new Solicitacao("Outro assunto"));
	}
}

