package com.controller;

import com.helpers.DefaultResponse;
import com.model.dto.PenggunaDto;
import com.model.entity.*;
import com.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pengguna")
public class PenggunaController {
    final
    EbookRepository repoEbook;
    final
    PenggunaRepository repoPengguna;
    final
    AksesRepository repoAkses;
    final BukuRepository repoBuku;
    final TransaksiRepository transaksiRepository;

    public PenggunaController(EbookRepository repoEbook, PenggunaRepository repoPengguna, AksesRepository repoAkses, BukuRepository repoBuku, TransaksiRepository transaksiRepository) {
        this.repoEbook = repoEbook;
        this.repoPengguna = repoPengguna;
        this.repoAkses = repoAkses;
        this.repoBuku = repoBuku;
        this.transaksiRepository = transaksiRepository;
    }

    @GetMapping
    public List<PenggunaDto> getPengguna(){
        List<Pengguna> listPengguna = repoPengguna.findAll();
        return listPengguna.stream().map(this::convertToDto1).collect(Collectors.toList());
    }
    @GetMapping("/aksesnama/{namaLengkap}")
    public DefaultResponse<PenggunaDto> getByfullName(@PathVariable String namaLengkap){
        DefaultResponse<PenggunaDto> respon = new DefaultResponse<>();
        Optional<Pengguna> nama_lengkap = repoPengguna.findPenggunaByNamaLengkap(namaLengkap);
        if(nama_lengkap.isPresent()){
            respon.setMessage("Nama Ditemukan");
            respon.setData(convertToDto1(nama_lengkap.get()));
        } else{
            respon.setMessage("Nama Tidak Ditemukan");
        }
        return respon;
    }
    @GetMapping("/dataperan/{peranPengguna}")
    public List<PenggunaDto> getByPeran(@PathVariable String peranPengguna){
        List<Pengguna> listPengguna = repoPengguna.findAllByPeranPengguna(peranPengguna);
        return listPengguna.stream().map(this::convertToDto1).collect(Collectors.toList());
    }
    @PostMapping("/daftar")
    public DefaultResponse<PenggunaDto> insert(@RequestBody PenggunaDto dto){
        Pengguna entity = convertToEntity1(dto);
        DefaultResponse<PenggunaDto> masukan = new DefaultResponse<>();

        Optional<Pengguna> namaDepan = repoPengguna.findPenggunaByNamaDepan(dto.getFirstName());
        Optional<Pengguna> namaBelakang = repoPengguna.findPenggunaByNamaBelakang(dto.getLastName());
        if(namaDepan.isPresent() && namaBelakang.isPresent()){
            masukan.setMessage("Nama sudah tersedia");
        } else{
            repoPengguna.save(entity);
            masukan.setMessage("Berhasil menyimpan");
            masukan.setData(dto);
        }
        return masukan;
    }
    @PostMapping("/edit/{kodePengguna}")
    public DefaultResponse<PenggunaDto> edit(@RequestBody PenggunaDto dto, @PathVariable String kodePengguna){
        Pengguna entity = convertToEntity2(dto);
        DefaultResponse<PenggunaDto> masukan = new DefaultResponse<>();

        Optional<Pengguna> kode_pengguna = repoPengguna.findPenggunaByKode(kodePengguna);
        if(kode_pengguna.isPresent()){
            repoPengguna.save(entity);
            masukan.setMessage("Data diri berhasil diperbaharui");
            masukan.setData(dto);
        } else{
            masukan.setMessage("Nama tidak ditemukan");
        }
        return masukan;
    }
    @PostMapping("/akses_ebook")
    public Akses saveDateAccess(@RequestBody Akses akses){
        akses.setTanggalAkses(new Date());
        repoAkses.save(akses);
        return akses;
    }
    @GetMapping("/dataakses")
    List<Akses> getDataAkses(){ return repoAkses.findAll(); }
    @PutMapping("/{id}/kodepengguna/{kodePengguna}/ebook/{idEbook}")
    Akses dataAksesPenggunaEbook(
            @PathVariable Long id,
            @PathVariable String idEbook,
            @PathVariable String kodePengguna
    ){
        Akses akses = repoAkses.findById(id).get();
        Pengguna pengguna = repoPengguna.findPenggunaByKode(kodePengguna).get();
        Ebook ebook = repoEbook.findEbookById(idEbook).get();
        akses.setIdEbook(ebook);
        akses.setKodePengguna(pengguna);
        return repoAkses.save(akses);
    }
    @PutMapping("/{id}/kodepengguna/{kodePengguna}/Buku/{idBuku}")
    Akses dataAksesPenggunaBuku(
            @PathVariable Long id,
            @PathVariable String idBuku,
            @PathVariable String kodePengguna
    ){
        Akses akses = repoAkses.findById(id).get();
        Pengguna pengguna = repoPengguna.findPenggunaByKode(kodePengguna).get();
        Buku buku = repoBuku.findBukuById(idBuku).get();
        akses.setIdBuku(buku);
        akses.setKodePengguna(pengguna);
        return repoAkses.save(akses);
    }

    private PenggunaDto convertToDto1(Pengguna entity){
        PenggunaDto dto = new PenggunaDto();
        dto.setKode(entity.getKodePengguna());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPeran(entity.getPeranPengguna());
        dto.setJenisKelamin(entity.getJenisKelamin());
        dto.setAlamat(entity.getAlamat());
        dto.setKontak(entity.getKontak());
        dto.setTanggalDaftar(entity.getTanggalDaftar());
        return dto;
    }
    private Pengguna convertToEntity1(PenggunaDto dto){
        Pengguna entity = new Pengguna();
        entity.setKodePengguna(dto.getKode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPeranPengguna(dto.getPeran());
        entity.setJenisKelamin(dto.getJenisKelamin());
        entity.setAlamat(dto.getAlamat());
        entity.setKontak(dto.getKontak());
        entity.setTanggalDaftar(new Date());
        return entity;
    }
    private Pengguna convertToEntity2(PenggunaDto dto){
        Pengguna entity = new Pengguna();
        entity.setKodePengguna(dto.getKode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPeranPengguna(dto.getPeran());
        entity.setJenisKelamin(dto.getJenisKelamin());
        entity.setAlamat(dto.getAlamat());
        entity.setKontak(dto.getKontak());
        entity.setTanggalEdit(new Date());
        return entity;
    }
}
