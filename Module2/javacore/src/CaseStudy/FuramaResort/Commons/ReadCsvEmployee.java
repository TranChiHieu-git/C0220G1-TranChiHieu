package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadCsvEmployee {
    public Map<String, Employee> readCsvEmployee() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\codegym\\CodeGym\\Module2\\" +
                "C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Employee.csv"));
        Map<String, Employee> mapEmployee = new TreeMap<>();
        ArrayList<Employee> listEmployee = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            Employee employee = new Employee(splitData[0],splitData[1], Integer.parseInt(splitData[2]), splitData[3]);
            listEmployee.add(employee);
        }
        for (Employee employee: listEmployee){
            mapEmployee.put(employee.getId(), employee);
        }
        return mapEmployee;
    }
}
