package com.controller;

import com.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.model.dto.BukuDto;
import com.model.dto.DefaultResponse;
import com.model.entity.Buku;
import com.model.entity.Rak;
import com.repository.BukuRepository;
import com.repository.RakRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class BukuController {
    private final BukuRepository bukuRepository;
    private final RakRepository rakRepository;
//
    @Autowired
    private BukuService bukuService;

    @Autowired
    public BukuController(BukuRepository bukuRepository, RakRepository rakRepository){
        this.bukuRepository = bukuRepository;
        this.rakRepository = rakRepository;
    }

    //melihat list seluruh buku
    @GetMapping("/listbuku")
    public List<BukuDto> getListBuku(){
        List<BukuDto> list = new ArrayList<>();
        for(Buku b : bukuRepository.findAll()){
            list.add(convertEntitytoDto(b));
        }
        return list;
    }

    //menambahkan buku
    //jika id buku sama, maka update
    @PostMapping("/inputbuku")
    public DefaultResponse<BukuDto> savebuku(@RequestBody BukuDto bukuDto){
        Buku buku = convertDtotoEntity(bukuDto);
        DefaultResponse<BukuDto> response = new DefaultResponse<>();

        //cek data
        Optional<Buku> optional = bukuRepository.findById(bukuDto.getIdBuku());

        if (optional.isPresent()){
            bukuRepository.save(buku);
            response.setMessage("Berhasil update data");
            response.setData(bukuDto);
        } else {
            bukuRepository.save(buku);
            response.setMessage("Berhasil menyimpan");
            response.setData(bukuDto);
        }
        return response;
    }

//    update status (ada/tidak ada)
    @PutMapping("/archive/{idBuku}")
    public DefaultResponse<BukuDto> updateArsip (@PathVariable String idBuku){
        DefaultResponse<BukuDto> response = new DefaultResponse<>();
        Optional<Buku> optional = bukuRepository.findById(idBuku);

        if(optional.isPresent()){
            bukuService.arsipStatus(idBuku);
//            Optional<Buku> optional2 = bukuRepository.findById(idBuku);
            response.setMessage("buku telah diarsipkan");
//            response.setData(convertEntitytoDto(optional2.get()));
        } else {
            response.setMessage("id buku salah");
        }
        return response;
    }

    @PutMapping("/available/{idBuku}")
    public DefaultResponse<BukuDto> updateAvailable (@PathVariable String idBuku){
        DefaultResponse<BukuDto> response = new DefaultResponse<>();
        Optional<Buku> optional = bukuRepository.findById(idBuku);

        if(optional.isPresent()){
            bukuService.adaStatus(idBuku);
            response.setMessage("buku telah tersedia");
//            Optional<Buku> optional2 = bukuRepository.findById(idBuku);
//            response.setData(convertEntitytoDto(optional2.get()));
        } else {
            response.setMessage("id buku salah");
        }
        return response;
    }

    //mengambil data buku berdasarkan nama
    @GetMapping("/getbyname/{name}")
    public DefaultResponse<BukuDto> getByName(@PathVariable String name) {
        DefaultResponse<BukuDto> response = new DefaultResponse<>();
        Optional<Buku> optional = bukuRepository.findBukuByName(name);
        if(optional.isPresent()){
            response.setMessage("Buku Ditemukan");
            response.setData(convertEntitytoDto(optional.get()));
        } else {
            response.setMessage("Buku Tidak Ditemukan");
        }
        return response;
    }

    //mengambil data buku berdasarkan kategori
    @GetMapping("/getbykategori/{kategori}")
    public List<BukuDto> getListbyKategori(@PathVariable String kategori) {
        List<BukuDto> list = new ArrayList<>();
        for(Buku b: bukuRepository.findAllByNamaKategori(kategori)){
            list.add(convertEntitytoDto(b));
        }
        return list;
    }

    //convert Dto ke entity
    public Buku convertDtotoEntity(BukuDto dto) {
        Buku buku = new Buku();
        buku.setIdBuku(dto.getIdBuku());
        buku.setJudulBuku(dto.getJudulBuku());
        buku.setPenulisBuku(dto.getPenulisBuku());
        buku.setPenerbitBuku(dto.getPenerbitBuku());
        buku.setTahunTerbit(dto.getTahunTerbit());
        buku.setNamaKategori(dto.getNamaKategori());
        buku.setJumlahBuku(dto.getJumlahBuku());
        buku.setStokBuku(dto.getStokBuku());
        buku.setStatus(dto.getStatus());

        if(rakRepository.findById(dto.getIdRak()).isPresent()){
            Rak rak = rakRepository.findById(dto.getIdRak()).get();
            buku.setRak(rak);
        }
        return buku;
    }

    //convert Entity to Dto
    public BukuDto convertEntitytoDto(Buku entity) {
        BukuDto dto = new BukuDto();
        dto.setIdBuku(entity.getIdBuku());
        dto.setJudulBuku(entity.getJudulBuku());
        dto.setPenulisBuku(entity.getPenulisBuku());
        dto.setPenerbitBuku(entity.getPenerbitBuku());
        dto.setTahunTerbit(entity.getTahunTerbit());
        dto.setNamaKategori(entity.getNamaKategori());
        dto.setJumlahBuku(entity.getJumlahBuku());
        dto.setStokBuku(entity.getStokBuku());
        dto.setIdRak(entity.getRak().getIdRak());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
