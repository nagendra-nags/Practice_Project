package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelExample {
	public static void main(String[] args) throws Throwable {
		
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Data\\Test Data.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet s = book.getSheet("Sheet3");
	int lastRow = s.getLastRowNum();
	short lastCell = s.getRow(s.getLastRowNum()).getLastCellNum();
	System.out.println(lastRow);
	
	for(int i=0;i < lastRow;i++)
	{
		for (int j = 0; j < lastCell; j++) {
			
			//if there is no if condition it will all row(headers also)
			if(i%2 != 0) {
				
					String value = s.getRow(i).getCell(j).toString();
					System.out.print(value+":");
					
			}
			
		}
	}
	
	}
}
