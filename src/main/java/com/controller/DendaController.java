package com.controller;

import com.model.dto.DendaDto;
import com.model.entity.Denda;
import com.model.entity.Pengguna;
import com.model.entity.Transaksi;
import com.repository.DendaRepository;
import com.repository.PenggunaRepository;
import com.repository.TransaksiRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/denda")
public class DendaController {
    private final DendaRepository dendaRepository;
    private final PenggunaRepository penggunaRepository;
    private final TransaksiRepository transaksiRepository;

    public DendaController(DendaRepository dendaRepository, PenggunaRepository penggunaRepository, TransaksiRepository transaksiRepository) {
        this.dendaRepository = dendaRepository;
        this.penggunaRepository = penggunaRepository;
        this.transaksiRepository = transaksiRepository;
    }

    public Denda convertDtoToEntity (DendaDto dendaDto){
        Denda denda = new Denda();
        denda.setKodeDenda(dendaDto.getKodeDenda());
        denda.getBesarDenda();
        if(penggunaRepository.findById(dendaDto.getKodePengguna()).isPresent()){
            Pengguna pengguna = penggunaRepository.findById(dendaDto.getKodePengguna()).get();
            pengguna.setKodePengguna(String.valueOf(pengguna));
        }
        if(transaksiRepository.findById(dendaDto.getKodeTransaksi()).isPresent()){
            Transaksi transaksi = transaksiRepository.findById(dendaDto.getKodeTransaksi()).get();
            transaksi.setKodeTransaksi(String.valueOf(transaksi));
        }
        return denda;
    }
    private DendaDto convertEntityToDto (Denda denda){
        DendaDto dto = new DendaDto();
        dto.setKodeDenda(denda.getKodeDenda());
        dto.setBesarDenda(denda.getBesarDenda());
        dto.setKodePengguna(denda.getKodePengguna().getKodePengguna());
        dto.setKodeTransaksi(denda.getKodeTransaksi().getKodeTransaksi());
        return dto;
    }
}
