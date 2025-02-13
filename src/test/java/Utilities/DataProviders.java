package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
 @DataProvider(name="userdata")
 public String[][] send_data() throws IOException
 {	
	 String path=".\\test-data\\user_credentials.xlsx";
	 ExcelUtility util=new ExcelUtility(path);
	 int rows=util.getRowCount("Sheet1");
	 int columns=util.getCellCount("Sheet1",1);
	 String[][] data=new String[rows][columns];
	 for(int i=1;i<rows;i++)
	 {
		 for(int j=0;j<columns;j++)
		 {
			 data[i-1][j]=util.getCellData("Sheet1", i, j);
		 }
	 }
	return data;
	 
 }
}
