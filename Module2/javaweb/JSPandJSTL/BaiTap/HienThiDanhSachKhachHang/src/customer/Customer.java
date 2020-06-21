package customer;

public class Customer {
    String name;
    String birthDay;
    String address;
    String photo;

    public Customer(String name, String birthDay, String address, String photo) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.photo = photo;
    }
    public Customer(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
