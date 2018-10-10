package com.castor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

	/*public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Castor\\duliday\\resources\\chromedriver_win32\\chromedriver.exe");//chromedriver服务地址
		WebDriver driver =new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动
		driver.get("http://www.baidu.com");//打开指定的网站
		driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//找到kw元素的id，然后输入hello
		driver.findElement(By.id("su")).click(); //点击按扭
		try {
			*//**
			 * WebDriver自带了一个智能等待的方法。
			 dr.manage().timeouts().implicitlyWait(arg0, arg1）；
			 Arg0：等待的时间长度，int 类型 ；
			 Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
			 *//*
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*//**
		 * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
		 * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
		 * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit最为一个case退出的方法。
		 *//*
		//driver.quit();//退出浏览器
	}*/

	static String baseUrl="http://www.qyer.com";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Castor\\duliday\\resources\\chromedriver_win32\\chromedriver.exe");
		File logFile = new File("d://logFile.txt");
		if(!(logFile.exists())) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);

		//获取所有a标签
		List<WebElement> aList = driver.findElements(By.tagName("a"));
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//便利所有标签
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(logFile);
			for (WebElement a : aList) {


				//获取a标签href属性值
				String urlStr = a.getAttribute("href");
				System.out.println(urlStr);//获取a标签中的URL
				if(!urlStr.contains("place")) {
					urlStr +="\r\n";
					//将URL写入文件中
					fs.write(urlStr.getBytes());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fs != null){
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			driver.quit();//退出浏览器
		}
	}

}
