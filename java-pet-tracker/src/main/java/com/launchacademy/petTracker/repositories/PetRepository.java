package com.launchacademy.petTracker.repositories;

import com.launchacademy.petTracker.models.Pet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {

}
