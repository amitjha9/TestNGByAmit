package org.testng.DataProvider;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DataProviderExcelTest {


    @Test(dataProvider = "getData")
    public void dataProviderTest(String name, String emailId, String address, String gender) {

        System.out.println("Name:" + name + " EmailID:" + emailId + " Address:" + address + " Gen:" + gender);
    }


    @DataProvider
    public Iterator<Object[]> getData() {
        ArrayList<Object[]> testData = getDataFromExcel();
        return testData.iterator();
    }

    public ArrayList<Object[]> getDataFromExcel() {
        String path = System.getProperty("user.dir") + "/TestData/" + "/StudentData.xlsx";
        ArrayList<Object[]> testData = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(1).getLastCellNum();
            for (int i = 1; i <= rowNum; i++) {
                XSSFRow row = (XSSFRow) sheet.getRow(i);
                for (int j = 0; j < colNum; j++) {
                    XSSFCell cell = row.getCell(j);
                    String name = cell.getStringCellValue();
                    String email = cell.getStringCellValue();
                    String address = cell.getStringCellValue();
                    String gender = cell.getStringCellValue();
                    Object ob[] = {name, email, address, gender};
                    testData.add(ob);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }
}
