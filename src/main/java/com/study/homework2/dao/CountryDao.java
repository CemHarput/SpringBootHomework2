package com.study.homework2.dao;

import com.study.homework2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country,Long> {
}
