package com.cydeo.fidelity;

import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.input.model.MouseButton;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class NewTab {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverFactory.create("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        int page = 0;


        ArrayList<String> links = new ArrayList<>();



        for (int i = 0; i < 5; i++){
            ArrayList<WebElement> stocks = new ArrayList<>();
            driver.get("https://finance.yahoo.com/screener/unsaved/6067d009-610b-4837-bc60-53e86f9f3a11?count=25&offset="+page);
            Thread.sleep(3000);
            stocks.addAll(driver.findElements(By.xpath("//table[@class='W(100%)']//a")));
            page+=25;


            for (WebElement stock : stocks){
                links.add(stock.getAttribute("href"));

            }
        }

        System.out.println("links.size() = " + links.size());
        for (String link : links){
            driver.get(link);
            driver.findElement(By.linkText("Financials")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='Fw(500) D(ib) Pend(10px) H(18px) BdEnd Bdc($seperatorColor)']/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[.='Quarterly']")).click();
            Thread.sleep(3000);

            ArrayList<WebElement>data = new ArrayList<>(driver.findElements(By.xpath("//div[@class='D(tbrg)']/div/div[@class='D(tbr) fi-row Bgc($hoverBgColor):h']")));

            for (WebElement d : data) {
                ArrayList<Integer> nums = new ArrayList<>();
                if (d.getText().contains("Net Tangible Assets")) {
                    String assets = d.getText().replaceFirst("Net Tangible Assets", "").replaceAll(",", "").replaceAll("\n", "");

                    for (int j = 0; j < 4; j++) {

                        String cut = assets.substring(0, assets.indexOf(" ") + 1).replaceAll(" ", "");
                        assets = assets.replaceFirst(cut + " ", "");
                        try {
                            nums.add(Integer.valueOf(cut));
                        } catch (NumberFormatException e) {
                            System.out.print("");
                        }
                    }

                    boolean one;
                    boolean two;
                    boolean three;
                    boolean total;

                    if(nums.size() == 4){
                        one = nums.get(1) * 1.3 < nums.get(0);
                        two = nums.get(2) * 1.3 < nums.get(0);
                        three = nums.get(3) * 1.3 < nums.get(0);
                        total = (one||two||three) && nums.get(0)>0;
                    } else if(nums.size()==3){
                        one = nums.get(1) * 1.3 < nums.get(0);
                        two = nums.get(2) * 1.3 < nums.get(0);
                        total = (one||two) && nums.get(0)>0;
                    }else if(nums.size()==2){
                        one = nums.get(1) * 1.3 < nums.get(0);
                        total = one && nums.get(0)>0;
                    } else {
                        total=false;
                    }


                    if (total) {
                        System.out.println("nums = " + nums);
                        System.out.println(link);

                    } else {
                        System.out.print("");

                    }
                }
            }
        }




        //js.executeScript("window.open()");

    }


}
