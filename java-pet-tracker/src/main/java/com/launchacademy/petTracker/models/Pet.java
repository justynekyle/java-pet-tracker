package com.launchacademy.petTracker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pets")
@NoArgsConstructor
@Getter
@Setter
public class Pet {
  @Id
  @SequenceGenerator(name="pet_generator", sequenceName = "pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pet_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="species", nullable=false)
  private String species;

  @Column(name="breed", nullable=false)
  private String breed;

  @Column(name="age", nullable=false)
  private Integer age;

  @Column(name="neutered", nullable=false)
  private Boolean neutered;
}
