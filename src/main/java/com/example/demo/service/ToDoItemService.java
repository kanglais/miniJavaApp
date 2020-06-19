package com.example.demo.service;

import com.example.demo.db.model.DbCategory;
import com.example.demo.db.model.DbToDoItem;
import com.example.demo.db.repository.DbToDoItemRepository;
import com.example.demo.factory.ToDoItemFactory;
import com.example.demo.model.ToDoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ToDoItemService {

    private final DbToDoItemRepository dbToDoItemRepository;
    private final ToDoItemFactory toDoItemFactory;
    private final CategoryService categoryService;

    //same as in controller w/o annotations
    //logic happens here i/o controller

    /*
    streams - either iterate over data returned from db & convert to obj & return as json
    or, use streams -
     */
    public List<ToDoItem> getToDoItems() {
        return StreamSupport.stream(dbToDoItemRepository.findAll().spliterator(), false)
                .map(toDoItemFactory::constructToDoItem)
                .collect(Collectors.toList());
    }

    public ToDoItem createToDoItem(final ToDoItem toDoItem){
        DbCategory dbCategory = categoryService.getOrCreateDbCategory(toDoItem.getCategory());

        final DbToDoItem dbToDoItem = toDoItemFactory.constructDbToDoItem(toDoItem);
        dbToDoItem.setDbCategory(dbCategory);
        final DbToDoItem saved = dbToDoItemRepository.save(dbToDoItem);

        return toDoItemFactory.constructToDoItem(saved);

    }

    public ToDoItem getToDoItem(final long id) {
        return toDoItemFactory.constructToDoItem(
                dbToDoItemRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException()));
    }

    public void deleteToDoItem(final long id){
        dbToDoItemRepository.deleteById(id);
    }
}
