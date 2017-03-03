package Tests;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by amey.rajapure on 3/3/2017.
 */
public class getTestDataFromExcel {
    int iRowNum, iLastRowNum, iLastColNum;
    String sTCID;

    public ArrayList<String> getTestData(String sSheetName, String TestCaseId) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\amey.rajapure\\Desktop\\TestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheet(sSheetName);
        DataFormatter dataFormatter = new DataFormatter(); //creating formatter using the default locale

        /*DataFormatter objDefaultFormat = new DataFormatter();
        FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator(wb);
*/
        ArrayList<String> sArryLstTestData = new ArrayList<String>();

        try{
            iLastRowNum = ws.getLastRowNum();
            iLastColNum = ws.getRow(1).getLastCellNum();

            //Finding the row in which data for the required test case is present
            for(int rowCounter = 0; rowCounter <= iLastRowNum; rowCounter++){
                sTCID = ws.getRow(rowCounter).getCell(0).getStringCellValue();
                if(sTCID.equalsIgnoreCase(TestCaseId)){
                    iRowNum = rowCounter;
                    break;
                }
            }

            //Fetching data present in the row
            for (int colCounter = 1; colCounter <= iLastColNum; colCounter++){
                Cell currentCell = ws.getRow(iRowNum).getCell(colCounter);
                String sColData = dataFormatter.formatCellValue(currentCell);
                sArryLstTestData.add(sColData);
            }
        }
        catch (Exception e){
            System.out.println("Error in reading excel file: " +e);
        }

        wb.close();
        return sArryLstTestData;
    }
}
