package com.bamboo.selenium.tencent.qqspace.util;

import com.bamboo.selenium.tencent.qqspace.constant.Paths;
import com.bamboo.selenium.tencent.qqspace.entity.User;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @Author: GuoQing
 * @Date: 2019/3/27 17:42
 * @description qq空间工具类
 */
public interface QQSpaceUtil {


  WebDriver login(String username, String password);

  User getUser(WebDriver driver);


}
