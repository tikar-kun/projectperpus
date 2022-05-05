package com.model.dto;

public class DendaDto {
    private String kodeDenda;
    private long besarDenda;
    private String kodeTransaksi;
    private String kodePengguna;

    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public long getBesarDenda() {
        return besarDenda;
    }

    public void setBesarDenda(long besarDenda) {
        this.besarDenda = besarDenda;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
    }
}
