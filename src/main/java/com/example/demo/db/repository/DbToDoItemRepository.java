package com.example.demo.db.repository;

import com.example.demo.db.model.DbToDoItem;
import org.springframework.data.repository.CrudRepository;

public interface DbToDoItemRepository extends CrudRepository<DbToDoItem, Long> {

}
