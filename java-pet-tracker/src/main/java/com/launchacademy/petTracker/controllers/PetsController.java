package com.launchacademy.petTracker.controllers;

import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {

  private PetRepository petRepo;

  @Autowired
  public PetsController(PetRepository petRepo) {
    this.petRepo = petRepo;
  }

  @GetMapping
  public String getPets(Model model, Pageable pageable) {
    model.addAttribute("pets", petRepo.findAll(pageable));
    return "pets/index";
  }

  @GetMapping("/new")
  public String newPetForm(@ModelAttribute Pet pet) {
    return "pets/new";
  }

  @PostMapping
  public String createPet(@ModelAttribute Pet pet) {
    petRepo.save(pet);
    return "redirect:/pets";
  }
}
