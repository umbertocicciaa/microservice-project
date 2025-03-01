package com.umbertociccia.services;

import java.util.List;
import java.util.Optional;

import com.umbertociccia.models.Dogs;
import com.umbertociccia.repositories.DogsRepository;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class DogsService {
    @Inject
    private DogsRepository dogsRepository;

    public List<Dogs> getDogs() {
        return (List<Dogs>) dogsRepository.findAll();
    }

    public Optional<Dogs> getDog(Long id) {
        return dogsRepository.findById(id).or(() -> Optional.empty());
    }

    public Dogs addDog(Dogs dog) {
        return dogsRepository.save(dog);
    }

    public Dogs updateDog(Long id, Dogs dog) {
        Dogs d = dogsRepository.findById(id).get();
        d.setName(dog.getName());
        return dogsRepository.save(d);
    }

    public boolean deleteDog(Long id) {
        return dogsRepository.findById(id).map(dog -> {
            dogsRepository.delete(dog);
            return true;
        }).orElse(false);
    }
    
}
