package com.launchacademy.petTracker.controllers;

import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.repositories.PetRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsRestController {

  private PetRepository petRepo;

  @Autowired
  public PetsRestController(PetRepository petRepo) {
    this.petRepo = petRepo;
  }

  @GetMapping
  public Page<Pet> getPets(Pageable pageable) {
    return petRepo.findAll(pageable);
  }

  @NoArgsConstructor
  private class UrlNotFoundException extends RuntimeException{};

  @ControllerAdvice
  private class UrlNotFoundAdvice{
    @ResponseBody
    @ExceptionHandler(UrlNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(UrlNotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("/{id}")
  public Pet getPet(@PathVariable Integer id){
    return petRepo.findById(id).orElseThrow(() -> new UrlNotFoundException());
  }
}
