package com.example.demo.controller;

import com.example.demo.model.ToDoItem;
import com.example.demo.service.ToDoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//spring: auto-creates class; class is a controller
@Controller
@RequestMapping("/todos")
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    //
    public ToDoItemController(final ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    //post request call this method
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ToDoItem createToDoItem(@RequestBody final ToDoItem toDoItem){
        return toDoItemService.createToDoItem(toDoItem);
    }

    //
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<ToDoItem> getToDoItems() {
        return toDoItemService.getToDoItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ToDoItem getToDoItem(@PathVariable final long id){
        return toDoItemService.getToDoItem(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
    public void deleteToDoItem(@PathVariable final long id){
        toDoItemService.deleteToDoItem(id);
    }
}
