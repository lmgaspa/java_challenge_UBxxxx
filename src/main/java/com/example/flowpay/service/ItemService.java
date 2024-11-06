package com.example.flowpay.service;

import com.example.flowpay.model.Item;
import java.util.List;

public interface ItemService {
    List<Item> listarItens();
    Item buscarItemPorId(Long id);
    Item adicionarItem(String nome);
    Item atualizarItem(Long id, String nome);
    boolean deletarItem(Long id);
}
