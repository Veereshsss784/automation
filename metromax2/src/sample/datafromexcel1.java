package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class datafromexcel1 {

	@SuppressWarnings("unused")
	@Test
	private static void test() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./poi/data.xlsx");
		Workbook open = WorkbookFactory.create(fis);
		Sheet page = open.getSheet("Sheet1");
		
		Row row = page.getRow(0);
		Cell col = row.getCell(0);
		String Username = col.getStringCellValue();
		System.out.println(Username);
	}
	@Test
	private static void test2() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./poi/data.xlsx");
		Workbook open1 = WorkbookFactory.create(fis);
		Sheet page1 = open1.getSheet("Sheet1");
		Row row1 = page1.getRow(0);
		Cell col1 = row1.getCell(1);
		String Password = col1.getStringCellValue();
		System.out.println(Password);
	/*	for (int i = 0; i < 5; i++) {
			Row row = page.getRow(i);
			Cell col = row.getCell(0);
			String Email = col.getStringCellValue();
			System.out.println(Email);
		}  */

	
	}
		
		}

