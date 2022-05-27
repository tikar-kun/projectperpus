package com.service;

import com.controller.DendaController;
import com.model.dto.DendaDto;
import com.model.entity.Denda;
import com.model.entity.Transaksi;
import com.repository.DendaRepository;
import com.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class TransaksiServicelmpl implements TransaksiService{
    @Autowired
    private TransaksiRepository transaksiRepository;
    private DendaRepository dendaRepository;
    private DendaDto dendaDto;
    private DendaController dendaController;


    @Override
    public Transaksi insertDataTransaksi(Transaksi transaksi) {
        return null;
    }

    @Override
    public long selisihHari(Transaksi transaksi, String kodeTransaksi) {
        Transaksi transaksi1 = transaksiRepository.findByKodeTransaksi(kodeTransaksi);
    if(transaksi1==null){
        throw new RuntimeException("kode transaksi tidak ditemukan");
    }
     Date pinjam = transaksi1.getTanggalPinjam();
     Date kembali = transaksi1.getTanggalKembali();
     long diff = kembali.getTime()- pinjam.getTime();
     long diffDays = (diff/(24*60*60*1000));
     return diffDays;
    }

    @Override
    public long besarDenda(long telat) {
        long besarDenda = 3000*(telat-3);
        return besarDenda;
    }
}
//        Transaksi entity = transaksiRepository.getById(transaksidto.getKodePengguna());
//        Date pinjam = transaksidto.getTanggalPinjam();
//        Date kembali = transaksidto.getTanggalKembali();