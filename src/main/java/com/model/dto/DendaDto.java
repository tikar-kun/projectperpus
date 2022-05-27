package com.model.dto;

public class DendaDto {

    private String kodeDenda;
    private Long besarDenda;
    private String kodeTransaksi;
    private String kodePengguna;
    private Long telat;
    private Long bayar;


    public Long getBesarDenda() {
        return besarDenda;
    }

    public void setBesarDenda(Long besarDenda) {
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

    public Long getTelat() {
        return telat;
    }

    public void setTelat(Long telat) {
        this.telat = telat;
    }

    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public Long getBayar() {
        return bayar;
    }

    public void setBayar(Long bayar) {
        this.bayar = bayar;
    }
}
