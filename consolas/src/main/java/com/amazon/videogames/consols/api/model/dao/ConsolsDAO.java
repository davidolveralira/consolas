package com.amazon.videogames.consols.api.model.dao;

import com.amazon.videogames.consols.api.model.entity.Consols;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsolsDAO extends JpaRepository<Consols, Integer> {
}
