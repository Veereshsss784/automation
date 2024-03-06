package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcel 
{
	public String BetaUSCUsername() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		Row row = page.getRow(1);
		Cell col = row.getCell(0);
		String Username1 = col.getStringCellValue();
        //System.out.println(Username);
        return Username1;
        
	}
	
	public String BetaUSCPassword() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		Row row = page.getRow(1);
		Cell col = row.getCell(1);
		String Password1 = col.getStringCellValue();
        //System.out.println(Password);
        return Password1;
        
	}
	public String BetaSVPUN() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		Row row = page.getRow(2);
		Cell col = row.getCell(0);
		String SVPUsername = col.getStringCellValue();
        //System.out.println(Username);
        return SVPUsername;
        
	}
	
	public String BetaSVPPwd() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		Row row = page.getRow(2);
		Cell col = row.getCell(1);
		String SVPPassword = col.getStringCellValue();
        //System.out.println(Username);
        return SVPPassword;
        
	}
	
	public String ProdSVPUN() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		Row row = page.getRow(3);
		Cell col = row.getCell(0);
		String SVPUsername = col.getStringCellValue();
        //System.out.println(Username);
        return SVPUsername;
        
	}
	
	public String ProdSVPPwd() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		Row row = page.getRow(3);
		Cell col = row.getCell(1);
		String SVPPassword = col.getStringCellValue();
        //System.out.println(Username);
        return SVPPassword;
        
	}
        
	

}
