package com.controller;

import com.model.dto.TransaksiDto;
import com.model.entity.Buku;
import com.model.entity.Denda;
import com.model.entity.Pengguna;
import com.model.entity.Transaksi;
import com.repository.BukuRepository;
import com.repository.DendaRepository;
import com.repository.PenggunaRepository;
import com.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Transaksi")
public class TransaksiController {
    private final PenggunaRepository penggunaRepository;
    private final TransaksiRepository transaksiRepository;
    private final BukuRepository bukuRepository;
    private final DendaRepository dendaRepository;

    @Autowired
    public TransaksiController(BukuRepository bukuRepository, DendaRepository dendaRepository,
                               PenggunaRepository penggunaRepository, TransaksiRepository transaksiRepository) {
        this.penggunaRepository = penggunaRepository;
        this.transaksiRepository = transaksiRepository;
        this.bukuRepository = bukuRepository;
        this.dendaRepository = dendaRepository;
    }


    // convert dto to entity
    public Transaksi convertDtoToEntity (TransaksiDto transaksiDto){
        Transaksi transaksi = new Transaksi();
        transaksi.setKodeTransaksi(transaksiDto.getKode());
        transaksi.setTanggalPinjam(transaksiDto.getTanggalPinjam());
        transaksi.setTanggalKembali(transaksiDto.getTanggalKembali());
        if(penggunaRepository.findById(transaksiDto.getKodePengguna()).isPresent()){
            Pengguna pengguna = penggunaRepository.findById(transaksiDto.getKodePengguna()).get();
            pengguna.setKodePengguna(String.valueOf(pengguna));
        }
        if(bukuRepository.findById(transaksiDto.getKodeBuku()).isPresent()){
            Buku buku = bukuRepository.findById(transaksiDto.getKodeBuku()).get();
            buku.setIdBuku(String.valueOf(buku));
        }
        if (dendaRepository.findById(transaksiDto.getKodeDenda()).isPresent()){
            Denda denda = dendaRepository.findById(transaksiDto.getKodeDenda()).get();
            denda.setKodeDenda(String.valueOf(denda));
        }
        return transaksi;
    }

    // convert to dto
    private TransaksiDto convertEntityToDto(Transaksi transaksi){
        TransaksiDto dto = new TransaksiDto();
        dto.setKode(transaksi.getKodeTransaksi());
        dto.setTanggalPinjam(transaksi.getTanggalPinjam());
        dto.setTanggalKembali(transaksi.getTanggalKembali());
        dto.setKodeDenda(transaksi.getKodeDenda().getKodeDenda());
        return dto;
    }

    //lihat data by code transaksi
    @GetMapping("/{code}")
    public TransaksiDto get(@PathVariable String code){
        if(transaksiRepository.findById(code).isPresent()){
            TransaksiDto transaksiDto = convertEntityToDto(transaksiRepository.findById(code).get());
            return transaksiDto;
        }
        return null;
    }

    @GetMapping("/pengguna/{codePengguna}")
    public List<TransaksiDto> getByPengguna(@PathVariable String codePengguna){
        List<Transaksi> transaksiList = transaksiRepository.findAllByPenggunaKodePengguna(codePengguna);
        List<TransaksiDto> transaksiDtoList = transaksiList.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return transaksiDtoList;
    }

    @PostMapping
        public TransaksiDto insert(@RequestBody TransaksiDto dto){
            Transaksi transaksi = convertDtoToEntity(dto);
            transaksiRepository.save(transaksi);
            return convertEntityToDto(transaksi);
    }
}
