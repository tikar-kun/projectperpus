package com.repository;

import com.model.entity.Buku;
import com.model.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    @Query(value = "select t from Transaksi t where t.kodeTransaksi = :kode", nativeQuery = false)
    public Optional<Buku> findTransaksiByKodeTransaksi(@PathParam("kode") String buku);
}
