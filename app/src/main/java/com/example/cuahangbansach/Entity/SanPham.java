package com.example.cuahangbansach.Entity;

public class SanPham {
    private int id;
    private String tenSP, loaiSP;
    private int giaBan;
    private String hinhAnh;

    public SanPham() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public SanPham(int id, String tenSP, String loaiSP, int giaBan, String hinhAnh) {
        this.id = id;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaBan = giaBan;
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return String.format(" Tên sách: %s \n Loại sách: %s \n Giá bán: %s", tenSP, loaiSP, giaBan);
    }
}
