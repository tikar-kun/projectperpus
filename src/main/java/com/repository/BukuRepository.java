package com.repository;

import com.model.entity.Buku;
import com.model.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, String> {
    @Query(value = "select b from Buku b where b.judulBuku = :buku", nativeQuery = false)
    Optional<Buku> findBukuByName(@PathParam("buku") String buku);
    @Query(value = "SELECT b FROM Buku b WHERE b.idBuku = :id_buku")
    Optional<Buku> findBukuById(@PathParam("id_buku") String id_buku);
}
