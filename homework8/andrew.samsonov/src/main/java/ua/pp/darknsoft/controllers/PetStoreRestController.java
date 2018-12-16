package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.models.Pet;
import ua.pp.darknsoft.services.PetService;

import java.util.List;

@RestController
public class PetStoreRestController {
    @Autowired
    PetService petService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String index() {
        return "HOMEWORK#8";
    }

    @GetMapping(value = "/pets/{id}")
    public ResponseEntity<Pet> getSinglePet(@PathVariable Long id) {
        Pet pet = petService.findById(id);
        if (pet == null) {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pet>(pet, HttpStatus.OK);
    }

    @GetMapping(value = "/pets")
    public ResponseEntity<List<Pet>> getAllPet() {

        return new ResponseEntity<List<Pet>>(petService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/pets/{breed}/breed")
    public ResponseEntity<List<Pet>> getPetsByBreed(@PathVariable String breed) {
        return new ResponseEntity<List<Pet>>(petService.findByBreed(breed), HttpStatus.OK);
    }

    @PostMapping(value = "/pets")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        if (petService.isExist(pet)) {
            System.out.println("CONFLICT");
            return new ResponseEntity<Pet>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(petService.saveOrUpdate(pet), HttpStatus.CREATED);
    }

    @PutMapping(value = "/pets/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        Pet curPet = petService.findById(id);
        if (curPet == null) {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
        curPet.setName(pet.getName());
        curPet.setBreed(pet.getBreed());
        return new ResponseEntity<Pet>(petService.saveOrUpdate(curPet), HttpStatus.OK);
    }

    @DeleteMapping(value = "/pets/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
