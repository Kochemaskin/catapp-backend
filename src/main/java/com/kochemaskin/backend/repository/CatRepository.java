package com.kochemaskin.backend.repository;

import com.kochemaskin.backend.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
