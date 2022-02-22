package com.restapi.springbootdockercompose.repository;

import com.restapi.springbootdockercompose.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Projetrepository extends JpaRepository<Projet, Integer> {
}
