package com.example.supermarket.supermarket.services;

import com.example.supermarket.supermarket.entities.Supermercado;
import com.example.supermarket.supermarket.repositories.SupermercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupermercadoService {

    @Autowired
    public SupermercadoRepository supermercadoRepository;

    public Supermercado criarSupermercado(Supermercado novoSupermercado){
        return supermercadoRepository.save(novoSupermercado);
    }

    public List<Supermercado> listarSupermercados(){
        return supermercadoRepository.findAll();
    }

    public Optional<Supermercado> encontrarSupermercado(Long supermercadoId){
        return supermercadoRepository.findById(supermercadoId);
    }

    public Supermercado atualizarSupermercado(Long id, Supermercado supermercadoNovo){
        Supermercado supermercadoAtual = supermercadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum supermercado encontrado para o id "+ id));

        supermercadoAtual.setNome(supermercadoNovo.getNome());
        supermercadoAtual.setCnpj(supermercadoNovo.getCnpj());
        supermercadoAtual.setData_criacao(supermercadoNovo.getData_criacao());

        return supermercadoRepository.save(supermercadoAtual);
    }

    public void deletarSupermercado(Long id){
        supermercadoRepository.deleteById(id);
    }
}
