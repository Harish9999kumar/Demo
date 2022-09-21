package org.sdet40.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This class consists all java reusable actions
 * 
 * @author Harish
 *
 */
public class JavaUtility {
	/**
	 * This method is used to generate the random number
	 */
	public static int getRanDomNum(int index) {
		Random randNum = new Random();
		int ranDomNum = randNum.nextInt(index);
		System.out.println(ranDomNum);
		return ranDomNum;
	}
	/**
	 * This method is used to
	 */
	public void CompareExpectedResulttWithActual(WebElement element, String expectedCode) {

		if (element.getText().trim().contains(expectedCode.trim())) {
			System.out.println("Class Is Created With Given Code");
		} else {
			System.out.println("Class Is Not Created With Given Code Code");

		}
	}

	public void waitingCondition() throws InterruptedException {
		Thread.sleep(1000);
	}
	/**
	 * This method is used to convert the current date and time into "dd_MM_yyyy_hh_mm_sss"
	 * @return 
	 */
	public String currentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actualDate=sdf.format(date);
		return actualDate;
		
	}
}
