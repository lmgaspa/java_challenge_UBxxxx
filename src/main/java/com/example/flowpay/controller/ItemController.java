package com.example.flowpay.controller;

import com.example.flowpay.exception.ItemNotFoundException;
import com.example.flowpay.model.Item;
import com.example.flowpay.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> listarItens() {
        return itemService.listarItens();
    }

    @GetMapping("/{id}")
    public Item buscarItemPorId(@PathVariable Long id) {
        return itemService.buscarItemPorId(id);
    }

    @PostMapping
    public ResponseEntity<Item> adicionarItem(@RequestParam String nome) {
        Item novoItem = itemService.adicionarItem(nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    @PutMapping("/{id}")
    public Item atualizarItem(@PathVariable Long id, @RequestParam String nome) {
        return itemService.atualizarItem(id, nome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        boolean deleted = itemService.deletarItem(id);
        if (!deleted) {
            throw new ItemNotFoundException("Item não encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
