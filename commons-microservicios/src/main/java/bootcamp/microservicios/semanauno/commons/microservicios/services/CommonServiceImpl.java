package bootcamp.microservicios.semanauno.commons.microservicios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CommonServiceImpl<E, R extends ReactiveMongoRepository<E, Long>> implements CommonService<E> {

	@Autowired
	protected R repository;

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<E> findAll() {
		return (Iterable<E>) repository.findAll();
	}

	@Override
	public Optional<E> findById(Long Id) {

		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E save(E entity) {
		return (E) repository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public Flux<E> findAlls() {

		return repository.findAll();
	}

	@Override
	public Mono<E> findByIds(Long id) {

		return repository.findById(id);
	}

	@Override
	public Mono<E> saves(E entity) {

		return repository.save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Mono<E> delete(E entity) {

		return (Mono<E>) repository.delete(entity);
	}

}
