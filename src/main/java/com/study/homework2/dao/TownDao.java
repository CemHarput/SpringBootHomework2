package com.study.homework2.dao;


import com.study.homework2.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownDao extends JpaRepository<Town,Long > {
}
