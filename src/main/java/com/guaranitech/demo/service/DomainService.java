package com.guaranitech.demo.service;

import com.guaranitech.demo.service.base.*;

import org.springframework.stereotype.Component;

import com.guaranitech.demo.model.Domain;
import com.guaranitech.demo.repository.DomainRepository;

@Component
public class DomainService extends BaseService<Domain, Integer, DomainRepository> {

}
