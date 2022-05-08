package com.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "t_denda")
public class Denda {
    @Id
    @Column (name = "kode_denda")
    private String kodeDenda;

    @Column (name = "besar_denda")
    private long besarDenda;

    @OneToOne
    @JoinColumn (name = "kode_transaksi")
    private Transaksi kodeTransaksi;
    @ManyToOne
    @JoinColumn
    private Pengguna kodePengguna;

    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }
    public long getBesarDenda() {
        return this.besarDenda;
    }

    public void setBesarDenda(long besarDenda) {
        this.besarDenda = besarDenda;
    }

    public Transaksi getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(Transaksi kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Pengguna getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(Pengguna kodePengguna) {
        this.kodePengguna = kodePengguna;
    }
}
