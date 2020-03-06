let costService;
switch(kindService) {
    case "Villa" :
        costService = 500;
        break;
    case "House" :
        costService = 300;
        break;
    case "Room" :
        costService = 100;
        break;
}
let cost = costService * rentDay * (1 - (discount/100));
alert("Ho va ten: " + name +"\n" +
"So CMND: " + id + "\n" +
"Ngay Sinh: " + birthday +"\n" +
"Email: " + email + "\n" +
"Dia chi: " + address + "\n" +
"Loai khach hang: " + kindCustomer + "\n" +
"Giam gia: " + discount + "\n" +
"So luong di kem: " + soluongdikem + "\n" +
"So ngay thue: " + rentDay + "\n" +
"Loai dich vu: " + kindService + "\n" +
"Loai phong: " + kindRoom +"\n"+
"So tien phai tra: " + cost +" $");







