package com.example.supermarket.supermarket.controllers;

import com.example.supermarket.supermarket.dto.ProdutoPrecoDTO;
import com.example.supermarket.supermarket.entities.Preco;
import com.example.supermarket.supermarket.entities.Produto;
import com.example.supermarket.supermarket.entities.Supermercado;
import com.example.supermarket.supermarket.services.PrecoService;
import com.example.supermarket.supermarket.services.SupermercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supermercado")
public class SupermercadoController {

    @Autowired
    private SupermercadoService supermercadoService;

    @Autowired
    private PrecoService precoService;

    @GetMapping
    private List<Supermercado> listarSupermercados(){
        return supermercadoService.listarSupermercados();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Supermercado> buscarSupermercado(@PathVariable Long id){
        return supermercadoService.encontrarSupermercado(id)
                .map(supermercado -> new ResponseEntity<>(supermercado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/produtos")
    private List<ProdutoPrecoDTO> listarProdutosVigentes(@PathVariable Long id){
        return precoService.listarPorVigenciaSupermercado(id);
    }

    @PostMapping
    private Supermercado criarSupermercado(@RequestBody Supermercado novoSupermercado){
        return supermercadoService.criarSupermercado(novoSupermercado);
    }

    @PutMapping("/{id}")
    private Supermercado atualizarSupermercado(@PathVariable Long id, @RequestBody Supermercado novoSupermercado){
        return supermercadoService.atualizarSupermercado(id,novoSupermercado);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarSupermercado(@PathVariable Long id){
        supermercadoService.deletarSupermercado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
