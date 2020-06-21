package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.Room;

import java.io.*;
import java.util.ArrayList;

public class WriteCsvRoom {
    private static final String DAU_PHAY = ",";
    private static final String DONG_MOI = "\n";
    FileWriter fileRoom = null;

    public void writeCsvRoomFile(ArrayList<Room> listRoom) throws IOException {

        fileRoom = new FileWriter("C:\\codegym\\CodeGym\\Module2\\C0220G1-TranChiHieu-Module2\\" +
                "src\\CaseStudy\\FuramaResort\\Data\\Room.csv");
        for (Room room : listRoom) {
            fileRoom.append(room.getId())
                    .append(DAU_PHAY)
                    .append(room.getNameServices())
                    .append(DAU_PHAY)
                    .append(String.valueOf(room.getAreaUsed()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(room.getRental()))
                    .append(DAU_PHAY)
                    .append(Integer.toString((int) room.getMaxNumberOfPeople()))
                    .append(DAU_PHAY)
                    .append(String.valueOf(room.getTypeOfRent()))
                    .append(DAU_PHAY)
                    .append(room.getFreeServices())
                    .append(DONG_MOI);
            fileRoom.flush();
        }
    }

    public void ext() {
        try {
            fileRoom.close();
        } catch (Exception e) {
            System.out.println();
        }

    }
}
