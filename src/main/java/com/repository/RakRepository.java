package com.repository;

import com.model.entity.Rak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface RakRepository extends JpaRepository<Rak, String> {
    @Query(value = "select r from Rak r where r.namaRak = :rak", nativeQuery = false)
    public Optional<Rak> findRakByNama(@PathParam("rak") String rak);
}
