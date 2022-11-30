package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Fetch Data of Pushpa from IMDB website like Release Date and Country Origin
public class IMDB_class {
	// Fetch Release Date Webelement
	@FindBy(xpath = "//a[contains(text(),\"United\")]")
	private WebElement date;

	// Fetch country origin webelement
	@FindBy(xpath = "//a[text()=\"India\"]")
	private WebElement country;

	public IMDB_class(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	// Get text of Release Date
	public String ReleaseDate() {
		String RDIMDB = date.getText(); // December 17, 2021 (United States)
		return RDIMDB;
	}

	// Get text of country
	public String Country() {
		String COUNIMDB = country.getText(); // India
		return COUNIMDB;
	}
}
