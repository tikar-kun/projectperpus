package com.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "t_denda")
public class Denda {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "kode_denda")
    private String kodeDenda;

    @Column (name = "jumlah_hari_terlambat")
    private Long telat;
    @Column (name = "besar_denda")
    private Long besarDenda;


    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }
    public Long getBesarDenda() {
        return this.besarDenda;
    }

    public void setBesarDenda(Long besarDenda) {
        this.besarDenda = besarDenda;
    }

    public Long getTelat() {
        return telat;
    }

    public void setTelat(Long telat) {
        this.telat = telat;
    }


}
