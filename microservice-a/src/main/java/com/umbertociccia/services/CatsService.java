package com.umbertociccia.services;

import java.util.List;
import java.util.Optional;

import com.umbertociccia.models.Cats;
import com.umbertociccia.repositories.CatsRepository;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CatsService {

    @Inject
    private CatsRepository bitchesRepository;

    public Optional<Cats> getCat(Long id) {
        return bitchesRepository.findById(id).or(() -> Optional.empty());
    }

    public Cats addCat(Cats cats) {
        return bitchesRepository.save(cats);
    }

    public Cats updateCat(Long id, Cats cats) {
        Cats cat = bitchesRepository.findById(id).get();
        cat.setName(cats.getName());
        return bitchesRepository.save(cat);
    }

    public boolean deleteCat(Long id) {
        return bitchesRepository.findById(id).map(cat -> {
            bitchesRepository.delete(cat);
            return true;
        }).orElse(false);
    }

    public List<Cats> getCats() {
       return (List<Cats>) bitchesRepository.findAll();
    }
}
