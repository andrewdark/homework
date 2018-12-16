package ua.pp.darknsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.dao.PetDao;
import ua.pp.darknsoft.models.Pet;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetDao petDao;

    @Override
    public Pet findById(Long id) {
        return petDao.findById(id);
    }

    @Override
    public List<Pet> findAll() {
        return petDao.findAll();
    }

    @Override
    public Long getCount() {
        return petDao.getCount();
    }

    @Override
    public Pet saveOrUpdate(Pet instance) {
        return petDao.saveOrUpdate(instance.getId(), instance);
    }

    @Override
    public void delete(Long id) {
        petDao.delete(id);
    }

    @Override
    public Boolean isExist(Pet pet) {
        return petDao.isExist(pet);
    }

    @Override
    public List<Pet> findByBreed(String breed) {
        return petDao.findByBreed(breed);
    }
}
