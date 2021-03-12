package br.com.supera.game.store.product.repository;

import br.com.supera.game.store.product.domain.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepositoryJPA extends CrudRepository<Product, Long> {

  Iterable<Product> findAll(Sort name);

}
