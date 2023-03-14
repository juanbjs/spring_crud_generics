package com.guaranitech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guaranitech.demo.model.Domain;

public interface DomainRepository extends JpaRepository<Domain, Integer> {

}
