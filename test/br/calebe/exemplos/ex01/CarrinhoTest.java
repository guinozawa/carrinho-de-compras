package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	@Test(expected = CarrinhoVazioExpected.class)
	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void colocandoMaisProdutosTest() throws CarrinhoVazioExpected {
		Produto livro1 = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro1);
		Produto livro2 = new Produto("Java: como programar", 150.00);
		carrinho.add(livro2);
                Produto livro3 = new Produto("Dom Casmurro",30.00);
		carrinho.add(livro3);
                assertEquals(3, carrinho.numeroDeProdutos());
                assertTrue(carrinho.buscarProduto(livro1));
                assertTrue(carrinho.buscarProduto(livro2));
                assertTrue(carrinho.buscarProduto(livro3));                     
	}

        @Test
        public void listaTodosProdutosTest() throws CarrinhoVazioExpected {
                List<Produto> produtos = new ArrayList<>();
                Produto livro1 = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro1);
		Produto livro2 = new Produto("Java: como programar", 150.00);
		carrinho.add(livro2);
                produtos.add(livro1);
                produtos.add(livro2);
                assertEquals(produtos, carrinho.getList());
        }
        
        @Test
        public void removendoUmProdutoTest() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
                Produto livro2 = new Produto("Java: como programar", 150.00);
		carrinho.add(livro);
		assertTrue(carrinho.buscarProduto(livro));
                carrinho.remove(livro);
                assertEquals(0, carrinho.numeroDeProdutos());
                carrinho.add(livro);
                carrinho.add(livro2);
                carrinho.remove(livro);
                assertFalse(carrinho.buscarProduto(livro));             
	}
        
        @Test
        public void calculaTotaPedidoTest() throws CarrinhoVazioExpected{
                Produto livro1 = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro1);
		Produto livro2 = new Produto("Java: como programar", 150.00);
		carrinho.add(livro2);
                Produto livro3 = new Produto("Dom Casmurro", 30.00);
                carrinho.add(livro3);
                assertEquals(230.00, carrinho.calcularTotalPedido(), 1e-40);
                carrinho.remove(livro2);
                assertEquals(80.00, carrinho.calcularTotalPedido(), 1e-40);
                carrinho.add(livro2);
                assertEquals(230.00, carrinho.calcularTotalPedido(), 1e-40);
        }

	@Test
	public void identidadeDeProdutosTest() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
		assertArrayEquals(new Object[] { original }, new Object[] { copia });
	}
        
       
}
