package com.study.homework2.service.entityservice;

import com.study.homework2.dao.AddressDao;
import com.study.homework2.entity.Address;
import com.study.homework2.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressEntityService extends BaseEntityService<Address, AddressDao> {


    public AddressEntityService(AddressDao dao) {
        super(dao);
    }

    public Optional<Address> findById(Long id){ return getDao().findById(id);}
}
