/*Buat database jika belum ada, jika sudah ada cukup jalankan query pembuat table*/
CREATE DATABASE sinau;

USE sinau;

/*Buat table baru supaya tidak mengganggu koding pertemuan sebelumnya*/
CREATE TABLE `sinau`.`mahasiswa2` (
  `nim` VARCHAR(15) NOT NULL,
  `nama` VARCHAR(50) NOT NULL,
  `jeniskelamin` VARCHAR(10) NOT NULL,
  `angkatan` VARCHAR(4) NOT NULL,
  `nohp` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`nim`));

INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12308948474','budi','LAKI-LAKI','2008','0837354469');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12308837362','joni','LAKI-LAKI','2008','089385642');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12308837483','johan','LAKI-LAKI','2008','087638839');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12308027824','yuri','PEREMPUAN','2008','0821874835');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12307847839','yuda','LAKI-LAKI','2007','0822953533');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12307568477','yuki','PEREMPUAN','2007','0899834335');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12306788463','maya','PEREMPUAN','2006','0812737435');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12305948542','heru','LAKI-LAKI','2005','0832846565');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12309976495','yodan','LAKI-LAKI','2009','0803473744');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12310183635','nami','PEREMPUAN','2010','0882375235');
INSERT INTO `mahasiswa2`(nim,nama,jeniskelamin,angkatan,nohp) VALUES('12310947363','farah','PEREMPUAN','2010','0892745244');
