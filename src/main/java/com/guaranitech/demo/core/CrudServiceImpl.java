package com.guaranitech.demo.core;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JpaRepository<T, ID> repository;

	@Override
	public Optional<T> findById(ID id) {
		Optional<T> result = repository.findById(id);
		log.debug("Call method findById and return this values {}", result);
		return result;
	}

	@Override
	public boolean existsById(ID id) {
		boolean result = repository.existsById(id);
		log.debug("Call method findAll and existsById this values {}", result);
		return result;
	}

	@Override
	public List<T> findAll() {
		List<T> result = repository.findAll();
		log.debug("Call method findAll and return {} rows", result.size());
		return result;
	}

	@Override
	public List<T> findAllById(Iterable<ID> ids) {
		List<T> result = repository.findAllById(ids);
		log.debug("Call method findAll and findAllById {} rows", result.size());
		return result;
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<T> update(Iterable<T> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<T> save(Iterable<T> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends ID> ids) {
		repository.deleteAllById(ids);
	}

	public Logger getLog() {
		return log;
	}
}
