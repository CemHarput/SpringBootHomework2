package com.study.homework2.dao;

import com.study.homework2.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Long > {


}
