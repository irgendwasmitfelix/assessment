package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String fs = System.getProperty("file.separator");
	public static Logger log = LogManager.getLogger(TestBase.class);
	public static int timestamp = (int) (new Date().getTime()/1000);

	public static WebDriverWait wait;

	public static void initialization() {
		log.info("Initialization Test...");
		log.info("TimeStamp: "+timestamp);
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ fs + "src" + fs + "main" + fs + "java" + fs + "config" + fs + "config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Browser Open");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
}
