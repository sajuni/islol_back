package com.islol.hyopgg.league.repository;

import com.islol.hyopgg.league.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {
}
