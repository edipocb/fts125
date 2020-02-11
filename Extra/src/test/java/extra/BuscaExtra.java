package extra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscaExtra {
	String url;
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-d HH-mm").format(Calendar.getInstance().getTime());
	
	
	//Funções e Métodos de Apoio
	
	//Tirar Print da Tela
	
	public void print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(foto, new File("C:\\Users\\ecbatista\\eclipse-workspace\\Extra\\target\\evidencias\\" + nomePasta + "\\" + nomePrint + ".png"));
	}
	
	@Before //anotação, vai fazer parte do teste
	public void Iniciar() {
		url = "https://www.submarino.com.br/";
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ecbatista\\eclipse-workspace\\Extra\\drivers\\chrome\\79\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	@After
	public void Finalizar() {
		driver.quit();
	}
	
	@Given("^que acesso o site do Submarino$")
	public void que_acesso_o_site_do_Submarino() throws Throwable {
	    driver.get(url);
	    print("Passo 1 - Acessou o site do submarino");
	    System.out.println("que_acesso_o_site_do_Submarino"); 
	    
	}

	@When("^preencho o termo \"([^\"]*)\" e clico na Lupa$")
	public void preencho_o_termo_e_clico_na_Lupa(String termo) throws Throwable {
	  driver.findElement(By.id("h_search-input")).clear();
	  driver.findElement(By.id("h_search-input")).sendKeys(termo);
	  print("Passo 2 - Preencher o termo de busca");
	  driver.findElement(By.id("h_search-input")).sendKeys(Keys.ENTER); 
	  //driver.findElement(By.id("btnOK")).click();
	  System.out.println("preencho_o_termo_e_clico_na_lupa");
	  
	}

	@Then("^exibe a lista de produtos$")
	public void exibe_a_lista_de_produtos() throws Throwable {
	    assertEquals("Smartphone com Ofertas Incríveis no Submarino.com", driver.getTitle());
	    //assertEquals("smartphone", driver.findElement(By.cssSelector("ul.neemu-breadcrumb-container")).getText());
	    System.out.println("exibe_a_lista_de_produtos");
	    print("Passo 3.P - Exibiu a lista de produtos");
	}

	@Then("^exibe a mensagem de produto nao encontrado$")
	public void exibe_a_mensagem_de_produto_nao_encontrado() throws Throwable {
		
		assertTrue(driver.findElement(By.cssSelector("span[class='TextUI-sc-12tokcy-0 CIZtP']")).getText().contains("Não encontramos nenhum resultado para"));
	    //assertEquals("smartphone", driver.findElement(By.cssSelector("ul.neemu-breadcrumb-container")).getText());
	    print("Passo 3.N - Exibiu a lista de produtos");
	    Thread.sleep(3000);
	}
	

}
