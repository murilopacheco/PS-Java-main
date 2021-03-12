package br.com.supera.game.store;


import br.com.supera.game.store.order.domain.Order;
import br.com.supera.game.store.order.domain.OrderProduct;
import br.com.supera.game.store.order.domain.StatusOrder;
import br.com.supera.game.store.order.repository.OrderProductRepository;
import br.com.supera.game.store.order.repository.OroderRepositoryJPA;
import br.com.supera.game.store.product.domain.Product;
import br.com.supera.game.store.product.repository.ProductRepositoryJPA;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;


@SpringBootApplication
public class PsJavaMainApplication {

	@Autowired
	private ProductRepositoryJPA repositoryJPA;

	@Autowired
	private OroderRepositoryJPA orderRepositoryJPA;

	@Autowired
	private OrderProductRepository repository;


	public static void main(String[] args) {

		SpringApplication.run(PsJavaMainApplication.class, args);
	}

	//Carga inicial do arquivo .yml para o banco hsqldb em memória via spring repository
	@Bean
	InitializingBean sendDatabase() {
		List<Product> products = new ArrayList<>();
		return () -> {
			Product p = new Product();
			p.setName("Super Mario Odyssey");
			p.setPrice( BigDecimal.valueOf(197.88));
			p.setScore(Short.parseShort("100"));
			p.setImage("super-mario-odyssey.png");

			products.add(p);

			p = new Product();
			p.setName("Call Of Duty Infinite Warfare");
			p.setPrice(BigDecimal.valueOf(49.99));
			p.setScore(Short.parseShort("80"));
			p.setImage("Call Of Duty Infinite Warfare.png");

			products.add(p);

			p = new Product();
			p.setName("The Witcher III Wild Hunt");
			p.setPrice( BigDecimal.valueOf(119.50));
			p.setScore(Short.parseShort("250"));
			p.setImage("The Witcher III Wild Hunt.png");

			products.add(p);

			p = new Product();
			p.setName("Call Of Duty WWII");
			p.setPrice( BigDecimal.valueOf(249.50));
			p.setScore(Short.parseShort("205"));
			p.setImage("Call Of Duty WWII.png");

			products.add(p);


			p = new Product();
			p.setName("Mortal Kombat XL");
			p.setPrice( BigDecimal.valueOf(69.99));
			p.setScore(Short.parseShort("150"));
			p.setImage("Mortal Kombat XL.png");

			products.add(p);

			p = new Product();
			p.setName("Shards of Darkness");
			p.setPrice( BigDecimal.valueOf(71.94));
			p.setScore(Short.parseShort("400"));
			p.setImage("Shards of Darkness.png");

			products.add(p);

			p = new Product();
			p.setName("Terra Média: Sombras de Mordor");
			p.setPrice( BigDecimal.valueOf(79.99));
			p.setScore(Short.parseShort("50"));
			p.setImage("Terra Média: Sombras de Mordor.png");

			products.add(p);

			p = new Product();
			p.setName("FIFA 18");
			p.setPrice( BigDecimal.valueOf(195.39));
			p.setScore(Short.parseShort("325"));
			p.setImage("FIFA 18.png");

			products.add(p);

			p = new Product();
			p.setName("Horizon Zero Dawn");
			p.setPrice( BigDecimal.valueOf(115.8));
			p.setScore(Short.parseShort("290"));
			p.setImage("Horizon Zero Dawn.png");

			products.add(p);

			repositoryJPA.saveAll(products);

			// criando uma pedido para teste
			Order order = new Order();
			//order.setId(1);
			order.setSubtotal(new BigDecimal(0.0));
			order.setTotal(new BigDecimal(0.0));
			order.setShipping(new BigDecimal(0.0));
			order.setStatus(StatusOrder.AGUARDANDO.getDescription());

//			orderRepositoryJPA.save(order);

			List<OrderProduct> orderProducts = new ArrayList<>();
			products.forEach(product -> {
				OrderProduct orderProduct = new OrderProduct(order,product,1);
				order.setSubtotal(order.getSubtotal().add(product.getPrice()));
				order.setShipping(order.getShipping().add(BigDecimal.valueOf(10.00)));
				orderProducts.add(orderProduct);
			});
			if (order.getSubtotal().compareTo(BigDecimal.valueOf(250.00)) > 0 ) {
				order.setTotal(order.getSubtotal());
			}else {
				order.setTotal(order.getSubtotal().add(order.getShipping()));
			}

			order.setOrderProducts(orderProducts);
			orderRepositoryJPA.save(order);
			repository.saveAll(orderProducts);


		};


	}
}
