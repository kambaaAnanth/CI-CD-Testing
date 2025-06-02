package com.facebook.app.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        // Options below are often recommended for CI environments
        options.addArguments("--window-size=1920,1080"); // Set a default window size
        options.addArguments("--disable-gpu"); // Often recommended for headless
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-setuid-sandbox"); // Another sandbox related argument
        options.addArguments("--remote-debugging-port=9222");
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
