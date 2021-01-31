package br.com.supera.game.store;

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

	public static void main(String[] args) {

		SpringApplication.run(PsJavaMainApplication.class, args);
	}

	//Carga inicial do arquivo .yml para o banco hsqldb em memória via spring repository
	@Bean
	InitializingBean sendDatabase() {
		List<Product> products = new ArrayList<>();
		return () -> {
			Product p = new Product();
			p.id = 312;
			p.name = "Super Mario Odyssey";
			p.price = BigDecimal.valueOf(197.88);
			p.score =Short.valueOf("100");
			p.image =  "super-mario-odyssey.png";

			products.add(p);

			p = new Product();
			p.id = 201;
			p.name = "Call Of Duty Infinite Warfare";
			p.price = BigDecimal.valueOf(49.99);
			p.score =Short.valueOf("80");
			p.image =  "Call Of Duty Infinite Warfare.png";

			products.add(p);

			p = new Product();
			p.id = 102;
			p.name = "The Witcher III Wild Hunt";
			p.price = BigDecimal.valueOf(119.50);
			p.score =Short.valueOf("250");
			p.image =  "The Witcher III Wild Hunt.png";

			products.add(p);

			p = new Product();
			p.id = 99;
			p.name = "Call Of Duty WWII";
			p.price = BigDecimal.valueOf(249.50);
			p.score =Short.valueOf("205");
			p.image =  "Call Of Duty WWII.png";

			products.add(p);


			p = new Product();
			p.id = 12;
			p.name = "Mortal Kombat XL";
			p.price = BigDecimal.valueOf(69.99);
			p.score =Short.valueOf("150");
			p.image =  "Mortal Kombat XL.png";

			products.add(p);

			p = new Product();
			p.id = 74;
			p.name = "Shards of Darkness";
			p.price = BigDecimal.valueOf(71.94);
			p.score =Short.valueOf("400");
			p.image =  "Shards of Darkness.png";

			products.add(p);

			p = new Product();
			p.id = 31;
			p.name = "Terra Média: Sombras de Mordor";
			p.price = BigDecimal.valueOf(79.99);
			p.score =Short.valueOf("50");
			p.image =  "Terra Média: Sombras de Mordor.png";

			products.add(p);

			p = new Product();
			p.id = 420;
			p.name = "FIFA 18";
			p.price = BigDecimal.valueOf(195.39);
			p.score =Short.valueOf("325");
			p.image =  "FIFA 18.png";

			products.add(p);

			p = new Product();
			p.id = 501;
			p.name = "Horizon Zero Dawn";
			p.price = BigDecimal.valueOf(115.8);
			p.score =Short.valueOf("290");
			p.image =  "Horizon Zero Dawn.png";

			products.add(p);

			repositoryJPA.saveAll(products);
		};
	}
}
