package com.model.dto;

public class BukuDto {
    private String kode;
    private String judul;
    private String penulis;
    private String penerbit;
    private int stok;
    public String kodeTransbuku;

    public String getKodeTransbuku() {
        return kodeTransbuku;
    }

    public void setKodeTransbuku(String kodeTransbuku) {
        this.kodeTransbuku = kodeTransbuku;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
