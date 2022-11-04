package com.example.bt10sqlite.Model;

public class Lop {
    String idLop,nameLop;

    public Lop() {
    }

    public Lop(String idLop, String nameLop) {
        this.idLop = idLop;
        this.nameLop = nameLop;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getNameLop() {
        return nameLop;
    }

    public void setNameLop(String nameLop) {
        this.nameLop = nameLop;
    }

    @Override
    public String toString() {
        return "Lớp: "+ idLop +"\n"+"Khoa: "+nameLop;
    }
}
