package Utilities;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcelFile {
	
	
	//public static Cell cell;

	public static String getcellvalue(String filePath,String sheetName,int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		try
		{
			FileInputStream file=new FileInputStream(filePath);
			Sheet Sheet = WorkbookFactory.create(file).getSheet(sheetName);
					String value = Sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
  
		        return value;
		}
		catch(Exception e)
		{
			return " ";
		}
	}
		public static int getRowCount(String filepath, String sheetName)
		{
			try
			{
				FileInputStream file=new FileInputStream(filepath);
				Sheet sheet = WorkbookFactory.create(file).getSheet(sheetName);
			      int ttlRows=sheet.getLastRowNum()+1;
				  return ttlRows;
			}
			catch(Exception e)
			{
				return 0;
			}
		}
			public static int getcolCount(String filepath, String sheetName)
			{
				try
				{
					 FileInputStream inputfile=new FileInputStream(filepath);
					Sheet  workbook = WorkbookFactory.create(inputfile).getSheet(sheetName);
					 int ttlCells =workbook.getRow(0).getLastCellNum()+1;
					 return ttlCells;
				}
				catch(Exception e)
				{
					return 0;
				}
				}
		}
