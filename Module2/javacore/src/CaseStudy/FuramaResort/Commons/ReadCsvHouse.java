package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.House;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ReadCsvHouse {
    BufferedReader fileReader = new BufferedReader(new FileReader("C:\\codegym\\CodeGym\\Module2\\" +
            "C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\House.csv"));
    ArrayList<House> listHouse = new ArrayList<>();
    TreeSet<String> listHouseNotDuplicate = new TreeSet<>();


    public ReadCsvHouse() throws FileNotFoundException {
    }

    public ArrayList<House> readCsvHouse() throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            House house = new House(splitData[0],
                    splitData[1],
                    Double.parseDouble(splitData[2]),
                    Double.parseDouble(splitData[3]),
                    Integer.parseInt(splitData[4]),
                    splitData[5],
                    splitData[6],
                    splitData[7],
                    Integer.parseInt(splitData[8]
                    ));
            listHouse.add(house);
        }
        return listHouse;
    }

    public TreeSet<String> readCsvHouseNotDuplicate() throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            listHouseNotDuplicate.add(splitData[1]);
        }
        return listHouseNotDuplicate;
    }
}
