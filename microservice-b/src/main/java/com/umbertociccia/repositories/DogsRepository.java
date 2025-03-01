package com.umbertociccia.repositories;

import org.springframework.data.repository.CrudRepository;

import com.umbertociccia.models.Dogs;

public interface DogsRepository extends CrudRepository<Dogs, Long> {
    
}
