package com.repository;

import com.model.entity.Buku;
import com.model.entity.Denda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Repository
public interface DendaRepository extends JpaRepository<Denda, String> {
    @Query(value = "SELECT d FROM Denda d WHERE d.kodeDenda = :kodeDenda")
    Optional<Denda> findDendaById(@PathParam("kode_denda") String kodeDenda);

    public Denda findByKodeDenda (String kodeDenda);
}
