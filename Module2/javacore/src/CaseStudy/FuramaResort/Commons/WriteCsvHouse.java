package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.House;

import java.io.*;
import java.util.ArrayList;

public class WriteCsvHouse {
    private static final String DAU_PHAY = ",";
    private static final String DONG_MOI = "\n";
    FileWriter fileHouse = null;

    public void WriteCsvHouseFile(ArrayList<House> listHouse) throws IOException {
        fileHouse = new FileWriter("C:\\codegym\\CodeGym\\Module2\\C0220G1-TranChiHieu-Module2\\" +
                "src\\CaseStudy\\FuramaResort\\Data\\House.csv");
        for (House house : listHouse) {
            fileHouse.append(house.getId())
                    .append(DAU_PHAY)
                    .append(house.getNameServices())
                    .append(DAU_PHAY)
                    .append(String.valueOf(house.getAreaUsed()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(house.getRental()))
                    .append(DAU_PHAY)
                    .append(Integer.toString((int) house.getMaxNumberOfPeople()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(house.getTypeOfRent()))
                    .append(DAU_PHAY)
                    .append(house.getRoomStandard())
                    .append(DAU_PHAY).
                    append(house.getDescriptionOfOtherAmenities())
                    .append(DAU_PHAY)
                    .append(String.valueOf(house.getNumberOfFloors()))
                    .append(DONG_MOI);
            fileHouse.flush();
        }

    }

    public void ext() {
        try {
            fileHouse.close();
        } catch (Exception e) {
            System.out.println();
        }

    }
}
