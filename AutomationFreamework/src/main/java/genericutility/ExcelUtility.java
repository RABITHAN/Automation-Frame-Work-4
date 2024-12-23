package genericutility;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author ADMIN
 */
public class ExcelUtility {
	
	/**
	 * This method takes sheetName,rowIndex,column Index as an argument and returns value present in the cell 
	 * @param sheetName
	 * @param rowIndex
	 * @param collIndex
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getStringDataFromExcel(String sheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resource/TestData/TestScriptData.x1sx");
    	Workbook Workbook=WorkbookFactory.create(fis);
    	return Workbook.getSheet(sheetName).getRow(rowIndex).getCell(collIndex).getStringCellValue();
		
	}
    public boolean getBooleanDataFromExcel(String SheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException
{
    	
    	FileInputStream fis = new FileInputStream("./src/test/resource/TestData/TestScriptData.x1sx");
    	Workbook Workbook=WorkbookFactory.create(fis);
    	return Workbook.getSheet(SheetName).getRow(rowIndex).getCell(collIndex).getBooleanCellValue();
    	}
    public double getNumberDataFromExcel(String SheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException
    {
        	
        	FileInputStream fis = new FileInputStream("./src/test/resource/TestData/TestScriptData.x1sx");
        	Workbook Workbook=WorkbookFactory.create(fis);
        	return Workbook.getSheet(SheetName).getRow(rowIndex).getCell(collIndex).getNumericCellValue();
        	}
    public LocalDateTime getDataFromExcel(String SheetName,int rowIndex,int collIndex) throws EncryptedDocumentException, IOException
    {
        	
        	FileInputStream fis = new FileInputStream("./src/test/resource/TestData/TestScriptData.x1sx");
        	Workbook Workbook=WorkbookFactory.create(fis);
        	return Workbook.getSheet(SheetName).getRow(rowIndex).getCell(collIndex).getLocalDateTimeCellValue();
        	}
}
