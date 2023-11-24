package com.islol.hyopgg.naejeon.repository;

import com.islol.hyopgg.naejeon.entity.Naejeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface NaejeonRepository extends JpaRepository<Naejeon, Long> {
}
