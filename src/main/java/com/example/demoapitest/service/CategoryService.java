package com.example.demoapitest.service;


import com.example.demoapitest.entities.Category;
import com.example.demoapitest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(categoryRepository.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        result.setData(categoryRepository.findById(id).orElse(null));
        return result;
    }

    public ServiceResult create(Category category) {
        ServiceResult result = new ServiceResult();
        result.setData(categoryRepository.save(category));
        return result;
    }

    public ServiceResult update(Category category) {
        ServiceResult result = new ServiceResult();

        if (!categoryRepository.findById(category.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Category not found!");
        } else {
            result.setData(categoryRepository.save(category));
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Category category = categoryRepository.findById(id).orElse(null);
        if (category==null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Category not found!");
        } else {
            categoryRepository.delete(category);
            result.setMessage("Category deleted!");
        }
        return result;
    }

}
