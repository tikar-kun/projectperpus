package com.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_rak")
public class Rak {
    @Id
    @Column(name = "kode_rak", length = 25)
    private String kodeRak;

    @Column(name = "nama_rak")
    private String namaRak;

    @Column(name = "lokasi_rak")
    private String lokasiRak;

    @OneToMany
    @JoinColumn(name = "kode_buku", nullable = false)
    private List<Buku> buku;

    public String getKodeRak() {
        return kodeRak;
    }

    public void setKodeRak(String kodeRak) {
        this.kodeRak = kodeRak;
    }

    public String getNamaRak() {
        return namaRak;
    }

    public void setNamaRak(String namaRak) {
        this.namaRak = namaRak;
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        this.lokasiRak = lokasiRak;
    }

    public List<Buku> getBuku() {
        return buku;
    }

    public void setBuku(List<Buku> buku) {
        this.buku = buku;
    }
}
