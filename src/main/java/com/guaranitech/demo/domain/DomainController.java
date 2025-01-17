package com.guaranitech.demo.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guaranitech.demo.core.CrudController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Domain", description = "API para CRUD de Domain")
@RestController
@RequestMapping("/api/domain")
public class DomainController extends CrudController<Domain, Integer> {

	public DomainController() {
		super();
	}

}
