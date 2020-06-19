package com.example.demo.service;

import com.example.demo.db.model.DbCategory;
import com.example.demo.db.repository.DbCategoryRepository;
import com.example.demo.factory.CategoryFactory;
import com.example.demo.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final DbCategoryRepository dbCategoryRepository;
    private final CategoryFactory categoryFactory;

    public List<Category> getCategory(){
        return StreamSupport.stream(dbCategoryRepository.findAll().spliterator(), false)
                .map(categoryFactory::constructCategory)
                .collect(Collectors.toList());
    }

    public Category createCategory(final Category category){
        final DbCategory dbCategory = categoryFactory.constructDbCategory(category);
        final DbCategory saved = dbCategoryRepository.save(dbCategory);

        return categoryFactory.constructCategory(saved);
    }

    DbCategory getDbCategoryByName(final String name) {
        return dbCategoryRepository.findByName(name);
    }

    DbCategory getOrCreateDbCategory(final Category category){
        if (category == null){
            return null;
        }

        if (getDbCategoryByName(category.getName()) == null){
            createCategory(category);
        }
        return getDbCategoryByName(category.getName());
    }
}
