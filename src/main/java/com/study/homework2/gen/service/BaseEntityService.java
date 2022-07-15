package com.study.homework2.gen.service;

import com.study.homework2.gen.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity,D extends JpaRepository<E,Long>> {

    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E findByIdWithControl(Long id){

        Optional<E> optionalEntity = dao.findById(id);

        E entity;
        if (optionalEntity.isPresent()){
            entity = optionalEntity.get();
        } else {
            throw new NullPointerException("Item cannot found");
        }

        return entity;
    }
    public E save(E entity){


        return dao.save(entity);
    }
    public void delete(E e){
        dao.delete(e);
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }

    public D getDao() {
        return dao;
    }
}
