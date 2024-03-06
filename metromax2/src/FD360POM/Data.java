package FD360POM;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Data {

	public static void main(String[] args) throws Exception
	{
		File file=new File("C:\\Users\\Veeresh Salagar\\Desktop\\data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		String cellvalue=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cellvalue);
		String cellvalue2=sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(cellvalue2);
		workbook.close();
		fis.close();
		
		
		
	}
}