package com.restapi.springbootdockercompose.repository;

import com.restapi.springbootdockercompose.entity.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tachesrepository extends JpaRepository<Taches,Integer> {

}
