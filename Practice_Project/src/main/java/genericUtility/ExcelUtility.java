package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getdata(String sheet, int row, int col) throws Exception
	{
		String d=null;
		FileInputStream file= new FileInputStream(".\\Data\\Test Data.xlsx");
		Workbook book = WorkbookFactory.create(file);
		d = book.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		return d;
	}


}
