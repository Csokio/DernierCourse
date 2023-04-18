import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablePage extends Pages{

    public TablePage(WebDriver driver)
    {
        super(driver);
    }

    String url = "https://demo.seleniumeasy.com/table-pagination-demo.html";

    private final By BUTTON_NEXT = By.xpath("//a[@class='next_link']");
    private final By ROWS = By.xpath("//tbody[@id='myTable']/tr[@style='display: table-row;']");

    public void navigateTo()
    {
        driver.navigate().to(url);
    }

    public void clickOnNext()
    {
        driver.findElement(BUTTON_NEXT).click();
    }

    public boolean isButtonDisplayed()
    {
        //return driver.findElement(BUTTON_NEXT).getAttribute("style").equals("display: block;");
        WebElement nextButton = driver.findElement(BUTTON_NEXT);
        String style = nextButton.getAttribute("style");
        return !style.equals("display: none;");
    }

    public void getNumbersFromTable(List<Integer> numbersList)
    {
        List<WebElement> rowsList = driver.findElements(ROWS);
        for(WebElement row: rowsList){
            Integer tableNumber = Integer.valueOf(row.findElement(By.xpath("./td[1]")).getText());
            numbersList.add(tableNumber);
        }
    }
}
