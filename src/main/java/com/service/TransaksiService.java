package com.service;

import com.model.entity.Transaksi;

public interface TransaksiService {
    Transaksi insertDataTransaksi(Transaksi transaksi);
    long selisihHari(Transaksi transaksi);
}
