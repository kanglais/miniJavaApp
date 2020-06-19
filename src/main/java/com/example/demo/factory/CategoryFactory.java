package com.example.demo.factory;

import com.example.demo.db.model.DbCategory;
import com.example.demo.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory {

    public DbCategory constructDbCategory(final Category category){
        final DbCategory dbCategory = new DbCategory();
        dbCategory.setName(category.getName());
        dbCategory.setDescription(category.getDescription());
        return dbCategory;
    }

    public Category constructCategory(final DbCategory dbCategory){
        return Category.builder()
                .id(dbCategory.getId())
                .name(dbCategory.getName())
                .description(dbCategory.getDescription())
                .createdAt(dbCategory.getCreatedAt())
                .updatedAt(dbCategory.getUpdatedAt())
                .build();
    }

}
