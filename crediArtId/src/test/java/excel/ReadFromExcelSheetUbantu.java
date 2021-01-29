package excel;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelSheetUbantu

 {

public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException 

	{

		String str="\\home\\RedirectError.ods";
		FileInputStream file=new FileInputStream(str);
		Workbook book = WorkbookFactory.create(file);

		Sheet sheet = book.getSheetAt(1);

		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)

		{

			  Row row = sheet.getRow(rowIndex);

			  if (row != null) 

			  {

				  //for(int colIndex=0; colIndex <row.getLastCellNum();colIndex++)
				  for(int colIndex=0; colIndex <1;colIndex++)
				  {

					  Cell cell = row.getCell(colIndex);

					    if (cell != null) 

					    {

					      String cellValueMaybeNull = cell.getStringCellValue();
					      System.out.print("HTC "+cellValueMaybeNull+"\n");
					      verifyLinkActive(cellValueMaybeNull);
					      
					      
					    }

				  }


			  }

			}	

	}
//
static int count=0;
static int countInvalid=0; 
public static void verifyLinkActive(String linkUrl)
	{
      try 
      {
         URL url = new URL(linkUrl);
         
         HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
         
         httpURLConnect.setConnectTimeout(5000);
         
         httpURLConnect.connect();
         
         if(httpURLConnect.getResponseCode()==200)
         {
      	   count++;
             System.out.println(count+" "+linkUrl+" - "+httpURLConnect.getResponseMessage()+"\n");
          }
         //else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) 
         else
         {
      	   count++;
      	   countInvalid++;
             System.out.println(count+" "+linkUrl+" - "+httpURLConnect.getResponseMessage() +httpURLConnect.getResponseCode()+"\n");
          }
      } catch (Exception e) {
         
      }
  } 
  
  
  //


}
