package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.hamcrest.CoreMatchers.*;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO paginaProduto;
	private final String id1 = "12345";
	private final String id2 = "12346";

	
	@BeforeClass
	public static void criarCenario() {
		paginaProduto = new ProdutoPO(driver);
	}
	
	@Test
	public void testTodosOsCamposPreenchidos() {
		
		paginaProduto.cadastrarProdutoComDados("12375", "Biscoito", "2000", "3,00", "2022-08-12");
		
		assertThat(id1, is("12375"));

	}
	
	@Test
	public void testExcluirProdutoCriado() {
		
		paginaProduto.buttonApagar.click();
		
		boolean resultado = paginaProduto.verificar(paginaProduto.valorCodigo);
	
		assertFalse(resultado);
	}
	
	@Test
	public void testNaoCadastrarProdutoSemDado() {
		
		paginaProduto.cadastarProdutoSemDados("123478", "Uva", "2001", "7,00", "");
		
		String mensagemDeErro = paginaProduto.obterMensagem();
		
		assertEquals(mensagemDeErro, "Preencher todos os campos!");
		
	}
}

