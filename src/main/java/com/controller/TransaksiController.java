package com.controller;

import com.helpers.DefaultResponse;
import com.model.dto.BukuDto;
import com.model.dto.DendaDto;
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
import com.service.BukuService;
import com.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    private BukuService bukuService;
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
        transaksi.setKodeTransaksi(transaksiDto.getKodeTransaksi());
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

    public Transaksi convertDtoToEntity2 (TransaksiDto transaksiDto) {
        Transaksi transaksi = new Transaksi();
        transaksi.setKodeTransaksi(transaksiDto.getKodeTransaksi());
        transaksi.setTanggalPinjam(transaksiDto.getTanggalPinjam());
        transaksi.setTanggalKembali(transaksiDto.getTanggalKembali());
        return transaksi;
    }

    // convert to dto
    private TransaksiDto convertEntityToDto(Transaksi transaksi){
        TransaksiDto dto = new TransaksiDto();
        dto.setKodeTransaksi(transaksi.getKodeTransaksi());
        dto.setTanggalPinjam(transaksi.getTanggalPinjam());
        dto.setTanggalKembali(transaksi.getTanggalKembali());
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
    @GetMapping("/list/pinjam/{tanggalPinjam}")
    public List<TransaksiDto> getListbyJudul(@PathVariable String tanggalPinjam) throws ParseException {
        List<TransaksiDto> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date tanggal = format.parse(tanggalPinjam);
        for(Transaksi t: transaksiRepository.findByTanggalPinjam(tanggal)){
            list.add(convertEntityToDto(t));
        }
        return list;
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
        Transaksi transaksi = convertDtoToEntity2(transaksiDto);
        Buku buku = bukuRepository.findByIdBuku(transaksiDto.getKodeBuku());

        DefaultResponse<TransaksiDto> response = new DefaultResponse<>();
        //cek
        Optional<Pengguna> optional = penggunaRepository.findPenggunaByKode(transaksiDto.getKodePengguna());
        Optional<Buku> optionalBuku = bukuRepository.findBukuById(transaksiDto.getKodeBuku());
        Optional<Transaksi> optionalTrans = transaksiRepository.findById(transaksiDto.getKodeTransaksi());
        if(optionalTrans.isPresent()){
            response.setMessage("transaksi sudah ada, mohon input transaksi baru");
        } else {
            if(optional.isPresent() && optionalBuku.isPresent()){
                if(buku.getStokBuku()>0){
                    transaksiRepository.save(transaksi);
                    buku.setStokBuku(buku.getStokBuku()-1);
                    bukuRepository.save(buku);
//                bukuService.bukuPinjam(transaksiDto.getKodeBuku());
                    response.setMessage("peminjaman berhasil");
                    response.setData(transaksiDto);
                }
            } else {
                response.setMessage("pengguna tidak ditemukan");
            }
        }

        return response;
    }

    @PostMapping("/kembali")
    public DefaultResponse<TransaksiDto> savekembali(@RequestBody TransaksiDto transaksiDto) {
        Transaksi transaksi = convertDtoToEntity2(transaksiDto);
        Buku buku = bukuRepository.findByIdBuku(transaksiDto.getKodeBuku());
        Denda denda = dendaRepository.findByKodeDenda(transaksiDto.getKodeDenda());
        DefaultResponse<TransaksiDto> response = new DefaultResponse<>();
        //cek
        Optional<Transaksi> optional = transaksiRepository.findById(transaksiDto.getKodeTransaksi());
        if (optional.isPresent()) {
            transaksiRepository.save(transaksi);
            response.setData(transaksiDto);
            buku.setStokBuku(buku.getStokBuku()+1);
            bukuRepository.save(buku);
//            bukuService.bukuKembali(transaksiDto.getKodeBuku());
            long sel = transaksiService.selisihHari(transaksi, transaksiDto.getKodeTransaksi());
            if (sel > 3) {
                Long dendat = transaksiService.besarDenda(sel);
                denda.setTelat(sel-3);
                denda.setBesarDenda(dendat);
                dendaRepository.save(denda);
                response.setMessage("Anda telat mengembalikan selama " + (sel-3) +" hari, "+ "besar denda yang harus dibayar = Rp. " + dendat);
            } else {
                response.setMessage("terima kasih telah mengembalikan buku tepat waktu");
            }
        } else {
            response.setMessage("transaksi tidak ditemukan");
        }    return response;
    }
    @PostMapping("/insert")
        public TransaksiDto insert(@RequestBody TransaksiDto dto){
            Transaksi transaksi = convertDtoToEntity2(dto);
            transaksiRepository.save(transaksi);
            return convertEntityToDto(transaksi);
    }

//    @PostMapping("/bayar")
//    public
}
//         response.setData(transaksiDto);

