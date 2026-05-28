package baseTestCases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    // Methods for reading CSV files from resources !!!
    // public class UnSuccessfulLogin extends TestUtils !!!
    // public class TestUtils extends DataProviders !!!
    @DataProvider(name = "wrongUsers")
    public Object[][] readWrongUsers() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2]; // number of columns in .csv file

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;

        } catch (IOException e) {
            System.out.println(e);
            return null;
        } catch (CsvException e) {
            System.out.println(e);
            return null;
        }
    }

    // public class ProductTest1 extends TestUtils !!!
    // public class TestUtils extends DataProviders !!!
    @DataProvider(name = "items to be added")
    public Object[] getItems() {
        return new Object[]{
                "backpack",
                "bike-light",
                "fleece-jacket"
        };
    }
}