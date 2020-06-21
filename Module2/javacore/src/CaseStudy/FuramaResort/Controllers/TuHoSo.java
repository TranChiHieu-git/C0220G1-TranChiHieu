package CaseStudy.FuramaResort.Controllers;

import CaseStudy.FuramaResort.Commons.ReadCsvEmployee;
import CaseStudy.FuramaResort.Models.Employee;

import java.io.IOException;
import java.util.*;

public class TuHoSo {
    public Stack<String> stackHoSo() throws IOException {
        Stack<String> listEmployee = new Stack<>();
        ReadCsvEmployee readCsvEmployee = new ReadCsvEmployee();
        Map<String, Employee> mapEmployee = readCsvEmployee.readCsvEmployee();
        for (Map.Entry<String, Employee> entry : mapEmployee.entrySet()) {
            listEmployee.push(entry.getValue().toString());
        }
        return listEmployee;
    }
}
