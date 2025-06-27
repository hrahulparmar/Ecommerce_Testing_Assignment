package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVDataProvider {
	
	 public static Object[][] readCSVData(String filePath) {
	        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
	            List<String[]> data = reader.readAll();
	            
	            // Convert List<String[]> to Object[][]
	            Object[][] testData = new Object[data.size()][];
	            for (int i = 0; i < data.size(); i++) {
	                testData[i] = data.get(i);
	            }
	            return testData;
	        } catch (IOException | CsvException e) {
	            throw new RuntimeException("Error reading CSV file: " + filePath, e);
	        }
	    }

}
