create database thuvien;

create table loaisach(
maloaisach varchar(10) not null primary key,
tenloaisach varchar(50) not null
);

insert into loaisach
values ('001','Van Hoc'),('002','Kinh Te'),('003','Tieng Anh'),('004','Khoa Hoc'),('005','Thieu nhi');

create table sach(
masach varchar(10) not null primary key,
tensach varchar(250) not null,
tacgia varchar(50) not null,
nhaxuatban varchar(50) not null,
gia float(50) not null,
maloaisach varchar(10),
foreign key(maloaisach) references loaisach(maloaisach)
);

insert into sach
values ('001','Lac giua niem dau','nguyen ngoc thach','nha xuat ban hoi nha van',42510.0,'001'),
('002','Tiep thi 4.0','nguyen khoa hong thanh','nha xuat ban tre',59099.0,'002'),
('003','Tai chinh doanh nghiep','McGraw-Hill','nha xuat ban kinh te tp.HCM',369000.0,'002'),
('004','Hoang tu be','Antoine De Saint-Exupéry','nha xuat ban hoi nha van',45000.0,'005'),
('005','English Grammar in Use Book w Ans','Raymond Murphy','nha xuat ban cambridge',170000.0,'003'),
('006','Lam ban voi bau troi','nguyen nhat anh','nha xuat ban tre',66000.0,'001'),
('007','Nha gia kim','Paulo Coelho','nha xuat ban van hoc',41400.0,'005'),
('008','Khoa Học Khám Phá - Vũ Trụ Toàn Ảnh','Michael Talbot','nha xuat ban tre',179000.0,'004'),
('009','Outliers - The Story Of Success','Malcolm Gladwell','nha xuat ban guide inside',148000.0,'003'),
('010','Khoa Học Khám Phá - Mật Mã - Từ Cổ Điển Đến Lượng Tử','Simon Singh','nha xuat ban tre',144000.0,'004')
;

create table phieumuon(
maphieumuon varchar(10) not null primary key,
nguoimuon varchar(50) not null,
sachcanmuon varchar(50) not null,
ngaymuon date not null,
ngaytra date not null,
foreign key(sachcanmuon) references sach(masach),
foreign key(nguoimuon) references sinhvien(masinhvien)
);

create table sinhvien(
masinhvien varchar(10) not null primary key,
tensinhvien varchar(50) not null,
diachi varchar(50) not null,
email varchar(50) not null,
image blob 
);

insert into sinhvien
values ('001','Tran Chi Hieu','Quang Tri','hieu13001@gmail.com',null),
('002','Tran Van Tuan','Da Nang','tuan1111@gmail.com',null),
('003','Nguyen Van A','Hue','at22111@gmail.com',null),
('004','Le Dinh B','Da Nang','baa1111@gmail.com',null),
('005','Tran Van Long','Quang Nam','long2211@gmail.com',null);