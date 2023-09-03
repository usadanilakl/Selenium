package com.cydeo.fidelity;

import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Next {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.create("Chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        ArrayList<String> links = new ArrayList<>();
        int page = 0;

        for (int i = 0; i < 10; i++) {

            driver.get("https://finance.yahoo.com/screener/unsaved/3a1a2022-d27c-4c6e-b918-c99a5dfbce1b?count=25&offset="+page);
            Thread.sleep(2000);
            ArrayList<WebElement> stocks = new ArrayList<>();
            stocks.addAll(driver.findElements(By.xpath("//table[@class='W(100%)']//a")));
            Thread.sleep(2000);
            page+=25;


            for (WebElement stock : stocks) {
                links.add(stock.getAttribute("href"));
                System.out.println("links.size() = " + links.size());
            }

            //driver.findElement(By.xpath("//button//span[.='Next']")).click();

        }

        System.out.println("links.size() = " + links.size());
    }
}
