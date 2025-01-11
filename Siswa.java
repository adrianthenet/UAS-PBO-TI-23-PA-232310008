package com.projectuas;
public class Siswa {
    private String studentID;
    private String nama;
    private int usia;
    private String jenisKelamin;
    private String etnis;

    public Siswa(String studentID, String nama, int usia, String jenisKelamin, String etnis) {
        this.studentID = studentID;
        this.nama = nama;
        this.usia = usia;
        this.jenisKelamin = jenisKelamin;
        this.etnis = etnis;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getEtnis() {
        return etnis;
    }
}