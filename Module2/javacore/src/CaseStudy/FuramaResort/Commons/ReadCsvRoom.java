package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ReadCsvRoom {

    BufferedReader fileReader = new BufferedReader(new FileReader("C:\\codegym\\CodeGym\\Module2\\" +
            "C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Room.csv"));
    ArrayList<Room> listRoom = new ArrayList<>();
    TreeSet<String> listRoomNotDuplicate = new TreeSet<>();

    public ReadCsvRoom() throws IOException {

    }

    public ArrayList<Room> readCsvRoom() throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            Room room = new Room(splitData[0],
                    splitData[1],
                    Double.parseDouble(splitData[2]),
                    Double.parseDouble(splitData[3]),
                    Integer.parseInt(splitData[4]),
                    splitData[5],
                    splitData[6]
            );
            listRoom.add(room);
        }
        return listRoom;
    }

    public TreeSet<String> readCsvRoomNotDuplicate() throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] splitData = line.split(",");
            listRoomNotDuplicate.add(splitData[1]);
        }
        return listRoomNotDuplicate;
    }
}
