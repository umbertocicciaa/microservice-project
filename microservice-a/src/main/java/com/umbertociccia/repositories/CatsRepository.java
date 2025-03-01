package com.umbertociccia.repositories;

import org.springframework.data.repository.CrudRepository;

import com.umbertociccia.models.Cats;

public interface CatsRepository extends CrudRepository<Cats, Long>{
    
}
