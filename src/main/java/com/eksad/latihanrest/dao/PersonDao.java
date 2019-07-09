package com.eksad.latihanrest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eksad.latihanrest.model.Person;

@RepositoryRestResource(path = "persons")
public interface PersonDao extends CrudRepository<Person, Long> {

}
