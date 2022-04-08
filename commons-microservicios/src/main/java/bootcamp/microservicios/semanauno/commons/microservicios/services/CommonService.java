package bootcamp.microservicios.semanauno.commons.microservicios.services;

import java.util.Optional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommonService<E> {

	public Iterable<E> findAll();

	public Optional<E> findById(Long Id);

	public E save(E entity);

	public void deleteById(Long id);

	public Flux<E> findAlls();

	public Mono<E> findByIds(Long id);

	public Mono<E> saves(E entity);

	public Mono<E> delete(E entity);

}
