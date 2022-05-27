package com.controller;

import com.helper.DefaultResponse;
import com.model.dto.BukuDto;
import com.model.dto.DendaDto;
import com.model.entity.Buku;
import com.model.entity.Denda;
import com.model.entity.Pengguna;
import com.model.entity.Transaksi;
import com.repository.DendaRepository;
import com.repository.PenggunaRepository;
import com.repository.TransaksiRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        denda.setTelat(dendaDto.getTelat());
        denda.setBesarDenda(dendaDto.getBesarDenda());
        return denda;
    }
    public Denda convertDtoToEntity2 (DendaDto dendaDto){
        Denda denda = new Denda();
        denda.setKodeDenda(dendaDto.getKodeDenda());
        return denda;
    }
    private DendaDto convertEntityToDto (Denda denda){
        DendaDto dto = new DendaDto();
        dto.setKodeDenda(denda.getKodeDenda());
        dto.setTelat(denda.getTelat());
        dto.setBesarDenda(dto.getBesarDenda());
        return dto;
    }
    @PostMapping("/inputdenda")
    public DefaultResponse<DendaDto> savedenda(@RequestBody DendaDto dendaDto){
        Denda denda = convertDtoToEntity(dendaDto);
        DefaultResponse<DendaDto> response = new DefaultResponse<>();

        //cek data
        Optional<Denda> optional = dendaRepository.findById(dendaDto.getKodeDenda());

        if (optional.isPresent()){
            dendaRepository.save(denda);
            response.setMessage("Berhasil update data");
            response.setData(dendaDto);
        } else {
            dendaRepository.save(denda);
            response.setMessage("Berhasil menyimpan");
            response.setData(dendaDto);
        }
        return response;
    }
    @PostMapping("/bayar")
            public DefaultResponse<DendaDto> bayardenda(@RequestBody DendaDto dendaDto){
        Denda denda = convertDtoToEntity(dendaDto);
        DefaultResponse<DendaDto> response = new DefaultResponse<>();

        //cek data
        Optional<Denda> optional = dendaRepository.findById(dendaDto.getKodeDenda());

        if (optional.isPresent()){
            denda.setBesarDenda(denda.getBesarDenda()- dendaDto.getBayar());
            dendaRepository.save(denda);
            if(denda.getBesarDenda()>0){
                response.setMessage("pembayaran kurang sebsar Rp. "+denda.getBesarDenda());
            } else {
                response.setMessage("pembayaran berhasil, kembali Rp. "+(denda.getBesarDenda()*(-1)));
            }

        } else {
            response.setMessage("kode denda tidak ditemukan");
        }
        return response;
    }

}
