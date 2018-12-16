package ua.pp.darknsoft.dao;

import org.springframework.stereotype.Repository;
import ua.pp.darknsoft.models.Pet;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetDaoImpl extends GenericDaoImpl<Pet, Long> implements PetDao {
    public PetDaoImpl() {
        super(Pet.class);
    }

    public Boolean isExist(Pet pet){
        return super.findAll().contains(pet);
    }

    @Override
    public List<Pet> findByBreed(String breed) {
        List<Pet> petList = super.findAll();
        List<Pet> filteredPet = new ArrayList<>();
        for (Pet pet : petList) {
            if (pet.getBreed().equals(breed)) filteredPet.add(pet);
        }
        return filteredPet;
    }
}
