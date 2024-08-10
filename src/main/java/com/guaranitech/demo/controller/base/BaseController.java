package com.guaranitech.demo.controller.base;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.guaranitech.demo.exception.BadRequestException;
import com.guaranitech.demo.service.base.CrudService;

import jakarta.annotation.PostConstruct;

public class BaseController<T, ID, S extends CrudService<T, ID>> {

    private S service;
    private Logger log = null;
    private String entityName = "";

	public BaseController(S service) {
		this.service = service;
	}
    
    @PostConstruct
    public void init() {
        log = LoggerFactory.getLogger(this.getClass());
        entityName = this.getClass().getName().toUpperCase();
    }

    /**
     * {@code POST} : Create a new entity.
     *
     * @param object the entity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new domain, or with status {@code 400 (Bad Request)} if the
     *         domain has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping
    public ResponseEntity<T> create(@RequestBody T object) throws URISyntaxException {
        log.debug("REST requet to save: {}", object);
        if (object == null) {
            throw new BadRequestException("A new record cannot be created");
        }
        T result = service.save(object);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    /**
     * {@code PUT  /:id} : Updates an existing domain.
     *
     * @param id     the id of the entity to save.
     * @param object the entity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated entity,
     *         or with status {@code 400 (Bad Request)} if the domain is not valid,
     *         or with status {@code 500 (Internal Server Error)} if the domain
     *         couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<T> update(
            @PathVariable(required = false) final ID id,
            @RequestBody T object) throws URISyntaxException {

        log.debug("REST request to update: {}, {}", id, object);

        if (object == null) {
            throw new BadRequestException("Invalid id " + entityName + " objectNull");
        }

        if (!service.existsById(id)) {
            throw new BadRequestException("Entity not found " + entityName + " idNotFound");
        }

        T result = service.save(object);

        return ResponseEntity
                .ok()
                .body(result);
    }

    /**
     * {@code GET} : get all the entities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of entities in body.
     */
    @GetMapping
    public List<T> getAll() {
        log.debug("REST request to get all");
        return service.findAll();
    }

    /**
     * {@code GET  /:id} : get the "id" domain.
     *
     * @param id the id of the domain to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the entity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        log.debug("REST request to get by id: {}", id);
        Optional<T> object = service.findById(id);

        if (object.isPresent())
            return ResponseEntity.ok(object.get());

        return ResponseEntity
                .notFound()
                .build();

    }

    /**
     * {@code DELETE  /:id} : delete the "id" entity.
     *
     * @param id the id of the entity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomain(@PathVariable ID id) {
        log.debug("REST request to delete: {}", id);
        service.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    
	public Logger getLogger() {
        return log;
    }
	
	public S getService() {
        return service;
    }
}
