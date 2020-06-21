-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: furama
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bophan`
--

DROP TABLE IF EXISTS `bophan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bophan` (
  `IDBoPhan` int NOT NULL,
  `TenBoPhan` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDBoPhan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bophan`
--

LOCK TABLES `bophan` WRITE;
/*!40000 ALTER TABLE `bophan` DISABLE KEYS */;
INSERT INTO `bophan` VALUES (1,'Sale-Marketing'),(2,'Hanh Chinh'),(3,'Phuc Vu'),(4,'Quan Ly');
/*!40000 ALTER TABLE `bophan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `IDDichVu` int NOT NULL,
  `TenDichVu` varchar(50) DEFAULT NULL,
  `DienTich` int DEFAULT NULL,
  `SoTang` int DEFAULT NULL,
  `SoNguoiToiDa` varchar(50) DEFAULT NULL,
  `ChiPhiThue` varchar(50) DEFAULT NULL,
  `IDKieuThue` int DEFAULT NULL,
  `IDLoaiDichVu` int DEFAULT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDDichVu`),
  KEY `IDKieuThue` (`IDKieuThue`),
  KEY `IDLoaiDichVu` (`IDLoaiDichVu`),
  CONSTRAINT `dichvu_ibfk_1` FOREIGN KEY (`IDKieuThue`) REFERENCES `kieuthue` (`IDKieuThue`),
  CONSTRAINT `dichvu_ibfk_2` FOREIGN KEY (`IDLoaiDichVu`) REFERENCES `loaidichvu` (`IDLoaiDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'Villa thue theo gio',2000,4,'20 nguoi','500000',4,1,'Con phong'),(2,'Villa thue theo ngay',2000,4,'20 nguoi','12000000',3,1,'Con phong'),(3,'Villa thue theo thang',2000,4,'20 nguoi','360000000',2,1,'Con phong'),(4,'Villa thue theo nam',2000,4,'20 nguoi','4320000000',1,1,'Con phong'),(5,'House thue theo gio',1500,2,'10 nguoi','300000',4,2,'Con phong'),(6,'House thue theo ngay',1500,2,'10 nguoi','7200000',3,2,'Con phong'),(7,'House thue theo thang',1500,2,'10 nguoi','216000000',2,2,'Con phong'),(8,'House thue theo nam',1500,2,'10 nguoi','2592000000',1,2,'Con phong'),(9,'Room thue theo gio',1000,0,'4 nguoi','100000',4,3,'Con phong'),(10,'Room thue theo ngay',1000,0,'4 nguoi','2400000',3,3,'Con phong'),(11,'Room thue theo thang',1000,0,'4 nguoi','72000000',2,3,'Con phong'),(12,'Room thue theo nam',1000,0,'4 nguoi','864000000',1,3,'Con phong');
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvudikem`
--

DROP TABLE IF EXISTS `dichvudikem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvudikem` (
  `IDDichVuDiKem` int NOT NULL,
  `TenDichVuDiKem` varchar(50) DEFAULT NULL,
  `Gia` int DEFAULT NULL,
  `DonVi` int DEFAULT NULL,
  `TrangThaiKhaDung` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDDichVuDiKem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvudikem`
--

LOCK TABLES `dichvudikem` WRITE;
/*!40000 ALTER TABLE `dichvudikem` DISABLE KEYS */;
INSERT INTO `dichvudikem` VALUES (1,'massage',500000,1,'Dang mo'),(2,'karaoke',600000,1,'Dang mo'),(3,'thuc an',200000,1,'Dang mo'),(4,'nuoc uong',50000,1,'Dang mo'),(5,'thue xe',1000000,1,'Dang mo');
/*!40000 ALTER TABLE `dichvudikem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdong`
--

DROP TABLE IF EXISTS `hopdong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdong` (
  `IDHopDong` int NOT NULL,
  `IDNhanVien` int DEFAULT NULL,
  `IDKhachHang` int DEFAULT NULL,
  `IDDichVu` int DEFAULT NULL,
  `NgayLamHopDong` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `TienDatCoc` int DEFAULT NULL,
  `TongTien` int DEFAULT NULL,
  PRIMARY KEY (`IDHopDong`),
  KEY `IDNhanVien` (`IDNhanVien`),
  KEY `IDKhachHang` (`IDKhachHang`),
  KEY `IDDichVu` (`IDDichVu`),
  CONSTRAINT `hopdong_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`IDNhanVien`),
  CONSTRAINT `hopdong_ibfk_2` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`IDKhachHang`),
  CONSTRAINT `hopdong_ibfk_3` FOREIGN KEY (`IDDichVu`) REFERENCES `dichvu` (`IDDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdong`
--

LOCK TABLES `hopdong` WRITE;
/*!40000 ALTER TABLE `hopdong` DISABLE KEYS */;
INSERT INTO `hopdong` VALUES (1,1,1,1,'2019-04-30','2019-05-02',500000,0),(2,9,2,5,'2019-11-30','2019-12-02',500000,0),(3,1,3,9,'2019-08-30','2019-09-02',500000,0),(4,9,4,3,'2019-01-30','2019-02-02',500000,0),(5,10,5,6,'2019-04-28','2019-05-05',500000,0),(6,9,6,10,'2019-10-30','2019-11-02',500000,0),(7,1,7,3,'2019-04-30','2019-05-02',500000,0),(8,1,1,1,'2019-02-28','2019-03-02',500000,0),(9,9,6,11,'2018-04-30','2018-05-02',500000,0),(10,9,6,12,'2019-01-14','2019-01-26',500000,0),(11,10,12,11,'2019-01-14','2019-01-26',500000,0),(12,1,3,4,'2018-01-14','2018-01-26',500000,0),(13,10,3,4,'2017-01-14','2017-01-26',500000,0),(14,11,5,3,'2016-01-14','2016-01-26',500000,0),(15,1,13,3,'2015-01-14','2015-01-26',500000,0);
/*!40000 ALTER TABLE `hopdong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdongchitiet`
--

DROP TABLE IF EXISTS `hopdongchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdongchitiet` (
  `IDHopDongChiTiet` int NOT NULL,
  `IDHopDong` int DEFAULT NULL,
  `IDDichVuDiKem` int DEFAULT NULL,
  `SoLuong` int DEFAULT NULL,
  PRIMARY KEY (`IDHopDongChiTiet`),
  KEY `IDHopDong` (`IDHopDong`),
  KEY `IDDichVuDiKem` (`IDDichVuDiKem`),
  CONSTRAINT `hopdongchitiet_ibfk_1` FOREIGN KEY (`IDHopDong`) REFERENCES `hopdong` (`IDHopDong`),
  CONSTRAINT `hopdongchitiet_ibfk_2` FOREIGN KEY (`IDDichVuDiKem`) REFERENCES `dichvudikem` (`IDDichVuDiKem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdongchitiet`
--

LOCK TABLES `hopdongchitiet` WRITE;
/*!40000 ALTER TABLE `hopdongchitiet` DISABLE KEYS */;
INSERT INTO `hopdongchitiet` VALUES (1,1,2,2),(2,2,2,2),(3,3,3,2),(4,4,4,2),(5,5,5,2),(6,6,2,2),(7,7,2,2),(8,8,3,2),(9,9,4,2),(10,10,1,2),(11,13,2,2),(13,11,2,2),(14,12,2,2),(15,1,4,2),(16,2,2,2),(17,3,1,2),(18,2,2,2),(19,13,3,2),(20,14,2,2),(21,15,1,3);
/*!40000 ALTER TABLE `hopdongchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `IDKhachHang` int NOT NULL,
  `IDLoaiKhach` int DEFAULT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SoCMND` varchar(50) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDKhachHang`),
  KEY `IDLoaiKhach` (`IDLoaiKhach`),
  CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`IDLoaiKhach`) REFERENCES `loaikhach` (`IDLoaiKhach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,1,'Tran Chi Hieu','1997-08-28','197400619','0383296403','hieu5713@gmail.com','Quang Tri'),(2,2,'Nguyen Quoc Tuan','1994-02-12','12541219','0373156709','tuannguyen4@gmail.com','Da Nang'),(3,1,'Tran Van Hung','1999-11-03','122400675','0973826203','tvhung9874@gmail.com','Hue'),(4,4,'Le Quoc Thien','1992-12-11','193454612','0153846115','thienkenja@gmail.com','Da Nang'),(5,5,'Nguyen Ngoc Huy','1992-02-18','191219133','0384893115','huyaa11@gmail.com','Quang Nam'),(6,1,'Nguyen Ngoc Hung','1994-03-28','192480413','0139842655','hungnguyen11@gmail.com','Vinh'),(7,1,'Le Ngoc Quoc','1990-03-14','131410121','0159658777','quocle555@gmail.com','Da Nang'),(8,2,'Le Van Tuan','2004-03-14',NULL,'0159658777','tuanvan123@gmail.com','Da Nang'),(9,1,'Le Van anh','2005-03-14',NULL,'0269571230','aaa3@gmail.com','Vinh'),(10,3,'Le Quoc Thien','1994-01-25','138210431','0119432460','quocle555@gmail.com','Quang Nam'),(11,4,'Nguyen Ngoc Hung','1998-01-15','175311731','0721639430','hungnguyen123@gmail.com','Hue'),(12,1,'Nguyen Quoc Hung','1995-01-15','172912581','0159637530','hungnq11@gmail.com','Vinh');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kieuthue`
--

DROP TABLE IF EXISTS `kieuthue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kieuthue` (
  `IDKieuThue` int NOT NULL,
  `TenKieuThue` varchar(50) DEFAULT NULL,
  `Gia` int DEFAULT NULL,
  PRIMARY KEY (`IDKieuThue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kieuthue`
--

LOCK TABLES `kieuthue` WRITE;
/*!40000 ALTER TABLE `kieuthue` DISABLE KEYS */;
INSERT INTO `kieuthue` VALUES (1,'Nam',8760),(2,'Thang',720),(3,'Ngay',24),(4,'Gio',1);
/*!40000 ALTER TABLE `kieuthue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaidichvu`
--

DROP TABLE IF EXISTS `loaidichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaidichvu` (
  `IDLoaiDichVu` int NOT NULL,
  `TenLoaiDichVu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDLoaiDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaidichvu`
--

LOCK TABLES `loaidichvu` WRITE;
/*!40000 ALTER TABLE `loaidichvu` DISABLE KEYS */;
INSERT INTO `loaidichvu` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `loaidichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaikhach`
--

