package br.com.supera.game.store.product.service;

import br.com.supera.game.store.product.domain.Product;
import br.com.supera.game.store.product.repository.ProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/product")
public class ProductController {

    @Autowired
    private ProductRepositoryJPA repositoryJPA;

    @GetMapping(path="/all/{sortType}", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Product> getAllProducts(@PathVariable("sortType") String sortType) {
        Iterable<Product> products = repositoryJPA.findAll(Sort.by(Sort.Order.asc(sortType)));
        return products;
    }
}
