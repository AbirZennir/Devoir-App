package com.devoir.devoir.repository;

import com.devoir.devoir.model.Devoir;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DevoirRepository extends JpaRepository<Devoir, Long> {
    List<Devoir> findByCreatedBy_Id(Long userId);
}