package com.controller;

import com.model.dto.DefaultResponse;
import com.model.dto.TransaksiDto;
import com.model.entity.Buku;
import com.model.entity.Denda;
import com.model.entity.Pengguna;
import com.model.entity.Transaksi;
import com.repository.BukuRepository;
import com.repository.DendaRepository;
import com.repository.PenggunaRepository;
import com.repository.TransaksiRepository;
import com.service.AuditLogService;
import com.service.TransaksiService;
import com.service.TransaksiServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    private final PenggunaRepository penggunaRepository;
    private final TransaksiRepository transaksiRepository ;
    private final BukuRepository bukuRepository;
    private final DendaRepository dendaRepository;
    private final AuditLogService auditLogSerice;
    @Autowired
    private TransaksiService transaksiService;
    @Autowired
    public TransaksiController(BukuRepository bukuRepository, DendaRepository dendaRepository,
                               PenggunaRepository penggunaRepository, TransaksiRepository transaksiRepository, AuditLogService auditLogSerice) {
        this.penggunaRepository = penggunaRepository;
        this.transaksiRepository = transaksiRepository;
        this.bukuRepository = bukuRepository;
        this.dendaRepository = dendaRepository;
        this.auditLogSerice = auditLogSerice;
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
    //keseluruhan transaksi

    @GetMapping("/list")
    public List<TransaksiDto> getListTrans(){
        List<TransaksiDto> list = new ArrayList<>();
        for(Transaksi t : transaksiRepository.findAll()){
            list.add(convertEntityToDto(t));
        }
        return list;
    }

    @PostMapping("/pinjam")
    public DefaultResponse<TransaksiDto> savepinjam(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi = convertDtoToEntity(transaksiDto);
        DefaultResponse<TransaksiDto> response = new DefaultResponse<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        //cek


        Optional<Pengguna> optional = penggunaRepository.findById(transaksiDto.getKodePengguna());
        if(optional.isPresent()){
            auditLogSerice.writeLog("pengguna ditemukan");
            Optional<Buku> optionalBuku = bukuRepository.findById(transaksiDto.getKodeBuku());
            if(optionalBuku.isPresent()){
                auditLogSerice.writeLog("buku ditemukan");
                transaksiRepository.save(transaksi);
                auditLogSerice.writeLog("peminjaman berhasil");
                response.setData(transaksiDto);

            } else {
                auditLogSerice.writeLog("buku tidak ditemukan");
            }
        } else {
            auditLogSerice.writeLog("pengguna tidak ditemukan");
        }
        return response;
    }

    @PostMapping("/kembali")
    public DefaultResponse<TransaksiDto> savekembali(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi = convertDtoToEntity(transaksiDto);
        DefaultResponse<TransaksiDto> response = new DefaultResponse<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        //cek
        Optional<Transaksi> optional = transaksiRepository.findById(transaksiDto.getKode());
        if(optional.isPresent()){
            auditLogSerice.writeLog("transaksi ditemukan");
            transaksiRepository.save(transaksi);
            long sel = transaksiService.selisihHari(transaksi);
            if(sel > 3){
                auditLogSerice.writeLog("Anda telat mengembalikan selama"+sel);
                transaksiService.insertDataTransaksi(transaksi);
            }

            response.setData(transaksiDto);
        } else {
            auditLogSerice.writeLog("transaksi tidak ditemukan");
        }
        return response;
    }

    @PostMapping
        public TransaksiDto insert(@RequestBody TransaksiDto dto){
            Transaksi transaksi = convertDtoToEntity(dto);
            transaksiRepository.save(transaksi);
            return convertEntityToDto(transaksi);
    }
}
