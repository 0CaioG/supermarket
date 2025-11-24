package com.example.supermarket.supermarket.services;

import com.example.supermarket.supermarket.dto.PrecoDTO;
import com.example.supermarket.supermarket.entities.Preco;
import com.example.supermarket.supermarket.entities.Produto;
import com.example.supermarket.supermarket.entities.Supermercado;
import com.example.supermarket.supermarket.repositories.PrecoRepository;
import com.example.supermarket.supermarket.repositories.ProdutoRepository;
import com.example.supermarket.supermarket.repositories.SupermercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecoService {

    @Autowired
    public PrecoRepository precoRepository;

    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public SupermercadoRepository supermercadoRepository;

    public Preco criarPreco(PrecoDTO novoPreco){
        return precoRepository.save(fromDTO(novoPreco));
    }

    public List<Preco> listarPrecoPorProduto(Long produtoId){
        return precoRepository.findPrecoByProduto_id(produtoId);
    }

    public List<Preco> listarPrecoPorSupermercado(Long supermercadoId){
        return precoRepository.findPrecoBySupermercado_id(supermercadoId);
    }

    public List<Preco> listarPrecos(){
        return precoRepository.findAll();
    }

    public Optional<Preco> encontrarPreco(Long id){
        return precoRepository.findById(id);
    }

    public Preco atualizarPreco(Long id, PrecoDTO novoPreco){
        Preco precoAtual = precoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum preco encontrado para o id "+id));

        Preco precoConvertido = fromDTO(novoPreco);

        precoAtual.setInicio_vigencia(precoConvertido.getInicio_vigencia());
        precoAtual.setFim_vigencia(precoConvertido.getFim_vigencia());
        precoAtual.setValor(precoConvertido.getValor());
        precoAtual.setProduto(precoConvertido.getProduto());
        precoAtual.setSupermercado(precoConvertido.getSupermercado());

        return precoRepository.save(precoAtual);
    }

    public void deletarPreco(Long id){
        precoRepository.deleteById(id);
    }

    public Preco fromDTO(PrecoDTO novoPreco){
        Produto produtoAtual = produtoRepository.findById(novoPreco.getProduto_id())
                .orElseThrow(() -> new RuntimeException("Nenhum produto encontrado para o id "+novoPreco.getProduto_id()));

        Supermercado supermercadoAtual = supermercadoRepository.findById(novoPreco.getSupermercado_id())
                .orElseThrow(() -> new RuntimeException("Nenhum supermercado encontrado para o id "+novoPreco.getSupermercado_id()));

        return new Preco(novoPreco.getId(), produtoAtual,supermercadoAtual, novoPreco.getValor(),novoPreco.getInicio_vigencia(), novoPreco.getFim_vigencia());
    }

}
