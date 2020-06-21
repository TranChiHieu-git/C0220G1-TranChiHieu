package CaseStudy.FuramaResort.Controllers;

import CaseStudy.FuramaResort.Commons.*;
import CaseStudy.FuramaResort.CustomerException.*;
import CaseStudy.FuramaResort.Models.*;

import java.io.IOException;
import java.util.*;

public class MainController {

    ArrayList<Room> listRoom = new ArrayList<>();
    ArrayList<Villa> listVilla = new ArrayList<>();
    ArrayList<House> listHouse = new ArrayList<>();
    ArrayList<Customer> listCustomer = new ArrayList<>();
    TreeSet<String> listRoomNotDuplicate = new TreeSet<>();
    TreeSet<String> listHouseNotDuplicate = new TreeSet<>();
    TreeSet<String> listVillaNotDuplicate = new TreeSet<>();

    //----------------------main menu---------------------------------------------------------------------------------------
    public void displayMainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Add New Services\n" +
                "2.Show Services\n" +
                "3.Add New Customer\n" +
                "4.Show Information of Customer\n" +
                "5.Add New Booking\n" +
                "6.Show Information of Employee\n" +
                "7.Booking Movie Ticket 4D\n" +
                "8.Find Employee\n" +
                "9.Exit");
        String choose;
        do {
            System.out.print("Chọn chức năng bạn muốn sử dụng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    this.addNewServices();
                    this.displayMainMenu();
                    break;
                case "2":
                    this.showServices();
                    this.displayMainMenu();
                    break;
                case "3":
                    this.addNewCustomer();
                    this.displayMainMenu();
                    break;
                case "4":
                    this.showInformationCustomers();
                    this.displayMainMenu();
                    break;
                case "5":
                    this.addNewBook();
                    this.displayMainMenu();
                    break;
                case "6":
                    this.showInformationOfEmployee();
                    this.displayMainMenu();
                    break;
                case "7":
                    this.bookingMovieTicket4D();
                    this.displayMainMenu();
                    break;
                case "8":
                    this.findEmployee();
                    this.displayMainMenu();
                    break;
                case "9":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
                    this.displayMainMenu();
                    break;
            }
        } while (true);
    }

    //------------------book movie ticket-----------------------------------------------------------------------------------
    int i = 0;
    Queue<String> listBookingMovieTicket = new ArrayDeque<>(4);

    public void bookingMovieTicket4D() {
        i++;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Ten khach hang " + (i));
        String inputNameOfCustomer = inputName();
        System.out.println("CMND khach hang " + (i));
        String inputCMNDOfCustomer = inputCMND();
        System.out.println("------------------------------------------------------------------------------------");
        listBookingMovieTicket.add(i + " ,Ho va ten: " + inputNameOfCustomer + ", So CMND: " + inputCMNDOfCustomer);
        if (i > 3) {
            printListTicket(listBookingMovieTicket);
            i = 0;
        }
    }

    public void printListTicket(Queue<String> listBookingMovieTicket) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Danh sach khach hang dat ve: ");
        while (listBookingMovieTicket.peek() != null) {
            System.out.println("Vi tri ghe: " + listBookingMovieTicket.remove());
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    //---------------------find infor employee by id------------------------------------------------------------------------
    public void findEmployee() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.print("Nhap vao ma so nhan vien: ");
        String inputIdOfEmployee = scanner.nextLine();
        System.out.println("------------------------------------------------------------------------------------");
        TuHoSo tuHoSo = new TuHoSo();
        Stack<String> listInforEmployee = tuHoSo.stackHoSo();
        int count = 0;
        for (String employee : listInforEmployee) {
            String[] employeeInfor = employee.split("\\.");
            if (employeeInfor[0].equals("Id: " + inputIdOfEmployee)) {
                System.out.println(employee);
                count++;
                System.out.println("------------------------------------------------------------------------------------");
            }
        }
        if (count == 0) {
            System.out.println("Khong co thong tin can tim trong he thong.");
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    //--------------------show infor employee-------------------------------------------------------------------------------
    public void showInformationOfEmployee() throws IOException {
        ReadCsvEmployee readCsvEmployee = new ReadCsvEmployee();
        Map<String, Employee> mapEmployee = readCsvEmployee.readCsvEmployee();
        for (Map.Entry<String, Employee> entry : mapEmployee.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    //-----------------------choose customer for booking--------------------------------------------------------------------
    public void addNewBook() throws IOException {
        ReadCsvCustomer readCsvCustomer = new ReadCsvCustomer();
        Scanner scanner = new Scanner(System.in);
        listCustomer = readCsvCustomer.readCsvCustomer();
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println((i + 1) + "." + listCustomer.get(i).getName() + " | " + listCustomer.get(i).getCMND() + " | "
                    + listCustomer.get(i).getBirthday());
            System.out.println("-------------------------------------------------------------------------------------");
        }
        Customer customer = null;
        String choose;
        boolean flag = true;
        do {
            System.out.print("Chọn nguoi dung muon book dich vu: ");
            choose = scanner.nextLine();
            if (Integer.parseInt(choose) > 0 && Integer.parseInt(choose) <= listCustomer.size()) {
                customer = listCustomer.get(Integer.parseInt(choose) - 1);
                flag = false;
            } else {
                System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
            }
        } while (flag);
        newBook(customer);
    }

    //------------------------menu choose services for booking----------------------------------------------------------------------------------
    public void newBook(Customer customer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Booking Villa\n" +
                "2.Booking House\n" +
                "3.Booking Room\n" +
                "4.Back to menu\n" +
                "5.exit\n");
        String choose;
        do {
            System.out.print("Chọn chức năng bạn muốn sử dụng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    this.addServicesVilla(customer);
                    this.displayMainMenu();
                    break;
                case "2":
                    this.addServicesHouse(customer);
                    this.displayMainMenu();
                    break;
                case "3":
                    this.addServicesRoom(customer);
                    this.displayMainMenu();
                    break;
                case "4":
                    this.displayMainMenu();
                    break;
                case "5":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
                    this.addNewBook();
                    break;
            }
        } while (true);
    }

    //-----------------------add new booking--------------------------------------------------------------------------------
    public void addServicesVilla(Customer customer) throws IOException {
        WriteCsvBooking writeCsvBooking = new WriteCsvBooking();
        ReadCsvVilla readCsvVilla = new ReadCsvVilla();
        Scanner scanner = new Scanner(System.in);
        listVilla = readCsvVilla.readCsvVilla();
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.println((i + 1) + "." + listVilla.get(i).getId() + " | " + listVilla.get(i).getNameServices() + " | "
                    + listVilla.get(i).getRoomStandard() + " | " + listVilla.get(i).getRental() + " USD");
            System.out.println("-------------------------------------------------------------------------------------");
        }
        String choose;
        Villa services = null;
        boolean flag = true;
        do {
            System.out.print("Chọn dich vu Villa muon book: ");
            choose = scanner.nextLine();
            if (Integer.parseInt(choose) > 0 && Integer.parseInt(choose) <= listVilla.size()) {
                services = listVilla.get(Integer.parseInt(choose) - 1);
                flag = false;
            } else {
                System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
            }
        } while (flag);
        customer.setServices(services);
        writeCsvBooking.writeCsvBookingVillaFile(customer, services);
        writeCsvBooking.ext();
    }

    public void addServicesHouse(Customer customer) throws IOException {
        WriteCsvBooking writeCsvBooking = new WriteCsvBooking();
        ReadCsvHouse readCsvHouse = new ReadCsvHouse();
        Scanner scanner = new Scanner(System.in);
        listHouse = readCsvHouse.readCsvHouse();
        for (int i = 0; i < listHouse.size(); i++) {
            System.out.println((i + 1) + "." + listHouse.get(i).getId() + " | " + listHouse.get(i).getNameServices() + " | "
                    + listHouse.get(i).getRoomStandard() + " | " + listHouse.get(i).getRental() + " USD");
            System.out.println("-------------------------------------------------------------------------------------");
        }
        String choose;
        House services = null;
        boolean flag = true;
        do {
            System.out.print("Chọn dich vu House muon book: ");
            choose = scanner.nextLine();
            if (Integer.parseInt(choose) > 0 && Integer.parseInt(choose) <= listHouse.size()) {
                services = listHouse.get(Integer.parseInt(choose) - 1);
                flag = false;
            } else {
                System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
            }
        } while (flag);
        customer.setServices(services);
        writeCsvBooking.writeCsvBookingHouseFile(customer, services);
        writeCsvBooking.ext();
    }

    public void addServicesRoom(Customer customer) throws IOException {
        WriteCsvBooking writeCsvBooking = new WriteCsvBooking();
        ReadCsvRoom readCsvRoom = new ReadCsvRoom();
        Scanner scanner = new Scanner(System.in);
        listRoom = readCsvRoom.readCsvRoom();
        for (int i = 0; i < listRoom.size(); i++) {
            System.out.println((i + 1) + "." + listRoom.get(i).getId() + " | " + listRoom.get(i).getNameServices()
                    + " | " + listRoom.get(i).getRental() + " USD");
            System.out.println("-------------------------------------------------------------------------------------");
        }
        String choose;
        Room services = null;
        boolean flag = true;
        do {
            System.out.print("Chọn dich vu Room muon book: ");
            choose = scanner.nextLine();
            if (Integer.parseInt(choose) > 0 && Integer.parseInt(choose) <= listRoom.size()) {
                services = listRoom.get(Integer.parseInt(choose) - 1);
                flag = false;
            } else {
                System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
            }
        } while (flag);
        customer.setServices(services);
        writeCsvBooking.writeCsvBookingRoomFile(customer, services);
        writeCsvBooking.ext();
    }

    //---------------------------add new customer---------------------------------------------------------------------------
    public void addNewCustomer() throws IOException {
        WriteCsvCustomer writeCsvCustomer = new WriteCsvCustomer();
        String name = inputName();
        String birthDay = inputBirthday();
        String gender = inputGender();
        String cmnd = inputCMND();
        String numberPhone = inputNumberPhone();
        String email = inputEmail();
        String typeOfCustomers = inputTypeOfCustomer();
        String address = inputAddress();

        Customer customer = new Customer(name, birthDay, gender, cmnd, numberPhone, email, typeOfCustomers, address);
        listCustomer.add(customer);
        writeCsvCustomer.writeCsvCustomerFile(listCustomer);
        writeCsvCustomer.ext();
    }

    //---------------------show infor customer------------------------------------------------------------------------------
    public void showInformationCustomers() throws IOException {
        ReadCsvCustomer readCsvCustomer = new ReadCsvCustomer();
        listCustomer = readCsvCustomer.readCsvCustomer();
        for (Customer ct : listCustomer) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(ct.showInfor());
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    //--------------------input information customer------------------------------------------------------------------------
    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String name = null;
        do {
            try {
                System.out.print("Ten Khach Hang : ");
                name = scanner.nextLine();
                String patt1 = "^[A-Z]+[a-z]{1,}";
                int count = 0;
                for (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) == ' ') {
                        count++;
                    }
                }
                String patt = patt1;
                String patt2 = "[A-Z]{1}+[a-z]{1,}";
                for (int i = 0; i < count; i++) {
                    patt += "+\\s+" + patt2;
                }
                if (name.matches(patt)) {
                    flag = false;
                } else {
                    throw new NameException("Ten phai in hoa ki tu dau tien va khong co khoang trong thua");
                }

            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        while (flag);
        return name;
    }

    public String inputEmail() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String email = null;
        do {
            try {
                System.out.print("Email khach hang: ");
                email = scanner.nextLine();
                String patt = "[A-Za-z0-9\\_]{3,}+\\@+[a-z]{3,10}+\\.+(com|vn|org|edu)$";
                if (email.matches(patt)) {
                    flag = false;
                } else {
                    throw new EmailException("Email phai dung dinh dang abc@abc.abc");
                }
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        }
        while (flag);
        return email;
    }

    public String inputGender() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String gender = "";
        do {
            try {
                System.out.print("Gioi tinh khach hang: ");
                String inputGender = scanner.nextLine();
                String lowCaseGender = inputGender.toLowerCase();
                gender = String.valueOf(lowCaseGender.charAt(0)).toUpperCase();
                for (int i = 1; i < lowCaseGender.length(); i++) {
                    gender = gender.concat(String.valueOf(lowCaseGender.charAt(i)));
                }
                String patt = "(Male|Female|Unknow)";
                if (gender.matches(patt)) {
                    flag = false;
                } else {
                    throw new GenderException("Gioi tinh phai la male, female or unknow");
                }
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }
        while (flag);
        return gender;
    }

    public String inputCMND() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String cmnd = "";
        do {
            try {
                System.out.print("So cmnd khach hang: ");
                cmnd = scanner.nextLine();
                String patt = "[\\d]{3}+\\s+[\\d]{3}+\\s+[\\d]{3}";
                if (cmnd.matches(patt)) {
                    flag = false;
                } else {
                    throw new IdCardException("CMND phai co 9 chu so va theo dinh dang XXX XXX XXX");
                }
            } catch (IdCardException e) {
                System.out.println(e.getMessage());
            }
        }
        while (flag);
        return cmnd;
    }

    public String inputBirthday() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String birthDay = "";
        do {
            try {
                System.out.print("Ngay sinh khach hang: ");
                birthDay = scanner.nextLine();
                String patt = "[0-9]{2}+\\/+[0-9]{2}+\\/+[0-9]{4}";
                if (birthDay.matches(patt)) {
                    String[] dayMonthYear = birthDay.split("/");
                    Calendar calendar = Calendar.getInstance();
                    if (Integer.parseInt(dayMonthYear[2]) > 1900 && calendar.get(Calendar.YEAR) - Integer.parseInt(dayMonthYear[2]) > 18) {
                        if (Integer.parseInt(dayMonthYear[1]) > 0 && Integer.parseInt(dayMonthYear[1]) < 13) {
                            if (Integer.parseInt(dayMonthYear[0]) > 0 && Integer.parseInt(dayMonthYear[0]) < 32) {
                                flag = false;
                            } else {
                                throw new BirthdayException("Ngay sinh phai tu 01 den 31");
                            }
                        } else {
                            throw new BirthdayException("Thang sinh phai tu 01 den 12");
                        }
                    } else {
                        throw new BirthdayException("Nam sinh phai lon hon 1900 va nho hon nam hien tai 18 nam");
                    }
                } else {
                    throw new BirthdayException("Ngay sinh viet theo dinh dang dd/mm/yyyy");
                }
            } catch (BirthdayException e) {
                System.out.println(e.getMessage());
            }
        }
        while (flag);
        return birthDay;
    }

    public String inputNumberPhone() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String numberPhone;
        do {
            System.out.print("So dien thoai khach hang: ");
            numberPhone = scanner.nextLine();
            String patt = "^[0]+[\\d]{9}";
            if (numberPhone.matches(patt)) {
                flag = false;
            } else {
                System.out.println("So dien thoai nhap phai co 10 so");
            }
        }
        while (flag);
        return numberPhone;
    }

    public String inputAddress() {
        Scanner scanner = new Scanner(System.in);
        String address;
        System.out.print("Dia chi khach hang: ");
        address = scanner.nextLine();
        return address;
    }

    public String inputTypeOfCustomer() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String typeOfCustomers;
        do {
            System.out.print("Loai khach hang: ");
            typeOfCustomers = scanner.nextLine();
            String patt = "(guest|member|gold|VIP)";
            if (typeOfCustomers.matches(patt)) {
                flag = false;
            } else {
                System.out.println("Loai khac hang bao gom guest, member, gold and VIP");
            }
        }
        while (flag);
        return typeOfCustomers;
    }

    //----------------------menu add new services---------------------------------------------------------------------------
    public void addNewServices() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back to menu\n" +
                "5.Exit");
        String choose;
        do {
            System.out.print("Chọn chức năng bạn muốn sử dụng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    this.addNewVilla();
                    this.addNewServices();
                    break;
                case "2":
                    this.addNewHouse();
                    this.addNewServices();
                    break;
                case "3":
                    this.addNewRoom();
                    this.addNewServices();
                    break;
                case "4":
                    this.displayMainMenu();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
                    this.addNewServices();
                    break;
            }
        } while (true);
    }

    //---------------------add new services---------------------------------------------------------------------------------
    public void addNewVilla() throws IOException {
        WriteCsvVilla writeCsvVilla = new WriteCsvVilla();
        int i = 1;
        String id = inputId(i);
        String nameServices = inputNameSerVices();
        String areaUsed = inputAreaUsed();
        String rental = inputRental();
        String maxNumberOfPeople = inputMaxNumberOfPeople();
        String typeOfRent = inputTypeOfRent();
        String roomStandard = inputRoomStandard();
        String descriptionOfOtherAmenities = inputDescriptionOfOtherAmenities();
        String poolArea = inputAreaPool();
        String numberOfFloors = inputNumberOfFloor();
        Villa villa = new Villa(id, nameServices, Double.parseDouble(areaUsed), Double.parseDouble(rental),
                Integer.parseInt(maxNumberOfPeople), typeOfRent,
                roomStandard, descriptionOfOtherAmenities, Double.parseDouble(poolArea), Integer.parseInt(numberOfFloors));
        listVilla.add(villa);
        writeCsvVilla.writeCsvVillaFile(listVilla);
        writeCsvVilla.ext();
    }

    public void addNewHouse() throws IOException {
        WriteCsvHouse writeCsvHouse = new WriteCsvHouse();
        int i = 2;
        String id = inputId(i);
        String nameServices = inputNameSerVices();
        String areaUsed = inputAreaUsed();
        String rental = inputRental();
        String maxNumberOfPeople = inputMaxNumberOfPeople();
        String typeOfRent = inputTypeOfRent();
        String roomStandard = inputRoomStandard();
        String descriptionOfOtherAmenities = inputDescriptionOfOtherAmenities();
        String numberOfFloors = inputNumberOfFloor();
        House house = new House(id, nameServices, Double.parseDouble(areaUsed), Double.parseDouble(rental),
                Integer.parseInt(maxNumberOfPeople), typeOfRent,
                roomStandard, descriptionOfOtherAmenities, Integer.parseInt(numberOfFloors));
        listHouse.add(house);
        writeCsvHouse.WriteCsvHouseFile(listHouse);
        writeCsvHouse.ext();
    }

    public void addNewRoom() throws IOException {
        int i = 3;
        String id = inputId(i);
        String nameServices = inputNameSerVices();
        String areaUsed = inputAreaUsed();
        String rental = inputRental();
        String maxNumberOfPeople = inputMaxNumberOfPeople();
        String typeOfRent = inputTypeOfRent();
        String freeServices = inputFreeServices();
        Room room = new Room(id, nameServices, Double.parseDouble(areaUsed), Double.parseDouble(rental),
                Integer.parseInt(maxNumberOfPeople), typeOfRent, freeServices);
        listRoom.add(room);
        WriteCsvRoom writeCsvRoom = new WriteCsvRoom();
        writeCsvRoom.writeCsvRoomFile(listRoom);
        writeCsvRoom.ext();
    }

    //--------------------menu show services--------------------------------------------------------------------------------
    public void showServices() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Show all Villa\n" +
                "2.Show all House\n" +
                "3.Show all Room\n" +
                "4.Show All Name Villa Not Duplicate\n" +
                "5.Show All Name House Not Duplicate\n" +
                "6.Show All Name Name Not Duplicate\n" +
                "7.Back to menu\n" +
                "8.Exit\n");
        String choose;
        do {
            System.out.print("Chọn chức năng bạn muốn sử dụng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    this.showAllVilla();
                    this.showServices();
                    break;
                case "2":
                    this.showAllHouse();
                    this.showServices();
                    break;
                case "3":
                    this.showAllRoom();
                    this.showServices();
                    break;
                case "4":
                    this.showAllNameVillaNotDuplicate();
                    this.showServices();
                    break;
                case "5":
                    this.showAllNameHouseNotDuplicate();
                    this.showServices();
                    break;
                case "6":
                    this.showAllNameRoomNotDuplicate();
                    this.showServices();
                    break;
                case "7":
                    this.displayMainMenu();
                    break;
                case "8":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Giá trị nhập vào không chính xác. Vui lòng nhập lại");
                    this.showServices();
                    break;
            }
        } while (true);
    }

    //--------------------------show services-------------------------------------------------------------------------------
    public void showAllVilla() throws IOException {
        ReadCsvVilla readCsvVilla = new ReadCsvVilla();
        listVilla = readCsvVilla.readCsvVilla();
        for (Villa villa : listVilla) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(villa.showInfor());
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public void showAllHouse() throws IOException {
        ReadCsvHouse readCsvHouse = new ReadCsvHouse();
        listHouse = readCsvHouse.readCsvHouse();
        for (House house : listHouse) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(house.showInfor());
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public void showAllRoom() throws IOException {
        ReadCsvRoom readCsvRoom = new ReadCsvRoom();
        listRoom = readCsvRoom.readCsvRoom();
        for (Room room : listRoom) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(room.showInfor());
            System.out.println("----------------------------------------------------------------------");
        }
    }

    //---------------------------input information services-----------------------------------------------------------------
    public String inputDescriptionOfOtherAmenities() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String otherAmenities;
        do {
            System.out.print("Nhap vao tien nghi khac: ");
            otherAmenities = scanner.nextLine();
            String patt;
            patt = "^[A-Z]+[a-zA-Z0-9\\s]{1,}";
            boolean math = otherAmenities.matches(patt);
            if (math) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }
        } while (flag);
        return otherAmenities;
    }

    public String inputFreeServices() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String freeServices;
        do {
            System.out.print("Nhap vao dich vu mien phi kem theo: ");
            freeServices = scanner.nextLine();
            String patt;
            patt = "^[A-Z]+[a-zA-Z0-9\\s]{1,}";
            boolean math = freeServices.matches(patt);
            if (math) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }
        } while (flag);
        return freeServices;
    }

    public String inputId(int i) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String id;
        do {
            System.out.print("Nhap vao id: ");
            id = scanner.nextLine();
            String patt;
            if (i == 1) {
                patt = "(SVVL)+\\-[0-9]{4}";
            } else if (i == 2) {
                patt = "(SVHO)+\\-[0-9]{4}";
            } else {
                patt = "(SVRO)+\\-[0-9]{4}";
            }
            boolean math = id.matches(patt);
            if (math) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }
        } while (flag);
        return id;
    }

    public String inputNameSerVices() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String nameSerVices;
        do {
            System.out.print("Nhap vao ten dich vu: ");
            nameSerVices = scanner.nextLine();
            String patt = "^[A-Z]+[a-z0-9]{1,}+\\s+[a-zA-Z0-9\\s]{0,}";
            boolean math = nameSerVices.matches(patt);
            if (math) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }
        } while (flag);
        return nameSerVices;
    }

    public String inputAreaUsed() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String areaUsed;
        do {
            System.out.print("Nhap vao dien tich su dung: ");
            areaUsed = scanner.nextLine();
            String patt = "^[1-9]+(\\d){1,}+\\.+(\\d){1,}";
            boolean math = areaUsed.matches(patt);
            if (math && (Double.parseDouble(areaUsed) > 30.0)) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }

        } while (flag);
        return areaUsed;
    }

    public String inputAreaPool() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String areaPool;
        do {
            System.out.print("Nhap vao dien tich ho boi: ");
            areaPool = scanner.nextLine();
            String patt = "^[1-9]+(\\d){1,}+\\.+(\\d){1,}";
            boolean math = areaPool.matches(patt);
            if (math && (Double.parseDouble(areaPool) > 30.0)) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }

        } while (flag);
        return areaPool;
    }

    public String inputRental() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String rental;
        do {
            System.out.print("Nhap vao gia thue: ");
            rental = scanner.nextLine();
            String patt = "^[0-9]+(\\d){0,}+\\.+(\\d){1,}";
            boolean math = rental.matches(patt);
            if (math && (Double.parseDouble(rental) > 0.0)) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }

        } while (flag);
        return rental;
    }

    public String inputMaxNumberOfPeople() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String maxNumberOfPeople;
        do {
            System.out.print("Nhap vao so nguoi toi da: ");
            maxNumberOfPeople = scanner.nextLine();
            String patt = "(\\d){1,2}";
            boolean math = maxNumberOfPeople.matches(patt);
            if (math && ((Integer.parseInt(maxNumberOfPeople) > 0) && (Integer.parseInt(maxNumberOfPeople) < 20))) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }

        } while (flag);
        return maxNumberOfPeople;
    }

    public String inputNumberOfFloor() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String numberOfFloor;
        do {
            System.out.print("Nhap vao so tang: ");
            numberOfFloor = scanner.nextLine();
            String patt = "(\\d){1,2}";
            boolean math = numberOfFloor.matches(patt);
            if (math && (Integer.parseInt(numberOfFloor) > 0)) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }

        } while (flag);
        return numberOfFloor;
    }

    public String inputTypeOfRent() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String typeOfRent;
        do {
            System.out.print("Nhap vao kieu thue: ");
            typeOfRent = scanner.nextLine();
            String patt = "Day|Month|Year|Hour|Week";
            boolean math = typeOfRent.matches(patt);
            if (math) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }
        } while (flag);
        return typeOfRent;
    }

    public String inputRoomStandard() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String roomStandard;
        do {
            System.out.print("Nhap vao tieu chuan phong: ");
            roomStandard = scanner.nextLine();
            String patt = "(Small|Normal|Medium|Big|VIP)";
            boolean math = roomStandard.matches(patt);
            if (math) {
                flag = false;
            } else {
                System.out.println("Gia tri nhap vao khong chinh xac. Vui long nhap lai.");
            }
        } while (flag);
        return roomStandard;
    }

    //---------------------show not duplicate services----------------------------------------------------------------------
    public void showAllNameVillaNotDuplicate() throws IOException {
        ReadCsvVilla readCsvVilla = new ReadCsvVilla();
        listVillaNotDuplicate = readCsvVilla.readCsvVillaNotDuplicate();
        int i = 0;
        for (String listVilla : listVillaNotDuplicate) {
            i++;
            System.out.println(i + "." + listVilla);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public void showAllNameHouseNotDuplicate() throws IOException {
        ReadCsvHouse readCsvHouse = new ReadCsvHouse();
        listHouseNotDuplicate = readCsvHouse.readCsvHouseNotDuplicate();
        int i = 0;
        for (String listHouse : listHouseNotDuplicate) {
            i++;
            System.out.println(i + "." + listHouse);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public void showAllNameRoomNotDuplicate() throws IOException {
        ReadCsvRoom readCsvRoom = new ReadCsvRoom();
        listRoomNotDuplicate = readCsvRoom.readCsvRoomNotDuplicate();
        int i = 0;
        for (String listRoom : listRoomNotDuplicate) {
            i++;
            System.out.println(i + "." + listRoom);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    //--------------------main----------------------------------------------------------------------------------------------
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}

