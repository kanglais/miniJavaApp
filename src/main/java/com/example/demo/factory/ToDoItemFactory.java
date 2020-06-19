package com.example.demo.factory;

import com.example.demo.db.model.DbToDoItem;
import com.example.demo.model.Category;
import com.example.demo.model.ToDoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ToDoItemFactory {

    private final CategoryFactory categoryFactory;

    public DbToDoItem constructDbToDoItem(final ToDoItem toDoItem) {
        final DbToDoItem dbToDoItem = new DbToDoItem();
        dbToDoItem.setDescription(toDoItem.getDescription());
        dbToDoItem.setDueDate(toDoItem.getDueDate());
        dbToDoItem.setDone(toDoItem.isDone());
        return dbToDoItem;
    }

    public ToDoItem constructToDoItem(final DbToDoItem dbToDoItem) {
        return ToDoItem.builder()
                .id(dbToDoItem.getId())
                .description(dbToDoItem.getDescription())
                .dueDate(dbToDoItem.getDueDate())
                .category(categoryFactory.constructCategory(dbToDoItem.getDbCategory()))
                .isDone(dbToDoItem.isDone())
                .createdAt(dbToDoItem.getCreatedAt())
                .updatedAt(dbToDoItem.getUpdatedAt())
                .build();
    }
}
