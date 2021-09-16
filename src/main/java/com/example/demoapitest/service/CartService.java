package com.example.demoapitest.service;


import com.example.demoapitest.entities.Cart;
import com.example.demoapitest.repository.CartRepository;
import com.example.demoapitest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(cartRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        result.setData(cartRepository.findById(id).orElse(null));
        return result;
    }

    public ServiceResult create(Cart cart) {
        ServiceResult result = new ServiceResult();

        result.setData(cartRepository.save(cart));
        result.setMessage("Cart created!");
        return result;
    }

    public ServiceResult update(Cart cart) {
        ServiceResult result = new ServiceResult();

        if (!cartRepository.findById(cart.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Cart not found!");
        } else {
            result.setData(cartRepository.save(cart));
            result.setMessage("Cart updated!");
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart==null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Cart not found!");
        } else  {
            cartRepository.delete(cart);
            result.setMessage("Cart deleted!");
        }
        return result;
    }

}
