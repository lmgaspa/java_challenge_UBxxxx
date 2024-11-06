package com.example.flowpay.service;

import com.example.flowpay.model.Item;
import com.example.flowpay.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryItemService implements ItemService {

    private final List<Item> items = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public InMemoryItemService() {
        items.add(new Item(counter.incrementAndGet(), "Item 1"));
        items.add(new Item(counter.incrementAndGet(), "Item 2"));
    }

    @Override
    public List<Item> listarItens() {
        return items;
    }

    @Override
    public Item buscarItemPorId(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item não encontrado"));
    }

    @Override
    public Item adicionarItem(String nome) {
        Item novoItem = new Item(counter.incrementAndGet(), nome);
        items.add(novoItem);
        return novoItem;
    }

    @Override
    public Item atualizarItem(Long id, String nome) {
        Item item = buscarItemPorId(id);
        item.setNome(nome);
        return item;
    }

    @Override
    public boolean deletarItem(Long id) {
        return items.removeIf(item -> item.getId().equals(id));
    }
}
