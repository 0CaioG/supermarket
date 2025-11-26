package com.example.supermarket.supermarket.controllers;

import com.example.supermarket.supermarket.dto.PrecoDTO;
import com.example.supermarket.supermarket.entities.Preco;
import com.example.supermarket.supermarket.services.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("preco")
public class PrecoController {

    @Autowired
    private PrecoService precoService;

    @GetMapping("/{id}")
    private ResponseEntity<Preco> buscarPrecoPorId(@PathVariable Long id){
        return precoService.encontrarPreco(id)
                .map(preco -> new ResponseEntity<>(preco,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    private List<Preco> listarPrecos(){
        return precoService.listarPrecos();
    }

    @GetMapping("/produto/{id}")
    private List<Preco> lsitarPrecoPorProduto(@PathVariable Long id){
        return precoService.listarPrecoPorProduto(id);
    }

    @GetMapping("/supermercado/{id}")
    private List<Preco> listarPrecoPorSupermercado(@PathVariable Long id){
        return precoService.listarPrecoPorSupermercado(id);
    }

    @PostMapping
    private Preco criarPreco(@RequestBody PrecoDTO novoPreco){
        return precoService.criarPreco(novoPreco);
    }

    @PutMapping("/{id}")
    private Preco atualizarPreco(@PathVariable Long id, @RequestBody PrecoDTO preco){
        return precoService.atualizarPreco(id,preco);
    }

    @PutMapping("/{id}/encerrar-vigencia")
    private Preco encerrarPreco(@PathVariable("id") Long id, @RequestBody PrecoDTO preco){
        preco.setFim_vigencia(LocalDate.now());
        return precoService.atualizarPreco(id,preco);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarPreco(@PathVariable Long id){
        precoService.deletarPreco(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
