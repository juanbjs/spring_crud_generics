package com.guaranitech.demo.core;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.guaranitech.demo.exception.BadRequestException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.PostConstruct;

@Component
public class CrudController<T, ID> {

	private Logger log = null;
	private String entityName = "";

	@Autowired
	private CrudService<T, ID> service;

	@PostConstruct
	public void init() {
		log = LoggerFactory.getLogger(this.getClass());
		entityName = this.getClass().getName().toUpperCase();
	}

	@Operation(summary = "Create a new record")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Record created successfully", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "500", description = "Server Error", content = @Content) })
	@PostMapping
	public ResponseEntity<T> create(@RequestBody T object) throws URISyntaxException {
		log.debug("REST requet to save: {}", object);
		if (object == null) {
			throw new BadRequestException("A new record cannot be created");
		}
		T result = service.save(object);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@Operation(summary = "Update a record")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Record updated successfully", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "500", description = "Server Error", content = @Content) })
	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable(required = false) final ID id, @RequestBody T object)
			throws URISyntaxException {

		log.debug("REST request to update: {}, {}", id, object);

		if (object == null) {
			throw new BadRequestException("Invalid id " + entityName + " objectNull");
		}

		if (!service.existsById(id)) {
			throw new BadRequestException("Entity not found " + entityName + " idNotFound");
		}

		T result = service.save(object);

		return ResponseEntity.ok().body(result);
	}

	@Operation(summary = "Get all records")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return all records", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Server Error", content = @Content) })
	@GetMapping
	public List<T> getAll() {
		log.debug("REST request to get all");
		return service.findAll();
	}

	@Operation(summary = "Get a record by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return a record by id", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Server Error", content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<T> getById(@PathVariable ID id) {
		log.debug("REST request to get by id: {}", id);
		Optional<T> object = service.findById(id);

		if (object.isPresent())
			return ResponseEntity.ok(object.get());

		return ResponseEntity.notFound().build();

	}

	@Operation(summary = "Delete a record by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Record deleted successfully", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Server Error", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDomain(@PathVariable ID id) {
		log.debug("REST request to delete: {}", id);
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public Logger getLogger() {
		return log;
	}

}
