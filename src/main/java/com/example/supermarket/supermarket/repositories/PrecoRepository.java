package com.example.supermarket.supermarket.repositories;

import com.example.supermarket.supermarket.dto.MercadoDadosDTO;
import com.example.supermarket.supermarket.dto.ProdutoPrecoDTO;
import com.example.supermarket.supermarket.entities.Preco;
import com.example.supermarket.supermarket.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {
    List<Preco> findPrecoByProduto_id(Long id);
    List<Preco> findPrecoBySupermercado_id(Long id);
    List<Preco> findPrecoBySupermercado_idAndProduto_id(Long supermercadoId, Long produtoId);

    @Query("""
        SELECT new com.example.supermarket.supermarket.dto.ProdutoPrecoDTO(
            p.produto.id,
            p.produto.nome,
            p.valor,
            p.inicio_vigencia,
            p.fim_vigencia
        )
        FROM Preco p
        WHERE p.supermercado.id = :supermercadoId 
        AND (p.fim_vigencia > NOW() OR p.fim_vigencia IS NULL)
    """)
    List<ProdutoPrecoDTO> buscarProdutosVigentes(
            @Param("supermercadoId") Long supermercadoId
    );

    @Query(value="""
        SELECT s.id, s.nome, COUNT(*) as produtos_cadastrados FROM preco p
        INNER JOIN supermercado s ON s.id = p.supermercado_id
        WHERE (p.fim_vigencia > NOW() OR p.fim_vigencia IS NULL)
        GROUP BY p.supermercado_id
    """,nativeQuery = true)
    List<MercadoDadosDTO> buscarQtdProdutosPorSupermercado();
}
