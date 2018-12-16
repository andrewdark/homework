package ua.pp.darknsoft.services;

import ua.pp.darknsoft.models.Pet;

import java.util.List;

public interface PetService {

    Pet findById(Long id);

    List<Pet> findAll();

    Long getCount();

    Pet saveOrUpdate(Pet instance);

    void delete(Long id);

    Boolean isExist(Pet pet);

    List<Pet> findByBreed(String breed);
}
