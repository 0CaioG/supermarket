package com.example.supermarket.supermarket.services;

import com.example.supermarket.supermarket.entities.Produto;
import com.example.supermarket.supermarket.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto novoProduto){
        return produtoRepository.save(novoProduto);
    }

    public Optional<Produto> buscarProduto(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, Produto produto){
        Produto produtoAtual = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum produto encontrado para o id "+id));

        produtoAtual.setNome(produto.getNome());
        produtoAtual.setCategoria(produto.getCategoria());
        produtoAtual.setCodigo_barras(produto.getCodigo_barras());
        produtoAtual.setData_criacao(produto.getData_criacao());

        return produtoRepository.save(produtoAtual);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
