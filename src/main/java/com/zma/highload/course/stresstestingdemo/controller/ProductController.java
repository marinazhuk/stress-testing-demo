package com.zma.highload.course.stresstestingdemo.controller;

import com.zma.highload.course.stresstestingdemo.model.Product;
import com.zma.highload.course.stresstestingdemo.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Product getByCode(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(Long.valueOf(id));
        return product.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"));
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam Optional<String> name, @RequestParam Optional<String> category) {
        return productRepository.findAll(Example.of(new Product(name.orElse(null), category.orElse(null))));
    }
}
