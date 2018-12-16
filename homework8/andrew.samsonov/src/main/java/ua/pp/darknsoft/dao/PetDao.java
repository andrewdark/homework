package ua.pp.darknsoft.dao;

import ua.pp.darknsoft.models.Pet;

import java.util.List;

public interface PetDao extends GenericDao<Pet, Long> {
    Boolean isExist(Pet pet);

    List<Pet> findByBreed(String breed);
}
