package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.Villa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;


public class ReadCsvVilla {
    BufferedReader fileReader = new BufferedReader(new FileReader("C:\\codegym\\CodeGym\\Module2\\" +
            "C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Villa.csv"));
    ArrayList<Villa> listVilla = new ArrayList<>();
    TreeSet<String> listVillaNotDuplicate = new TreeSet<>();


    public ReadCsvVilla() throws FileNotFoundException {
    }

    public ArrayList<Villa> readCsvVilla() throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            Villa villa = new Villa(splitData[0],
                    splitData[1],
                    Double.parseDouble(splitData[2]),
                    Double.parseDouble(splitData[3]),
                    Integer.parseInt(splitData[4]),
                    splitData[5],
                    splitData[6],
                    splitData[7],
                    Double.parseDouble(splitData[8]),
                    Integer.parseInt(splitData[9]
                    ));
            listVilla.add(villa);
        }
        return listVilla;
    }

    public TreeSet<String> readCsvVillaNotDuplicate() throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            listVillaNotDuplicate.add(splitData[1]);
        }
        return listVillaNotDuplicate;
    }
}

