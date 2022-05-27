package com.service;

import com.controller.BukuController;
import com.model.dto.BukuDto;
import com.model.entity.Buku;
import com.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;
    private BukuController bukuController;

    private BukuDto bukuDto;
//    public BukuService(BukuRepository bukuRepository, BukuController bukuController, BukuDto bukuDto) { this.bukuRepository = bukuRepository;
//        this.bukuController = bukuController;
////        this.buku = buku;
//        this.bukuDto = bukuDto;
//    }

    public int arsipStatus(String idBuku) { return bukuRepository.arsipBuku(idBuku);}
    public int adaStatus(String idBuku) {return bukuRepository.adaBuku(idBuku);}

    public Buku bukuKembali (String idBuku){
        Buku buku = bukuRepository.findByIdBuku(idBuku);
        if(buku==null){
        }
        buku.setStokBuku(buku.getStokBuku()+1);
        return bukuRepository.save(buku);
    }
    public Buku bukuPinjam (String idBuku){
        Buku buku = bukuRepository.findByIdBuku(idBuku);
        if(buku==null){
        }
        buku.setStokBuku(buku.getStokBuku()-1);
        return bukuRepository.save(buku);
        }

    }

//    public Buku updateStok(Buku buku) {
//        Buku entity = bukuRepository.save(buku);
//        entity.setStokBuku();
//    }


