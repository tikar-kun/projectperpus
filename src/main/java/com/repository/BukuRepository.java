package com.repository;

import com.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, String> {
    @Query(value = "select b from Buku b where b.judulBuku like '%name'", nativeQuery = false)
    Optional<Buku> findBukuByName(String name);

    List<Buku> findAllByNamaKategori(String namaKategori);

    @Modifying
    @Query("UPDATE Buku b SET b.status = 'diarsipkan' WHERE b.idBuku =:idBuku")
    int arsipBuku(String idBuku);

    @Modifying
    @Query("UPDATE Buku b SET b.status = 'tersedia' WHERE b.idBuku =:idBuku")
    int adaBuku(String idBuku);
}
