package com.service;

import com.model.dto.TransaksiDto;
import com.model.entity.Transaksi;

import java.util.Date;

public interface TransaksiService {
    Transaksi insertDataTransaksi(Transaksi transaksi);
    long selisihHari(Transaksi transaksi, String kodeTransaksi);

    long besarDenda(long telat);
}
