package com_reto3_ciclo3.reto3.service;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Category;
import com_reto3_ciclo3.reto3.repository.ICategoryRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class CategoryService {

    private ICategoryRepository categoryRepository;

    @Autowired

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Collection<Category> findAllCategories(){
        log.info("Se buscaron todos las categorias");
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) throws ResourceNotFound {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new ResourceNotFound("No se encontro la categoria con id: " + id);
        }else{
            log.info("Se busco la categoria con id: " + id);
            return category.get();
        }
    }

    public Category saveCategory(Category c){
        c.setIdCategory(null);
        Category category = categoryRepository.save(c);
        log.info("Se guardo la categoria con nombre: " + category.getName());
        return category;
    }
}
