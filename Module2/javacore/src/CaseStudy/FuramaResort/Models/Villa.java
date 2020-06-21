package CaseStudy.FuramaResort.Models;

public class Villa extends Services {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloors;
    private String descriptionOfOtherAmenities;

    public Villa(String id, String nameServices, double areaUsed, double rental, int maxNumberOfPeople,
                 String typeOfRent, String roomStandard, String descriptionOfOtherAmenities, double poolArea, int numberOfFloors) {
        super(id, nameServices, areaUsed, rental, maxNumberOfPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionOfOtherAmenities() {
        return descriptionOfOtherAmenities;
    }

    public void setDescriptionOfOtherAmenities(String descriptionOfOtherAmenities) {
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }


    @Override
    public String showInfor() {
        return "1.Mã dịch vụ: " + this.getId() + "\n"
                + "2.Tên dịch vụ: " + this.getNameServices() + "\n"
                + "3.Diện tích sử dụng: " + this.getAreaUsed() + " m2 " + "\n"
                + "4.Chi phí thuê: " + this.getRental() + "USD\n"
                + "5.Số người tối đa: " + this.getMaxNumberOfPeople() + " people " + "\n"
                + "6.Kiểu thuê: " + this.getTypeOfRent() + "\n"
                + "7.Tiêu Chuẩn Phòng: " + this.getRoomStandard() + "\n"
                + "8.Tiện nghi khác: " + this.getDescriptionOfOtherAmenities() + "\n"
                + "9.Diện tích hồ bơi: " + this.getPoolArea() + " m2 " + "\n"
                + "10.Số tầng: " + this.getNumberOfFloors() + " tầng ";
    }
}
