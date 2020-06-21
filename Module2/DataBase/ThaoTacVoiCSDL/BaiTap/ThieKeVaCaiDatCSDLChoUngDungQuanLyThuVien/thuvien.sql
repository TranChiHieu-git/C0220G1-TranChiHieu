-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: thuvien
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
-- Table structure for table `loaisach`
--

DROP TABLE IF EXISTS `loaisach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaisach` (
  `maloaisach` varchar(10) NOT NULL,
  `tenloaisach` varchar(50) NOT NULL,
  PRIMARY KEY (`maloaisach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaisach`
--

LOCK TABLES `loaisach` WRITE;
/*!40000 ALTER TABLE `loaisach` DISABLE KEYS */;
INSERT INTO `loaisach` VALUES ('001','Van Hoc'),('002','Kinh Te'),('003','Tieng Anh'),('004','Khoa Hoc'),('005','Thieu nhi');
/*!40000 ALTER TABLE `loaisach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuon`
--

DROP TABLE IF EXISTS `phieumuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuon` (
  `maphieumuon` varchar(10) NOT NULL,
  `nguoimuon` varchar(50) NOT NULL,
  `sachcanmuon` varchar(50) NOT NULL,
  `ngaymuon` date NOT NULL,
  `ngaytra` date NOT NULL,
  PRIMARY KEY (`maphieumuon`),
  KEY `sachcanmuon` (`sachcanmuon`),
  KEY `nguoimuon` (`nguoimuon`),
  CONSTRAINT `phieumuon_ibfk_1` FOREIGN KEY (`sachcanmuon`) REFERENCES `sach` (`masach`),
  CONSTRAINT `phieumuon_ibfk_2` FOREIGN KEY (`nguoimuon`) REFERENCES `sinhvien` (`masinhvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuon`
--

LOCK TABLES `phieumuon` WRITE;
/*!40000 ALTER TABLE `phieumuon` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieumuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `masach` varchar(10) NOT NULL,
  `tensach` varchar(250) NOT NULL,
  `tacgia` varchar(50) NOT NULL,
  `nhaxuatban` varchar(50) NOT NULL,
  `gia` double NOT NULL,
  `maloaisach` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`masach`),
  KEY `maloaisach` (`maloaisach`),
  CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`maloaisach`) REFERENCES `loaisach` (`maloaisach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('001','Lac giua niem dau','nguyen ngoc thach','nha xuat ban hoi nha van',42510,'001'),('002','Tiep thi 4.0','nguyen khoa hong thanh','nha xuat ban tre',59099,'002'),('003','Tai chinh doanh nghiep','McGraw-Hill','nha xuat ban kinh te tp.HCM',369000,'002'),('004','Hoang tu be','Antoine De Saint-Exupéry','nha xuat ban hoi nha van',45000,'005'),('005','English Grammar in Use Book w Ans','Raymond Murphy','nha xuat ban cambridge',170000,'003'),('006','Lam ban voi bau troi','nguyen nhat anh','nha xuat ban tre',66000,'001'),('007','Nha gia kim','Paulo Coelho','nha xuat ban van hoc',41400,'005'),('008','Khoa Học Khám Phá - Vũ Trụ Toàn Ảnh','Michael Talbot','nha xuat ban tre',179000,'004'),('009','Outliers - The Story Of Success','Malcolm Gladwell','nha xuat ban guide inside',148000,'003'),('010','Khoa Học Khám Phá - Mật Mã - Từ Cổ Điển Đến Lượng Tử','Simon Singh','nha xuat ban tre',144000,'004');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `masinhvien` varchar(10) NOT NULL,
  `tensinhvien` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `image` blob,
  PRIMARY KEY (`masinhvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES ('001','Tran Chi Hieu','Quang Tri','hieu13001@gmail.com',NULL),('002','Tran Van Tuan','Da Nang','tuan1111@gmail.com',NULL),('003','Nguyen Van A','Hue','at22111@gmail.com',NULL),('004','Le Dinh B','Da Nang','baa1111@gmail.com',NULL),('005','Tran Van Long','Quang Nam','long2211@gmail.com',NULL);
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-30 10:55:18
