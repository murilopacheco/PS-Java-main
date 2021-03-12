package br.com.supera.game.store.order.repository;

import br.com.supera.game.store.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OroderRepositoryJPA extends CrudRepository<Order, Long> {
}
