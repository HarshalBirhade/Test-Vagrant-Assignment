package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Fetch Data of Pushpa from wikipedia website like Release Date and Country Origin

public class WIKI_class {
	// Fetch Release Date Webelement
	@FindBy(xpath = "//li[contains(text(),\"December\")]")
	private WebElement rd2;

	// Fetch country origin webelement
	@FindBy(xpath = "//td[contains(text(),\"India\")]")
	private WebElement con2;

	public WIKI_class(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Get text of Release Date
	public String ReleaseDate() {
		String RDWIKI = rd2.getText(); // 17 December 2021
		return RDWIKI;
	}

	// Get text of country
	public String Country() {
		String CONWIKI = con2.getText(); // India
		return CONWIKI;
	}
}
