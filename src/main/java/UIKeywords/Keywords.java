package UIKeywords;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Keywords {
	
	public static void iterateAndSelect(List<WebElement> list, String txt) {
		Iterator itr=list.iterator();
		for (WebElement object : list) {
			if(object.getText().equalsIgnoreCase(txt)) {
				object.click();
				break;
			}
		}
		
	}

	public static void selectOption(WebElement selectMonth, String month) {
		Select select=new Select(selectMonth);
		select.selectByVisibleText(month);
	}

}
