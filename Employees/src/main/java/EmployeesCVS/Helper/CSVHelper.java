package EmployeesCVS.Helper;

import EmployeesCVS.model.Employees;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Component
public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Name","Email","Phone Number" };

    public static List<Employees> csvToEmployees() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resourcesstatic/uploads/Employees.csv"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){

            List<Employees> employees = new ArrayList<Employees>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Employees employee = new Employees(
                        csvRecord.get(0),
                        csvRecord.get(1),
                        Integer.parseInt(csvRecord.get(2) ));
                employees.add(employee);
            }
            return employees;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}

