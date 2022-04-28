package com.controller;

import com.model.dto.PenggunaDto;
import com.model.entity.Pengguna;
import com.repository.PenggunaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pengguna")
public class PenggunaController {

    private final PenggunaRepository penggunaRepository;
    public PenggunaController(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    @GetMapping
    public List<PenggunaDto> getPengguna(){
        List<Pengguna> listPengguna = penggunaRepository.findAll();
        return listPengguna.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @PostMapping
    public PenggunaDto insert(@RequestBody PenggunaDto dto){
        Pengguna pengguna = convertToEntity(dto);
        penggunaRepository.save((pengguna));
        return dto;
    }
    private PenggunaDto convertToDto(Pengguna pengguna){
        PenggunaDto penggunaDto = new PenggunaDto();
        penggunaDto.setKode(pengguna.getKodePengguna());
        penggunaDto.setFirstName(pengguna.getFirstName());
        penggunaDto.setLastName(pengguna.getLastName());
        penggunaDto.setPeran(pengguna.getPeranPengguna());
        penggunaDto.setAlamat(pengguna.getAlamat());
        return penggunaDto;
    }
    private Pengguna convertToEntity(PenggunaDto dto){
        Pengguna pengguna = new Pengguna();
        pengguna.setKodePengguna(dto.getKode());
        pengguna.setFirstName(dto.getFirstName());
        pengguna.setLastName(dto.getLastName());
        pengguna.setPeranPengguna(dto.getPeran());
        pengguna.setAlamat(dto.getAlamat());
        return pengguna;
    }
}
