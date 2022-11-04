package com.example.bt10sqlite.Model;

public class SinhVien {
    String idSinhVien,nameSinhVien,idLop;


    public SinhVien(String idSinhVien, String nameSinhVien, String idLop) {
        this.idSinhVien = idSinhVien;
        this.nameSinhVien = nameSinhVien;
        this.idLop = idLop;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getNameSinhVien() {
        return nameSinhVien;
    }

    public void setNameSinhVien(String nameSinhVien) {
        this.nameSinhVien = nameSinhVien;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }
}
