package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="btn-adicionar")
	public WebElement buttonCadastrar;
	
	@FindBy(id="codigo")
	public WebElement inputCodigo;
	
	@FindBy(id="nome")
	public WebElement inputNome;
	
	@FindBy(id="quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id="valor")
	public WebElement inputValor;
	
	@FindBy(id="data")
	public WebElement inputData;
	
	@FindBy(xpath = "//*[@id=\"btn-salvar\"]")
	public WebElement buttonSalvar;
	
	@FindBy(xpath = "//*[@id=\"cadastro-produto\"]/div/div/div[1]/button")
	public WebElement buttonXModal;

	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr/td[6]/button[2]")
	public WebElement buttonApagar;
	

	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr/td[1]")
	public WebElement valorCodigo;

	@FindBy(id = "mensagem")
	public WebElement campoVazio;
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public boolean verificar(WebElement valor) {
		String linha = valor.getText();
		if(linha == "") {
			System.out.println("Produto excluído com sucesso.");
			return true;
		} else {
			System.out.println("Não foi possível excluir o produto.");
			return false;
		}
	}
	

	public String obterMensagem() {
		return this.campoVazio.getText();
	}
	
	public void cadastrarProdutoComDados(String codigo, String nome, String quantidade, String valor, String data ) {
		buttonCadastrar.click();
		buttonCadastrar.click();
		escrever(this.inputCodigo, codigo);
		escrever(this.inputNome, nome);
		escrever(this.inputQuantidade, quantidade);
		escrever(this.inputValor, valor);
		escrever(this.inputData, data);
		buttonSalvar.click();	
		buttonXModal.click();
	}

	public void cadastarProdutoSemDados(String codigo, String nome, String quantidade, String valor, String data ) {
		buttonCadastrar.click();
		escrever(this.inputCodigo, codigo);
		escrever(this.inputNome, nome);
		escrever(this.inputQuantidade, quantidade);
		escrever(this.inputValor, valor);
		escrever(this.inputData, data);
		buttonSalvar.click();
	}
}
