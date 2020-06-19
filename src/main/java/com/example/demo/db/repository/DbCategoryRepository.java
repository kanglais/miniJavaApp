package com.example.demo.db.repository;

import com.example.demo.db.model.DbCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.StreamSupport;

public interface DbCategoryRepository extends CrudRepository<DbCategory, Long> {
    DbCategory findByName(final String name);
}
