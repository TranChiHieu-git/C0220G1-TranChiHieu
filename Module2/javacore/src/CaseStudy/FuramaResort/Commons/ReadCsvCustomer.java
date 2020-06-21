package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCsvCustomer {
    public ArrayList<Customer> readCsvCustomer() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\codegym\\CodeGym\\Module2\\" +
                "C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Customer.csv"));
        ArrayList<Customer> listCustomer = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            Customer custom = new Customer(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4],
                    splitData[5], splitData[6], splitData[7]);
            listCustomer.add(custom);
        }
        listCustomer.sort(new NameBirthdayComparator());
        return listCustomer;
    }
}
