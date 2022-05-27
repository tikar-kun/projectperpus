package com.model.dto;

import com.model.entity.Buku;
import com.model.entity.Denda;
import com.model.entity.Pengguna;
import com.model.entity.Transaksi;

public class DetailTransDto {
    private String kodeDetail;
    private Pengguna kodePengguna;
    private Buku idBuku;
    private Transaksi kodeTransaksi;
    private Denda kodeDenda;
    private String jenis;

    public String getKodeDetail() {
        return kodeDetail;
    }

    public void setKodeDetail(String kodeDetail) {
        this.kodeDetail = kodeDetail;
    }

    public Pengguna getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(Pengguna kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public Buku getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Buku idBuku) {
        this.idBuku = idBuku;
    }

    public Transaksi getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(Transaksi kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Denda getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(Denda kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
