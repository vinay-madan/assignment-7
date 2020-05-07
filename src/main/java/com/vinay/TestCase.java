package com.vinay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Test
public class TestCase {

    private static String OS = System.getProperty("os.name", "unknown").toLowerCase(Locale.ROOT);

    public static boolean isWindows()
    {
        return OS.contains("win");
    }

    public static boolean isMac()
    {
        return OS.contains("mac");
    }

    public static boolean isUnix()
    {
        return OS.contains("nux");
    }

    public void search() {

        if ( isWindows() ) {

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        } else if ( isUnix() ) {

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux");

        } else if ( isMac() ) {

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://bing.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("sb_form_q")).sendKeys("intellipaat");
        driver.findElement(By.id("sb_form_q")).sendKeys(Keys.TAB);
        driver.findElement(By.id("sb_form_q")).sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String title =  driver.getTitle();
        System.out.println(title);
        driver.quit();

    }

    public static void main(String[] args) {

        TestCase tc = new TestCase();
        tc.search();
    }
}
