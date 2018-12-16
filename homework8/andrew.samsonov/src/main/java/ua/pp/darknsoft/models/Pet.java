package ua.pp.darknsoft.models;

import java.util.Objects;

public class Pet {
    private Long id;
    private String name;
    private String breed;

    public Pet() {
    }

    public Pet(Long id, String name, String breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return id.equals(pet.id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed);
    }
}
