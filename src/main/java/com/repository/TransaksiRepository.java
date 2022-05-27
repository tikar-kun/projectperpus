package com.repository;

import com.model.entity.Buku;
import com.model.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
//    boolean findById(boolean empty);

//    @Query(value = "select t from Transaksi t where t.kodeTransaksi = :kode_transaksi")
//    public Optional<Transaksi> findTransaksiByKode(String transaksi);

    public Transaksi findByKodeTransaksi(String kodeTransaksi);
    @Query(value = "select t from Transaksi t where t.tanggalPinjam =:tanggalPinjam")
    List<Transaksi> findByTanggalPinjam(Date tanggalPinjam);

}
