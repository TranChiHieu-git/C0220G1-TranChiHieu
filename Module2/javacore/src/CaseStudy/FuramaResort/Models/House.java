package CaseStudy.FuramaResort.Models;

public class House extends Services {
    private String roomStandard;
    private int numberOfFloors;
    private String descriptionOfOtherAmenities;

    public House(String id, String nameServices, double areaUsed, double rental, int maxNumberOfPeople,
                 String typeOfRent, String roomStandard, String descriptionOfOtherAmenities, int numberOfFloors) {
        super(id, nameServices, areaUsed, rental, maxNumberOfPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
    }

    public String getDescriptionOfOtherAmenities() {
        return descriptionOfOtherAmenities;
    }

    public void setDescriptionOfOtherAmenities(String descriptionOfOtherAmenities) {
        this.descriptionOfOtherAmenities = descriptionOfOtherAmenities;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
                + "9.Số tầng: " + this.getNumberOfFloors() + " tầng ";
    }
}
