package br.com.supera.game.store.order.business;

import br.com.supera.game.store.order.domain.Order;
import br.com.supera.game.store.order.domain.StatusOrder;
import br.com.supera.game.store.order.repository.OrderProductRepository;
import br.com.supera.game.store.order.repository.OroderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderBusiness {

    @Autowired
    private OroderRepositoryJPA oroderRepositoryJPA;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Bean
    public Iterable<Order> getAllOrders(){
        Iterable<Order> orders = oroderRepositoryJPA.findAll();
        return orders;
    }

    public void createNewOrder(Order order){
        if(!order.getOrderProducts().isEmpty() || (order.getOrderProducts() != null)){

            order.setStatus(StatusOrder.AGUARDANDO.getDescription());
            order.setId(null);

            order.getOrderProducts().forEach(orderProduct -> {
                order.setSubtotal(order.getSubtotal().add((orderProduct.getProduct().getPrice().
                        multiply(BigDecimal.valueOf(orderProduct.getQuantity())))));
                order.setShipping(order.getShipping().add(BigDecimal.valueOf(10.00)));
            });
            if (order.getSubtotal().compareTo(BigDecimal.valueOf(250.00)) > 0 ) {
                order.setTotal(order.getSubtotal());
            }else {
                order.setTotal(order.getSubtotal().add(order.getShipping()));
            }


            oroderRepositoryJPA.save(order);
            orderProductRepository.saveAll(order.getOrderProducts());
        }
    }

    public void editOrder( Order order ){
        if(!order.getOrderProducts().isEmpty() || (order.getOrderProducts() != null)){

            order.setStatus(StatusOrder.AGUARDANDO.getDescription());

            order.getOrderProducts().forEach(orderProduct -> {
                order.setSubtotal(order.getSubtotal().add((orderProduct.getProduct().getPrice().
                        multiply(BigDecimal.valueOf(orderProduct.getQuantity())))));
                order.setShipping(order.getShipping().add(BigDecimal.valueOf(10.00)));
            });
            if (order.getSubtotal().compareTo(BigDecimal.valueOf(250.00)) > 0 ) {
                order.setTotal(order.getSubtotal());
            }else {
                order.setTotal(order.getSubtotal().add(order.getShipping()));
            }


            oroderRepositoryJPA.save(order);
            orderProductRepository.saveAll(order.getOrderProducts());
        }
    }

    public void deleteOrderById( long id){
        oroderRepositoryJPA.deleteById(id);
    }
}
