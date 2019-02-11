package dataDriven;

import org.testng.annotations.DataProvider;

import jxl.read.biff.BiffException;
import utility.ExcelReader;

public class DataProviders {

	@DataProvider(name = "StrainPostData")
	public Object[][] orderEntryData() throws BiffException, Exception {
		Object[][] arrayObject = ExcelReader.getExcelData(DataFiles.StrainDataFile, "Strain");
		return arrayObject;
	}

	
	
}
