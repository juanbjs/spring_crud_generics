package com.guaranitech.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guaranitech.demo.controller.base.BaseController;
import com.guaranitech.demo.model.Domain;
import com.guaranitech.demo.service.DomainService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Domain", description = "API para CRUD de Domain")
@RestController
@RequestMapping("/api/domain")
public class DomainController extends BaseController<Domain, Integer, DomainService> {

	public DomainController(DomainService service) {
		super(service);
	}

}
