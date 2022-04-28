package com.repository;

import com.model.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface EbookRepository extends JpaRepository<Ebook, String> {
    @Query(value = "select e from Ebook e where e.judulEbook = :ebook", nativeQuery = false)
    public Optional<Ebook> findEbookByName(@PathParam("ebook") String ebook);
}
