package org.test;

import static org.testng.Assert.assertEquals;

import org.baseClass.BaseClass;
import org.testng.annotations.Test;

public class TestCase extends BaseClass

{
	public boolean actual;

	@Test(dataProvider = "credentials")

	public void tc1(String userName2, String passWord2) {
		page.giveUserName(userName2);
		page.givePassWord(passWord2);
		page.loginButton();
		String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actual = driver.getCurrentUrl();
		assertEquals(actual, expected);

	}

}