DROP TABLE IF EXISTS `loaikhach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaikhach` (
  `IDLoaiKhach` int NOT NULL,
  `TenLoaiKhach` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDLoaiKhach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaikhach`
--

LOCK TABLES `loaikhach` WRITE;
/*!40000 ALTER TABLE `loaikhach` DISABLE KEYS */;
INSERT INTO `loaikhach` VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `loaikhach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `IDNhanVien` int NOT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  `IDViTri` int DEFAULT NULL,
  `IDTrinhDo` int DEFAULT NULL,
  `IDBoPhan` int DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SoCMND` varchar(50) DEFAULT NULL,
  `Luong` varchar(50) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDNhanVien`),
  KEY `IDViTri` (`IDViTri`),
  KEY `IDTrinhDo` (`IDTrinhDo`),
  KEY `IDBoPhan` (`IDBoPhan`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`IDViTri`) REFERENCES `vitri` (`IDViTri`),
  CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`IDTrinhDo`) REFERENCES `trinhdo` (`IDTrinhDo`),
  CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`IDBoPhan`) REFERENCES `bophan` (`IDBoPhan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Nguyen Van Tuan Abc',1,2,1,'1998-01-21','123456789','10000000','0236548975','nhanviena@gmail.com','Da Nang'),(9,'Nguyen Van Anh',1,1,1,'1998-10-11','1597370466','7000000','0193556482','nhanvieni@gmail.com','Hue'),(10,'Tran Huu Thanh',1,2,1,'1998-01-21','123456789','10000000','0236548975','nhanviena@gmail.com','Da Nang');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trinhdo`
--

DROP TABLE IF EXISTS `trinhdo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trinhdo` (
  `IDTrinhDo` int NOT NULL,
  `TrinhDo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDTrinhDo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trinhdo`
--

LOCK TABLES `trinhdo` WRITE;
/*!40000 ALTER TABLE `trinhdo` DISABLE KEYS */;
INSERT INTO `trinhdo` VALUES (1,'Trung Cap'),(2,'Cao Dang'),(3,'Dai Hoc'),(4,'Sau Dai Hoc');
/*!40000 ALTER TABLE `trinhdo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vitri`
--

DROP TABLE IF EXISTS `vitri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vitri` (
  `IDViTri` int NOT NULL,
  `TenViTri` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDViTri`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vitri`
--

LOCK TABLES `vitri` WRITE;
/*!40000 ALTER TABLE `vitri` DISABLE KEYS */;
INSERT INTO `vitri` VALUES (1,'Le Tan'),(2,'Phuc Vu'),(3,'Chuyen Vien'),(4,'Giam Sat'),(5,'Quan Ly'),(6,'Giam Doc');
/*!40000 ALTER TABLE `vitri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-06 15:00:11
