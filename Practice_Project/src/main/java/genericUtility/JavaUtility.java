package genericUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		 Random ran= new Random();
			int random=ran.nextInt(500);
			return random;
	}
	
	public String getsystemdate()
	{
		Date date = new Date();
		String currentdate = date.toString();
		System.out.println(currentdate);
		String[] arr = currentdate.split(" ");
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
		String value = yyyy+"-"+mm+"-"+dd;
		return value;
	}
	
	
	

}
