package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.*;

import java.io.FileWriter;
import java.io.*;

public class WriteCsvBooking {
    private static final String DAU_PHAY = ",";
    private static final String DONG_MOI = "\n";
    FileWriter fileBooking = null;

    public void writeCsvBookingVillaFile(Customer customer, Villa services) throws IOException {
        fileBooking = new FileWriter("C:\\codegym\\CodeGym\\Module2\\C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Booking.csv",true);
        fileBooking.append(customer.getName());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getBirthday());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getSex());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getCMND());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getNumberPhone());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getEmail());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getTypeOfCustomer());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getAddress());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getId());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getNameServices());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getAreaUsed()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getRental()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(Integer.toString((int) services.getMaxNumberOfPeople()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getTypeOfRent()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getRoomStandard());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getPoolArea()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getNumberOfFloors()));
        fileBooking.append(DONG_MOI);
        fileBooking.flush();
    }

    public void writeCsvBookingHouseFile(Customer customer, House services) throws IOException {
        fileBooking = new FileWriter("C:\\codegym\\CodeGym\\Module2\\C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Booking.csv",true);
        fileBooking.append(customer.getName());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getBirthday());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getSex());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getCMND());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getNumberPhone());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getEmail());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getTypeOfCustomer());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getAddress());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getId());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getNameServices());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getAreaUsed()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getRental()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(Integer.toString((int) services.getMaxNumberOfPeople()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getTypeOfRent()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getRoomStandard());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getNumberOfFloors()));
        fileBooking.append(DONG_MOI);
        fileBooking.flush();
    }

    public void writeCsvBookingRoomFile(Customer customer, Room services) throws IOException {
        fileBooking = new FileWriter("C:\\codegym\\CodeGym\\Module2\\C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Booking.csv",true);
        fileBooking.append(customer.getName());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getBirthday());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getSex());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getCMND());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getNumberPhone());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getEmail());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getTypeOfCustomer());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(customer.getAddress());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getId());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(services.getNameServices());
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getAreaUsed()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getRental()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(Integer.toString((int) services.getMaxNumberOfPeople()));
        fileBooking.append(DAU_PHAY);
        fileBooking.append(String.valueOf(services.getTypeOfRent()));
        fileBooking.append(DONG_MOI);
        fileBooking.flush();
    }

    public void ext(){
        try {
            fileBooking.close();
        } catch (Exception e) {
            System.out.println();
        }

    }
}
