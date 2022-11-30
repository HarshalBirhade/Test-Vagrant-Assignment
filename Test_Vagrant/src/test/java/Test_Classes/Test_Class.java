package Test_Classes;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import POM_Classes.IMDB_class;
import POM_Classes.WIKI_class;

public class Test_Class {
	WebDriver driver;
	IMDB_class imdb;
	WIKI_class wiki;

	@BeforeTest
	public void openimdb() // Open Pushpa Movie on IMDB site
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		imdb = new IMDB_class(driver);
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().window().minimize();
	}

	@BeforeTest
	public void openwiki() // Open Pushpa Movie on wikipedia site
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wiki = new WIKI_class(driver);
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		driver.manage().window().minimize();
	}

	@Test
	public void rdcompare() {
		String releaseIMDB = imdb.ReleaseDate(); // December 17, 2021 (United States)
		System.out.println("Release Date on IMDB: " + releaseIMDB);

		String releaseWIKI = wiki.ReleaseDate(); // 17 December 2021
		System.out.println("Release Date on WIKI: " + releaseWIKI);

		// Release date on both website is same but formatting is different thats why
		// this @Test will failed
		Assert.assertEquals(releaseIMDB, releaseWIKI);
	}

	@Test
	public void countrycompare() {
		String counIMDB = imdb.Country(); // India
		String counWIKI = wiki.Country(); // India
		System.out.println("Country on IMDB: " + counIMDB);
		System.out.println("Country on WIKI: " + counWIKI);

		// Country of movie on both website is so this @Test will passed
		Assert.assertEquals(counIMDB, counWIKI);
	}

}
