package com.repository;

import com.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BukuRepository extends JpaRepository<Buku, String> {

    List<Buku> findAllByRakKodeRak(String kodeRak);
}
