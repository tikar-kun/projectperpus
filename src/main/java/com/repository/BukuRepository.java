package com.repository;

import com.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, String> {
    @Query(value = "select b from Buku b where b.judulBuku =:judulBuku")
    List<Buku> findByJudulBuku(String judulBuku);

    List<Buku> findAllByNamaKategori(String namaKategori);

    @Modifying
    @Query("UPDATE Buku b SET b.status = 'diarsipkan' WHERE b.idBuku =:idBuku")
    int arsipBuku(String idBuku);

    @Modifying
    @Query("UPDATE Buku b SET b.status = 'tersedia' WHERE b.idBuku =:idBuku")
    int adaBuku(String idBuku);

}
