package com.repository;

import com.model.entity.Rak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RakRepository extends JpaRepository<Rak, String> {
}
