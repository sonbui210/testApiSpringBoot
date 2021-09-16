package com.example.demoapitest.service;


import com.example.demoapitest.entities.Product;
import com.example.demoapitest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.findById(id));
        return result;
    }

    public ServiceResult create(Product product) {
        ServiceResult result = new ServiceResult();
        result.setData(productRepository.save(product));
        return result;
    }

    public ServiceResult update(Product product) {
        ServiceResult result = new ServiceResult();

        if (!productRepository.findById(product.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Product not found!");
        } else {
            productRepository.save(product);
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Product not found!");
        } else {
            productRepository.delete(product);
            result.setMessage("Product deleted!");
        }
        return  result;
    }

}
