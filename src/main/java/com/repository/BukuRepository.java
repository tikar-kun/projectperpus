package com.repository;

import com.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, String> {
    @Query(value = "select b from Buku b where b.judulBuku = :buku", nativeQuery = false)
    public Optional<Buku> findBukuByName(@PathParam("buku") String buku);
}
