package foo;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ExcelSheetHandle {
  @Test
 
  public void excelSheetMethod() throws BiffException, IOException, RowsExceededException, WriteException {
	  WebDriver driver = new FirefoxDriver();
		driver.get("https://wordpress.com/wp-login.php");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	/* 
	 // Read from existing excel
	Workbook book  = Workbook.getWorkbook(new File("./src/test/Data1.xls"));
	Sheet master = book.getSheet("Master");
	
	for(int row=1;row < master.getRows();row++)
	{
		for(int col=0; col < master.getColumns(); col++)
		{
			String cell= master.getCell(col, row).getContents();
			System.out.println(cell+":");
		}
	}
		
	String name = master.getCell(1, 1).getContents();
	
	System.out.println("Name: "+name);
	book.close();
	*/
	
		/*
		//Write/create one excel
	WritableWorkbook book1 = Workbook.createWorkbook(new File("./src/test/Created_Book_ByScript.xls"));
	WritableSheet sheet1 = book1.createSheet("Master", 0);
	
	Label l1=new Label(0, 0, "Name");
	Label l2=new Label(1,0,"Passwd");
	Label l3=new Label(0,1,"monadash");
	Label l4=new Label(1,1,"Secret123$");
	Label l5=new Label(0,2,"mona");
	Label l6=new Label(1,2,"dash$");
	
	
	sheet1.addCell(l1);
	sheet1.addCell(l2);
	sheet1.addCell(l3);
	sheet1.addCell(l4);
	sheet1.addCell(l5);
	sheet1.addCell(l6);
	
	book1.write();
	book1.close();
	
	Workbook book  = Workbook.getWorkbook(new File("./src/test/Created_Book_ByScript.xls"));
	Sheet master = book.getSheet("Master");
	
	for(int row=1;row < master.getRows();row++)
	{
		WebElement userLogin_txtbox = driver.findElement(By.id("user_login"));
		WebElement userPasswd_txtbox = driver.findElement(By.id("user_pass"));
		WebElement submit_btn = driver.findElement(By.id("wp-submit"));
		WebElement remember_chkbox = driver.findElement(By.id("rememberme"));

		userLogin_txtbox.sendKeys(master.getCell(0, row).getContents());
		userPasswd_txtbox.sendKeys(master.getCell(1, row).getContents());
		remember_chkbox.click();
		submit_btn.click();
		 
		
	}
		
	String name = master.getCell(1, 1).getContents();
	
	System.out.println("Name: "+name);
	book.close();
	*/
		
		
		Workbook bookread = Workbook.getWorkbook(new File("./src/test/Data1.xls"));
		WritableWorkbook writebook = Workbook.createWorkbook(new File("./src/test/Data1_copy.xls"), bookread);
		
		WritableSheet sheet = writebook.getSheet("Master");
	  
		Label l = new Label(4,4,"New Text added by Script");
		sheet.addCell(l);
		
		writebook.write();
		writebook.close();
		bookread.close();
		
  }
}
