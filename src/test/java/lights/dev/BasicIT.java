package lights.dev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicIT extends DriverBase{

    private ExpectedCondition<Boolean> pageTitleStartsWith (final String searchString)
    {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }
    private void googleExamplesThatSearchFor(final String searchString)
    {
        WebDriver driver = DriverBase.getDriver();
        driver.get("http://google.com");
        WebElement searchField= driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(searchString);

        System.out.println("Page title is "+driver.getTitle());
        searchField.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith(searchString));

        System.out.println("Page title is "+driver.getTitle());
    }

    @Test
    public void googleCheeseExample()
    {
        googleExamplesThatSearchFor("cheese!");
    }
    @Test
    public void googleMilkExample()
    {
        googleExamplesThatSearchFor("milk!");
    }
   /* @Test
    public void googleBurguerExample()
    {
        googleExamplesThatSearchFor("burguer!");
    }
    @Test
    public void googleHotDogExample()
    {
        googleExamplesThatSearchFor("hotdog!");
    }
    @Test
    public void googleICecreamExample()
    {
        googleExamplesThatSearchFor("Icecream!");
    }
    @Test
    public void googlePizzaExample()
    {
        googleExamplesThatSearchFor("pizza!");
    }
    @Test
    public void googlePastaExample()
    {
        googleExamplesThatSearchFor("pasta!");
    }
    @Test
    public void googleChocolateExample()
    {
        googleExamplesThatSearchFor("chocolate!");
    }
    @Test
    public void googleFruitExample()
    {
        googleExamplesThatSearchFor("fruit!");
    }
    @Test
    public void googleMeatExample()
    {
        googleExamplesThatSearchFor("meat!");
    }*/
}
