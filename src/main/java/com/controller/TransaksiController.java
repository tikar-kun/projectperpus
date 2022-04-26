package com.controller;

import com.model.dto.TransaksiDto;
import com.model.entity.Buku;
import com.model.entity.Pengguna;
import com.model.entity.Transaksi;
import com.model.entity.Transbuku;
import com.repository.BukuRepository;
import com.repository.PenggunaRepository;
import com.repository.TransaksiRepository;
import com.repository.TransbukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Transaksi")
public class TransaksiController {
    private final TransbukuRepository transbukuRepository;
    private final PenggunaRepository penggunaRepository;
    private final TransaksiRepository transaksiRepository;
    @Autowired
    public TransaksiController(BukuRepository bukuRepository, TransbukuRepository transbukuRepository, PenggunaRepository penggunaRepository, TransaksiRepository transaksiRepository) {
        this.transbukuRepository = transbukuRepository;
        this.penggunaRepository = penggunaRepository;
        this.transaksiRepository = transaksiRepository;
    }


    // convert dto to entity
    public Transaksi convertDtoToEntity (TransaksiDto transaksiDto){
        Transaksi transaksi = new Transaksi();
        transaksi.setKodeTransaksi(transaksiDto.getKode());
        transaksi.setTanggalPinjam(transaksiDto.getTanggalPinjam());
        transaksi.setTanggalKembali(transaksiDto.getTanggalKembali());
        if(transbukuRepository.findById(transaksiDto.getKodeTransbuku()).isPresent()){
            Transbuku transbuku = transbukuRepository.findById(transaksiDto.getKodeTransbuku()).get();
            transaksi.setTransbuku(transbuku);
        }
        if(penggunaRepository.findById(transaksiDto.getKodePengguna()).isPresent()){
            Pengguna pengguna = penggunaRepository.findById(transaksiDto.getKodePengguna()).get();
            pengguna.setKodePengguna(String.valueOf(pengguna));
        }
        return transaksi;
    }

    // convert to dto
    private TransaksiDto convertEntityToDto(Transaksi transaksi){
        TransaksiDto dto = new TransaksiDto();
        dto.setKode(transaksi.getKodeTransaksi());
        dto.setTanggalPinjam(transaksi.getTanggalPinjam());
        dto.setTanggalKembali(transaksi.getTanggalKembali());
        dto.setKodePengguna(transaksi.getKodePengguna().getKodePengguna());
        dto.setKodeTransbuku(transaksi.getTransbuku().getKodeTransbuku());
        return dto;
    }
}
