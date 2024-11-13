package com.example.Atividade_16.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.Atividade_16.model.Produto;
import com.example.Atividade_16.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarProduto() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto novoProduto = produtoService.criarProduto(produto);

        assertEquals("Produto Teste", novoProduto.getNome());
        verify(produtoRepository, times(1)).save(produto);
    }

    @Test
    public void testBuscarProdutoPorId() {
        Produto produto = new Produto();
        produto.setId(1L);
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> resultado = produtoService.buscarProdutoPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
    }

    @Test
    public void testExcluirProduto() {
        Long id = 1L;
        produtoService.excluirProduto(id);

        verify(produtoRepository, times(1)).deleteById(id);
    }
}

