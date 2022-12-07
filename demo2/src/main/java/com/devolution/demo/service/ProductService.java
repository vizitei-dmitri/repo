package com.devolution.demo.service;

import com.devolution.demo.entity.Product;
import com.devolution.demo.entity.User;
import com.devolution.demo.repository.ProductRepository;
import com.devolution.demo.request.ProductRequest;
import com.devolution.demo.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(ProductRequest productRequest) {
        Product product= new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            product.get().setName(productRequest.getName());
            product.get().setPrice(productRequest.getPrice());
            productRepository.save(product.get());
            return product.get();
        }
        return new Product();
    }

    public Product geProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseGet(Product::new);
    }

    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll(); //findHotels?
        return products;
    }

    public String deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return "product was deleted successfully";
        }
        return "product was not found";
    }



}
