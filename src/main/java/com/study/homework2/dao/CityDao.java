package com.study.homework2.dao;

import com.study.homework2.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Long> {
}
