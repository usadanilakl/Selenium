package com.cydeo.fidelity;

import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Assets {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.create("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://finance.yahoo.com/screener/unsaved/76f2e6d4-7d33-47d7-a9a6-fe3986d568e5");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
        
        ArrayList<WebElement> stocks = new ArrayList<>(driver.findElements(By.xpath("//table[@class='W(100%)']//a")));
        for (WebElement stock : stocks){
            String link = "";
            try {
                link = stock.getAttribute("href");
            }catch (StaleElementReferenceException e){
                System.out.println("Stale element exception");
            }

                stock.click();
                driver.findElement(By.linkText("Financials")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//div[@class='Fw(500) D(ib) Pend(10px) H(18px) BdEnd Bdc($seperatorColor)']/span")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[.='Quarterly']")).click();
                Thread.sleep(3000);

                ArrayList<WebElement>data = new ArrayList<>(driver.findElements(By.xpath("//div[@class='D(tbrg)']/div/div[@class='D(tbr) fi-row Bgc($hoverBgColor):h']")));

                for (WebElement d : data){
                    if (d.getText().contains("Net Tangible Assets")){
                        String assets = d.getText().replaceFirst("Net Tangible Assets", "").replaceAll(",","").replaceAll("\n", "");
                        ArrayList<Integer> nums = new ArrayList<>();
                        for (int i=0; i < 4; i++){
                            String cut = assets.substring(0, assets.indexOf(" ")+1).replaceAll(" ", "");
                            assets = assets.replaceFirst(cut + " ", "");
                            try {
                                nums.add(Integer.valueOf(cut));
                            }catch (NumberFormatException e) {
                                System.out.println("not a number");
                            }
                        }
                        //System.out.println("nums = " + nums);
                        boolean one = nums.get(1)*0.3 < nums.get(0);
                        boolean two = nums.get(2)*0.3 < nums.get(0);
                        boolean three = nums.get(3)*0.3 < nums.get(0);
                        if(one || two || three){
                            System.out.println(link);

                        } else {
                            System.out.println("No match found");
                            driver.navigate().back();
                            driver.navigate().back();
                            driver.navigate().back();
                        }
                    }
                }




        }

    }
}
