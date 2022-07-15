package com.study.homework2.dao;

import com.study.homework2.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetDao extends JpaRepository<Street,Long> {

   }
