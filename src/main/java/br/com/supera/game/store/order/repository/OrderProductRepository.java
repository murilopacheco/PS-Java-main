package br.com.supera.game.store.order.repository;

import br.com.supera.game.store.order.domain.OrderProduct;
import br.com.supera.game.store.order.domain.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {


}
