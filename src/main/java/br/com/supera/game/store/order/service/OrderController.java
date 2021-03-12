package br.com.supera.game.store.order.service;

import br.com.supera.game.store.order.business.OrderBusiness;
import br.com.supera.game.store.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/order")
public class OrderController {


    @Autowired
    OrderBusiness orderBusiness = new OrderBusiness();

    @GetMapping(path="/all", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Order> getAllOrders() {
        return orderBusiness.getAllOrders();
    }

    @PostMapping(path = "/add")
    public void createNewOrder( @RequestBody Order order ){
        orderBusiness.createNewOrder(order);
    }

    @PutMapping(path = "/edit")
    public void editOrder( @RequestBody Order order ){
        orderBusiness.editOrder(order);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deleteOrderById(@PathVariable(name = "id") long id){
        orderBusiness.deleteOrderById(id);
    }
}
