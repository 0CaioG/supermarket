package com.example.supermarket.supermarket.controllers;

import com.example.supermarket.supermarket.entities.Preco;
import com.example.supermarket.supermarket.entities.Produto;
import com.example.supermarket.supermarket.services.PrecoService;
import com.example.supermarket.supermarket.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PrecoService precoService;

    @GetMapping
    private List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Produto> buscarProduto(@PathVariable Long id){
        return produtoService.buscarProduto(id)
                .map(produto -> new ResponseEntity<>(produto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/historico-precos")
    private List<Preco> listarHistoricoPrecos(@PathVariable("id") Long produtoId, @RequestParam Long supermercadoId){
        return precoService.listarPorProdutosSupermercados(supermercadoId, produtoId);
    }

    @PostMapping
    private Produto criarProduto(@RequestBody Produto novoProduto){
        return produtoService.criarProduto(novoProduto);
    }

    @PutMapping("/{id}")
    private Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
