package com.service;

import com.controller.DendaController;
import com.model.dto.DendaDto;
import com.model.entity.Denda;
import com.model.entity.Transaksi;
import com.repository.DendaRepository;
import com.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.transaction.Transactional;

@Service
@Transactional
public class TransaksiServicelmpl implements TransaksiService{
    @Autowired
    private TransaksiRepository transaksiRepository;
    private DendaRepository dendaRepository;
    private DendaDto dendaDto;
    private DendaController dendaController;
    @Override
    public Transaksi insertDataTransaksi(Transaksi transaksi) {
        Denda denda = dendaController.convertDtoToEntity(dendaDto);
        Transaksi entity = transaksiRepository.save(transaksi);
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date pinjam = entity.getTanggalPinjam();
        Date kembali = entity.getTanggalKembali();
        long diff = kembali.getTime()-pinjam.getTime();
        long diffDays = diff/(24*60*60*1000);
        long besarDenda = 3000*diffDays;
        denda.setBesarDenda(besarDenda);
        return transaksiRepository.save(entity);
    }

    public long selisihHari(Transaksi transaksi){
        Transaksi entity = transaksiRepository.save(transaksi);
        Date pinjam = entity.getTanggalPinjam();
        Date kembali = entity.getTanggalKembali();
        long diff = kembali.getTime()- pinjam.getTime();
        long diffDays = diff-3/(24*60*60*1000);
        return diffDays;
    }


}
