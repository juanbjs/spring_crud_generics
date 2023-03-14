package com.guaranitech.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guaranitech.demo.controller.base.BaseController;
import com.guaranitech.demo.model.Domain;
import com.guaranitech.demo.service.DomainService;

@RestController
@RequestMapping("/api/domain")
public class DomainController extends BaseController<Domain, Integer, DomainService> {

}
