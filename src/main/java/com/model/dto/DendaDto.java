package com.model.dto;

public class DendaDto {
    private String kodeDenda;
    private Integer besarDenda;
    private String kodeTransaksi;

    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public Integer getBesarDenda() {
        return besarDenda;
    }

    public void setBesarDenda(Integer besarDenda) {
        this.besarDenda = besarDenda;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }
}
