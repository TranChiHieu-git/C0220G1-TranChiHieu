package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.Villa;

import java.io.*;
import java.util.ArrayList;

public class WriteCsvVilla {
    private static final String DAU_PHAY = ",";
    private static final String DONG_MOI = "\n";
    FileWriter fileVilla = null;

    public void writeCsvVillaFile(ArrayList<Villa> listVilla) throws IOException {
        fileVilla = new FileWriter("C:\\codegym\\CodeGym\\Module2\\" +
                "C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Villa.csv");
        for (Villa villa : listVilla) {
            fileVilla.append(villa.getId())
                    .append(DAU_PHAY)
                    .append(villa.getNameServices())
                    .append(DAU_PHAY)
                    .append(String.valueOf(villa.getAreaUsed()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(villa.getRental()))
                    .append(DAU_PHAY).append(Integer.toString((int) villa.getMaxNumberOfPeople()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(villa.getTypeOfRent()))
                    .append(DAU_PHAY)
                    .append(villa.getRoomStandard())
                    .append(DAU_PHAY)
                    .append(villa.getDescriptionOfOtherAmenities())
                    .append(DAU_PHAY)
                    .append(String.valueOf(villa.getPoolArea()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(villa.getNumberOfFloors()))
                    .append(DONG_MOI);
            fileVilla.flush();
        }
    }

    public void ext() {
        try {
            fileVilla.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
