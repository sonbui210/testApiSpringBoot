package com.example.demoapitest.service;


import com.example.demoapitest.entities.Order;
import com.example.demoapitest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(orderRepo.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Order order = orderRepo.findById(id).orElse(null);
        result.setData(order);
        return result;
    }

    public ServiceResult create(Order order) {
        ServiceResult result = new ServiceResult();
        result.setData(orderRepo.save(order));
        return result;
    }

    public ServiceResult update(Order order) {
        ServiceResult result = new ServiceResult();

        if (!orderRepo.findById(order.getOrderId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order Not Found!");
        } else {
            result.setData(orderRepo.save(order));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Order order = orderRepo.findById(id).orElse(null);

        if (order == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Order Not Found!");
        } else {
            orderRepo.delete(order);
            result.setMessage("Delete success!");
        }
        return result;
    }

}
