package com.example.demoapitest.service;


import com.example.demoapitest.entities.Test;
import com.example.demoapitest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(testRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        //Test test = testRepository.findById(id).orElse(null);
        result.setData(testRepository.findById(id).orElse(null));
        return result;
    }

    public ServiceResult create(Test test) {
        ServiceResult result = new ServiceResult();
        int a = test.getA();
        int b = test.getB();
        test.setTong(a+b);
        result.setData(testRepository.save(test));
        result.setMessage("Test create!");
        return result;
    }

    public ServiceResult update(Test test) {
        ServiceResult result = new ServiceResult();
         if (!testRepository.findById(test.getTestId()).isPresent()) {
             result.setStatus(ServiceResult.Status.FAILED);
             result.setMessage("Test not found!");
         } else {
             test.setTong(test.getA() + test.getB());
             result.setData(testRepository.save(test));
             result.setMessage("Test updated!");
         }
         return result;
    }

    public ServiceResult delele(int id) {
        ServiceResult result = new ServiceResult();

        Test test = testRepository.findById(id).orElse(null);
        if (!testRepository.findById(id).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Test not found!");
        } else {
            testRepository.delete(test);
            result.setMessage("Test deleted!");
        }

        return result;
    }

}
