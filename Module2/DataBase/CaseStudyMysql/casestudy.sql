-- drop database furama;
-- *********************************************************** Tao CSDL ***************************************************************************
-- create database furama;
-- ************************************************************Dich vu ****************************************************************************
create table LoaiDichVu(
IDLoaiDichVu int primary key,
TenLoaiDichVu varchar(50)
);

create table KieuThue(
IDKieuThue int primary key,
TenKieuThue varchar(50),
Gia int
);

create table DichVu(
IDDichVu int primary key,
TenDichVu varchar(50),
DienTich int,
SoTang int,
SoNguoiToiDa varchar(50),
ChiPhiThue varchar(50),
IDKieuThue int,
foreign key(IDKieuThue) references KieuThue(IDKieuThue),
IDLoaiDichVu int,
foreign key(IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu),
TrangThai varchar(50)
);

-- ************************************************************ Khach hang ************************************************************************

create table LoaiKhach(
IDLoaiKhach int primary key,
TenLoaiKhach varchar(50)
);

create table KhachHang(
IDKhachHang int primary key,
IDLoaiKhach int,
HoTen varchar(50),
NgaySinh date,
SoCMND varchar(50),
SDT varchar(50),
Email varchar(50),
DiaChi varchar(50),
foreign key(IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);

-- ************************************************************ Nhan vien ***************************************************************************

create table ViTri(
IDViTri int primary key,
TenViTri varchar(50)
);

create table TrinhDo(
IDTrinhDo int primary key,
TrinhDo varchar(50)
);

create table BoPhan(
IDBoPhan int primary key,
TenBoPhan varchar(50)
);

create table NhanVien(
IDNhanVien int primary key,
HoTen varchar(50),
IDViTri int,
IDTrinhDo int,
IDBoPhan int,
NgaySinh date,
SoCMND varchar(50),
Luong varchar(50),
SDT varchar(50),
Email varchar(50),
DiaChi varchar(50),
foreign key(IDViTri) references ViTri(IDViTri),
foreign key(IDTrinhDo) references TrinhDo(IDTrinhDo),
foreign key(IDBoPhan) references BoPhan(IDBoPhan)
);

-- ************************************************************* Hop dong **************************************************************************

create table DichVuDiKem(
IDDichVuDiKem int primary key,
TenDichVuDiKem varchar(50),
Gia int,
DonVi int,
TrangThaiKhaDung varchar(50)
);

create table HopDong(
IDHopDong int primary key,
IDNhanVien int,
IDKhachHang int,
IDDichVu int,
NgayLamHopDong date,
NgayKetThuc date,
TienDatCoc int,
TongTien int,
foreign key(IDNhanVien) references NhanVien(IDNhanVien),
foreign key(IDKhachHang) references KhachHang(IDKhachHang),
foreign key(IDDichVu) references DichVu(IDDichVu)
);

create table HopDongChiTiet(
IDHopDongChiTiet int primary key,
IDHopDong int,
IDDichVuDiKem int,
SoLuong int,
foreign key(IDHopDong) references HopDong(IDHopDong),
foreign key(IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem)
);

-- ***************************************************** Yeu cau 1 **********************************************************************************
-- Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

insert into LoaiDichVu
values (1,'Villa'),(2,'House'),(3,'Room');

insert into KieuThue
values (1,'Nam',8760),(2,'Thang',720),(3,'Ngay',24),(4,'Gio',1);

insert into DichVu 
values (1,'Villa thue theo gio',2000,4,'20 nguoi',500000,'4','1','Con phong'),
(2,'Villa thue theo ngay',2000,4,'20 nguoi',12000000,'3','1','Con phong'),
(3,'Villa thue theo thang',2000,4,'20 nguoi',360000000,'2','1','Con phong'),
(4,'Villa thue theo nam',2000,4,'20 nguoi',4320000000,'1','1','Con phong'),
(5,'House thue theo gio',1500,2,'10 nguoi',300000,'4','2','Con phong'),
(6,'House thue theo ngay',1500,2,'10 nguoi',7200000,'3','2','Con phong'),
(7,'House thue theo thang',1500,2,'10 nguoi',216000000,'2','2','Con phong'),
(8,'House thue theo nam',1500,2,'10 nguoi',2592000000,'1','2','Con phong'),
(9,'Room thue theo gio',1000,0,'4 nguoi',100000,'4','3','Con phong'),
(10,'Room thue theo ngay',1000,0,'4 nguoi',2400000,'3','3','Con phong'),
(11,'Room thue theo thang',1000,0,'4 nguoi',72000000,'2','3','Con phong'),
(12,'Room thue theo nam',1000,0,'4 nguoi',864000000,'1','3','Con phong');

insert into LoaiKhach
values (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');

insert into KhachHang
values (1,1,'Tran Chi Hieu','1997-08-28','197400619','0383296403','hieu5713@gmail.com','Quang Tri'),
(2,2,'Nguyen Quoc Tuan','1994-02-12','12541219','0373156709','tuannguyen4@gmail.com','Da Nang'),
(3,1,'Tran Van Hung','1999-11-03','122400675','0973826203','tvhung9874@gmail.com','Hue'),
(4,4,'Le Quoc Thien','1992-12-11','193454612','0153846115','thienkenja@gmail.com','Da Nang'),
(5,5,'Nguyen Ngoc Huy','1992-02-18','191219133','0384893115','huyaa11@gmail.com','Quang Nam'),
(6,1,'Nguyen Ngoc Hung','1994-03-28','192480413','0139842655','hungnguyen11@gmail.com','Vinh'),
(7,2,'Le Ngoc Quoc','1990-03-14','131410121','0159658777','quocle555@gmail.com','Da Nang'),
(8,2,'Le Van Tuan','2004-03-14',null,'0159658777','tuanvan123@gmail.com','Da Nang'),
(9,1,'Le Van anh','2005-03-14',null,'0269571230','aaa3@gmail.com','Vinh'),
(10,3,'Le Quoc Thien','1994-01-25','138210431','0119432460','quocle555@gmail.com','Quang Nam'),
(11,4,'Nguyen Ngoc Hung','1998-01-15','175311731','0721639430','hungnguyen123@gmail.com','Hue'),
(12,1,'Nguyen Quoc Hung','1995-01-15','172912581','0159637530','hungnq11@gmail.com','Vinh'),
(13,2,'Le Hoang Ha','1992-01-15','126812731','0384695130','hhale1992@gmail.com','Da Nang');

insert into ViTri
values (1,'Le Tan'),(2,'Phuc Vu'),(3,'Chuyen Vien'),(4,'Giam Sat'),(5,'Quan Ly'),(6,'Giam Doc');

insert into TrinhDo
values (1,'Trung Cap'),(2,'Cao Dang'),(3,'Dai Hoc'),(4,'Sau Dai Hoc');

insert into BoPhan
values (1,'Sale-Marketing'),(2,'Hanh Chinh'),(3,'Phuc Vu'),(4,'Quan Ly');

insert into NhanVien
values (1,'Nguyen Van Tuan Abc',1,2,1,'1998-01-21','123456789','10000000','0236548975','nhanviena@gmail.com','Da Nang'),
(2,'Nguyen Hoang',2,1,3,'1993-03-02','137957543','7000000','0245249913','nhanvienb@gmail.com','Quang Nam'),
(3,'Nguyen Van Van',3,1,2,'1992-09-22','123557942','12000000','0245649223','nhanvienc@gmail.com','Quang Tri'),
(4,'Nguyen Van Loc',4,3,2,'1991-11-10','134154532','15000000','0244249213','nhanviend@gmail.com','Da Nang'),
(5,'Nguyen Van Khanh',5,4,4,'1994-02-07','134157792','18000000','0235259731','nhanviene@gmail.com','Hue'),
(6,'Nguyen Hung',6,3,4,'1995-05-29','132537213','30000000','01973102482','nhanvienf@gmail.com','Quang Tri'),
(7,'Nguyen Van Long',2,1,3,'1996-07-30','132247198','7000000','0197658482','nhanvieng@gmail.com','Quang Nam'),
(8,'Nguyen Van Vinh',2,2,3,'1997-09-05','132537246','6000000','0112356482','nhanvienh@gmail.com','Da Nang'),
(9,'Nguyen Van Anh',1,1,1,'1998-10-11','1597370466','7000000','0193556482','nhanvieni@gmail.com','Hue'),
(10,'Tran Huu Thanh',1,2,1,'1998-01-21','123456789','10000000','0236548975','nhanviena@gmail.com','Da Nang'),
(11,'Le Quoc Tuan',1,2,1,'1995-01-21','174152589','10000000','0159542465','nhanvtuan123@gmail.com','Quang Ngai');

insert into DichVuDiKem
values (1,'massage',500000,1,'Dang mo'),
(2,'karaoke',300000,1,'Dang mo'),
(3,'thuc an',200000,1,'Dang mo'),
(4,'nuoc uong',50000,1,'Dang mo'),
(5,'thue xe',1000000,1,'Dang mo');

insert into HopDong
values (1,1,1,1,'2019-04-30','2019-05-02',500000,0),
(2,9,2,5,'2019-11-30','2019-12-02',500000,0),
(3,1,3,9,'2019-08-30','2019-09-02',500000,0),
(4,9,4,3,'2019-01-30','2019-02-02',500000,0),
(5,10,5,6,'2019-04-28','2019-05-05',500000,0),
(6,9,6,10,'2019-10-30','2019-11-02',500000,0),
(7,1,7,3,'2019-04-30','2019-05-02',500000,0),
(8,1,1,1,'2019-02-28','2019-03-02',500000,0),
(9,9,6,11,'2018-04-30','2018-05-02',500000,0),
(10,9,6,12,'2019-01-14','2019-01-26',500000,0),
(11,10,12,11,'2019-01-14','2019-01-26',500000,0),
(12,1,3,4,'2018-01-14','2018-01-26',500000,0),
(13,10,3,4,'2017-01-14','2017-01-26',500000,0),
(14,11,5,3,'2016-01-14','2016-01-26',500000,0),
(15,1,13,3,'2015-01-14','2015-01-26',500000,0);

insert into HopDongChiTiet
values (1,1,2,2),(2,2,2,2),(3,3,3,2),(4,4,4,2),(5,5,5,2),(6,6,2,2),(7,7,2,2),(8,8,3,2),(9,9,4,2),(10,10,1,2),(11,13,2,2),(13,11,2,2),(14,12,2,2),
(15,1,4,2),(16,2,2,2),(17,3,1,2),(18,2,2,2),(19,13,3,2),(20,14,2,2),(21,15,1,3);
-- *********************************************************************** Yeu cau 2 ****************************************************************
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select * from NhanVien where (HoTen like '% T%' or HoTen like '% H%' or HoTen like'% K%') and length(HoTen)<16;

-- ************************************************************************ Yeu cau 3 ***************************************************************
-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select * from KhachHang where (DiaChi = 'Da Nang' or DiaChi = 'Quang Tri') and (NgaySinh < '2002-01-01' and NgaySinh > '1970-01-01');

-- *********************************************************************** Yeu cau 4 ****************************************************************
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select KhachHang.HoTen, HopDong.IDKhachHang, count(*) as solandat
from  HopDong 
join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
where  KhachHang.IDloaiKhach = 1
group by HopDong.IDKhachHang
order by solandat;

-- ************************************************************************ Yeu cau 5 ***************************************************************
-- Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như 
-- sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa
-- từng đặt phòng cũng phải hiển thị ra).

select KhachHang.IDKhachHang, KhachHang.HoTen, LoaiKhach.TenLoaiKhach , HopDong.IDHopDong,  DichVu.TenDichVu, HopDong.NgayLamHopDong,
HopDong.NgayKetThuc, sum(DichVu.ChiPhiThue + HopDongChiTiet.SoLuong * DichVuDiKem.Gia) as 'Tong tien'
from KhachHang 
join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
left join HopDong on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by HopDong.IDHopDong
order by HopDong.IDHopDong;

-- ****************************************************************** Yeu cau 6 **********************************************************************
-- Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1
-- của năm 2019 (Quý 1 là tháng 1, 2, 3).

select  DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich,DichVu.ChiPhiThue,LoaiDichVu.TenLoaiDichVu
from DichVu 
left join HopDong on HopDong.IDDichVu = DichVu.IDDichVu
join LoaiDichVu on DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
where DichVu.IDDichVu not in (select IDDichVu from HopDong
where (HopDong.NgayLamHopDong <= '2019-03-31' and HopDong.NgayLamHopDong >= '2019-01-01'))
group by DichVu.IDDichVu;

-- ************************************************************** Yeu cau 7 ************************************************************************
-- Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt 
-- phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich, DichVu.SoNguoiToiDa, DichVu.ChiPhiThue, LoaiDichVu.TenLoaiDichVu
from DichVu 
join LoaiDichVu on DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
left join HopDong on HopDong.IDDichVu = DichVu.IDDichVu
where (DichVu.IDDichVu in (select IDDichVu from HopDong
where (year(HopDong.NgayLamHopDong) = '2018')))
and (DichVu.IDDichVu not in (select IDDichVu from HopDong
where (year(HopDong.NgayLamHopDong) = '2019')))
group by DichVu.IDDichVu;

-- ************************************************************* Yeu cau 8 ***************************************************************************
-- Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

select distinct HoTen from KhachHang;
select HoTen from KhachHang group by HoTen;
select distinct HoTen from KhachHang union select distinct HoTen from KhachHang;

-- ************************************************************** Yeu cau 9 **************************************************************************
-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select temp.month, count(month(HopDong.NgayLamHopDong)) as so_khach_hang_dang_ki,
sum(DichVu.ChiPhiThue + HopDongChiTiet.SoLuong * DichVuDiKem.Gia) as Tong_tien from
(select 1 as month 
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join HopDong on month(HopDong.NgayLamHopDong)=temp.month
left join KhachHang on KhachHang.IDKhachHang=HopDong.IDKhachHang
left join DichVu on DichVu.IDDichVu=HopDong.IDDichVu
left join HopDongChiTiet on HopDongChiTiet.IDHopDong=HopDong.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem= HopDongChiTiet.IDDichVuDiKem
where year(HopDong.NgayLamHopDong)='2019' or year(HopDong.NgayLamHopDong) is null or month(HopDong.NgayLamHopDong) is null
group by temp.month
order by temp.month;

-- ************************************************************ Yeu cau 10 ***************************************************************************
-- Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, 
-- NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select HopDong.IDHopDong, HopDong.NgayLamHopDong, HopDong.NgayKetThuc,HopDong.TienDatCoc, count(HopDongChiTiet.IDHopDongChiTiet) 
as 'so luong dich vu di kem' 
from HopDong
join HopDongChiTiet
on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
group by IDHopDong;

-- *********************************************************** Yeu cau 11 ****************************************************************************
-- Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc
-- “Quảng Ngãi”.

select DichVuDiKem.IDDichVuDiKem, DichVuDiKem.TenDichVuDiKem, DichVuDiKem.Gia, DichVuDiKem.DonVi,DichVuDiKem.TrangThaiKhaDung from DichVuDikem
join HopDongChiTiet on DichVuDikem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
join HopDong on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
where LoaiKhach.TenLoaiKhach = 'Diamond' and (KhachHang.DiaChi = 'Vinh' or KhachHang.DiaChi = 'Quang Ngai')
group by DichVuDiKem.TenDichVuDiKem; 

-- *********************************************************** Yeu cau 12 ****************************************************************************
-- Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi
-- tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu
-- năm 2019.

select HopDong.IDHopDong, NhanVien.HoTen as hotennhanvien, KhachHang.HoTen as hotenkhachhang, KhachHang.SDT, DichVu.TenDichVu, count(HopDongChiTiet.IDHopDongChiTiet) soluongdichvudikem , HopDong.TienDatCoc, HopDong.NgayLamHopDong
from HopDong
join NhanVien on NhanVien.IDNhanVien=HopDong.IDNhanVien
join KhachHang on KhachHang.IDKhachHang = HopDong.IDKhachHang
join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
where HopDong.IDDichVu in (select IDDichVu from HopDong where HopDong.NgayLamHopDong>= '2019-10-01' and HopDong.NgayLamHopDong<= '2019-12-31')
and HopDong.IDDichVu not in (select IDDichVu from HopDong where HopDong.NgayLamHopDong>= '2019-01-01' and HopDong.NgayLamHopDong<= '2019-06-30')
group by HopDong.IDHopDong;

-- *************************************************************** Yeu cau 13 ***********************************************************************
-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng
-- nhiều như nhau).

select * from
(select DichVuDiKem.IDDichVuDikem,DichVuDiKem.TenDichVuDiKem,DichVuDiKem.Gia,DichVuDiKem.TrangThaiKhaDung,
count(HopDongChiTiet.IDHopDongChiTiet) as SoLuongDichVuDiKem
from DichVuDiKem
left join HopDongChiTiet on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by IDDichVuDiKem) as Temp
where SoLuongDichVuDiKem = (select max(SoLuongDichVuDiKem)
from(select DichVuDiKem.IDDichVuDikem,DichVuDiKem.TenDichVuDiKem,DichVuDiKem.Gia,DichVuDiKem.TrangThaiKhaDung,
count(HopDongChiTiet.IDHopDongChiTiet) as SoLuongDichVuDiKem
from DichVuDiKem
left join HopDongChiTiet on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by IDDichVuDiKem )as BangThongKe);

-- ****************************************************************Yeu cau 14 ***********************************************************************
-- Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, 
-- TenDichVuDiKem, SoLanSuDung.

select HopDong.IDHopDong, LoaiDichVu.TenLoaiDichVu , DichVuDiKem.TenDichVuDiKem, count(HopDongChiTiet.IDHopDongChiTiet) as solansudung
from HopDong 
right join DichVu on HopDong.IDDichVu=DichVu.IDDichVu
right join LoaiDichVu on LoaiDichVu.IDLoaiDichVu=DichVu.IDLoaiDichVu
right join HopDongChiTiet on HopDong.IDHopDong=HopDongChiTiet.IDHopDong
join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by TenDichVuDiKem
having solansudung = 1
order by HopDong.IDHopDong;

-- ************************************************************** Yeu cau 15 ************************************************************************
-- Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ
-- năm 2018 đến 2019.

select NhanVien.IDNhanVien, NhanVien.HoTen, TrinhDo.TrinhDo, BoPhan.TenBoPhan, NhanVien.SDT,NhanVien.DiaChi
from NhanVien
join TrinhDo on TrinhDo.IDTrinhDo = NhanVien.IDTrinhDo
join BoPhan on BoPhan.IDBoPhan = NhanVien.IDBoPhan
left Join HopDong on HopDong.IDNhanVien = NhanVien.IDNhanVien
where (HopDong.NgayLamHopDong >='2018-01-01' and HopDong.NgayLamHopDong <='2019-12-31')
group by NhanVien.IDNhanVien
having count(HopDong.IDHopDong) < 4 
order by NhanVien.IDNhanVien;

select * from NhanVien;
-- ************************************************************* Yeu Cau 16 **************************************************************************
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

SET FOREIGN_KEY_CHECKS=0;

delete from nhanvien
where idNhanVien not in (
	select hopdong.idNhanVien
    from hopdong
    where year(hopdong.ngayLamHopDong) between 2017 and 2019
    group by idNhanVien);

delete from NhanVien where 
NhanVien.IDNhanVien in 
(select nhanvientemp.IDNhanVien from (select * from NhanVien) as nhanvientemp join HopDong on nhanvientemp.IDNhanVien = HopDong.IDHopDong
join BoPhan on BoPhan.IDBoPhan=nhanvientemp.IDBoPhan
where  nhanvientemp.IDBoPhan=1 and 
nhanvientemp.IDNhanVien not in 
(select HopDong.IDNhanVien
from HopDong 
join (select * from NhanVien) as nhanvientemp2 on HopDong.IDNhanVien=nhanvientemp2.IDNhanVien
join BoPhan on BoPhan.IDBoPhan = nhanvientemp2.IDBoPhan
where year(HopDong.NgayLamHopDong) between '2017' and '2019' group by HopDong.IDNhanVien));

-- code test

select NhanVien.IDNhanVien,NhanVien.HoTen as hotennhanvien, HopDong.IDHopDong, HopDong.NgayLamHopDong from NhanVien
left join HopDong on HopDong.IDNhanVien= NhanVien.IDNhanVien;


-- ************************************************************** Yeu cau 17 ***********************************************************************
-- Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền
-- thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update KhachHang as kh1 join (
select KhachHang.IDKhachHang,HopDong.NgayLamHopDong
from KhachHang 
join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
left join HopDong on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by KhachHang.HoTen,KhachHang.IDLoaiKhach
having KhachHang.IDLoaiKhach = 2 
and (sum(DichVu.ChiPhiThue + HopDongChiTiet.SoLuong * DichVuDiKem.Gia) > 10000000 and year(HopDong.NgayLamHopDong) ='2019')
order by KhachHang.IDKhachHang) as kh2
set kh1.IDLoaiKhach = 1
where kh1.IDKhachHang =  kh2.IDKhachHang ;
-- code test:
/*
select KhachHang.IDKhachHang, KhachHang.HoTen, LoaiKhach.TenLoaiKhach, HopDong.IDHopDong,  DichVu.TenDichVu, HopDong.NgayLamHopDong,
HopDong.NgayKetThuc, sum(DichVu.ChiPhiThue + HopDongChiTiet.SoLuong * DichVuDiKem.Gia) as 'Tong tien'
from KhachHang 
join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
left join HopDong on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join DichVu on DichVu.IDDichVu = HopDong.IDDichVu
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by KhachHang.IDKhachHang
order by HopDong.IDHopDong;
*/

-- ****************************************************************** Yeu cau 18 *********************************************************************
-- Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
SET FOREIGN_KEY_CHECKS=0;
delete from KhachHang where 
KhachHang.IDKhachHang in 
(
select khachhangtemp.IDKhachHang from (select * from KhachHang) as khachhangtemp 
join HopDong on khachhangtemp.IDKhachHang = HopDong.IDKhachHang
where  year(HopDong.NgaylamHopDong) < '2016'
);
-- code test
/*
select * from KhachHang;
*/

-- ******************************************************************* Yeu cau 19 ********************************************************************
-- Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update DichVuDiKem as dvdk1
join (
select * from
(select DichVuDiKem.IDDichVuDikem,DichVuDiKem.TenDichVuDiKem,DichVuDiKem.Gia,DichVuDiKem.TrangThaiKhaDung,
count(HopDongChiTiet.IDHopDongChiTiet) as SoLuongDichVuDiKem , HopDong.IDHopDong, HopDong.NgayLamHopDong
from DichVuDiKem
left join HopDongChiTiet on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
left join HopDong on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
group by DichVuDiKem.IDDichVuDiKem) as Temp
where (year(temp.NgayLamHopDong) = '2019') and SoLuongDichVuDiKem >=10
) as dvdk2
set dvdk1.Gia = dvdk1.Gia * 2
where (dvdk1.IDDichVuDiKem = dvdk2.IDDichVuDiKem);
 -- code test
 /*
select * from DichVuDiKem;
*/

-- ******************************************************************* Yeu cau 20 ********************************************************************
-- Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email,
-- SoDienThoai, NgaySinh, DiaChi.

select KhachHang.IDKhachHang as id,KhachHang.HoTen, KhachHang.Email, KhachHang.SDT, KhachHang.NgaySinh, KhachHang.DiaChi
from KhachHang
union all
select NhanVien.IDNhanVien as id,NhanVien.HoTen, NhanVien.Email, NhanVien.SDT, NhanVien.NgaySinh, NhanVien.DiaChi
from NhanVien;