package com.bamboo.selenium.tencent.qqspace.util;

import com.bamboo.selenium.tencent.qqspace.constant.Paths;
import com.bamboo.selenium.tencent.qqspace.entity.User;
import com.bamboo.selenium.util.StringUtils;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

/**
 * @Author: GuoQing
 * @Date: 2019/3/27 17:51
 * @description qq空间工具类实现类
 */
@Service
public class QQSpaceUtilImpl implements QQSpaceUtil {

  WebElement webElement;

  @Override
  public WebDriver login(String username, String password) {
    WebDriver driver;
    WebElement webElement;
    System.setProperty("webdriver.chrome.driver","src/main/resources/lib/chromedriver/chromedriver2_8.exe");
    File dataDir = new File("src/main/resources/lib/chromedriver/chromedriver2_8.exe" + File.separator + UUID.randomUUID().toString());
    if (!dataDir.exists()) {
      dataDir.mkdirs();
    }
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=", dataDir.getAbsolutePath());
    driver = new ChromeDriver(options);
    driver.manage().deleteAllCookies();
    //设置隐性等待时间
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    //打开一个站点
    driver.get(Paths.QQ_SPACE_LOGIN);
    driver.switchTo().frame("login_frame");
    webElement = driver.findElement(By.id("switcher_plogin"));
    webElement.click();
    webElement = driver.findElement(By.name("u"));
    webElement.sendKeys(username);
    webElement = driver.findElement(By.name("p"));
    webElement.sendKeys(password);
    webElement = driver.findElement(By.id("login_button"));
    webElement.click();
    return driver;
  }

  @Override
  public User getUser(WebDriver driver) {
    User user = new User();
    String currentUrl = driver.getCurrentUrl();
    String[] split = currentUrl.split("/");
    if (StringUtils.isNotBlank(split[3]) && StringUtils.isNumeric(split[3])) {
      user.setQq(split[3]);
      webElement = driver.findElement(By.linkText("个人档"));
      webElement.click();
      webElement = driver.findElement(By.name("app_canvas_frame"));
      driver.switchTo().frame(webElement);
      user.setAge(Integer.valueOf(driver.findElement(By.id("age")).getText()));
      user.setGender(driver.findElement(By.id("sex")).getText());
      user.setBirth(driver.findElement(By.id("birthday")).getText());
      user.setConstellation(driver.findElement(By.id("astro")).getText());
      user.setCurrentResidence(driver.findElement(By.id("live_address")).getText());
      user.setBloodGroup(driver.findElement(By.id("blood")).getText());
      user.setHome(driver.findElement(By.id("hometown_address")).getText());
      user.setCareer(driver.findElement(By.id("career")).getText());
      user.setAvatar(driver.findElement(By.id("user_icon")).getAttribute("src"));
      user.setNickname(driver.findElement(By.id("nickname_n")).getText());
      driver.switchTo().defaultContent();
      webElement = driver.findElement(By.xpath("//*[@id=\"menuContainer\"]/div/ul/li[1]/a"));
      webElement.click();
      user.setPhotoNumber(driver.findElement(By.id("QM_Profile_Photo_Cnt")).getText());
      user.setTalkAboutNumber(driver.findElement(By.id("QM_Profile_Mood_Cnt")).getText());
      user.setLogNumber(driver.findElement(By.id("QM_Profile_Blog_Cnt")).getText());
    }
    return user;
  }


}
