package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Builder
public class ToDoItem {

    @JsonProperty(access = READ_ONLY)
    private long id;

    private String description;
    private Date dueDate;
    private boolean isDone;
    private Category category;

    @JsonProperty(access = READ_ONLY)
    private Date createdAt;
    @JsonProperty(access = READ_ONLY)
    private Date updatedAt;

    /*access and sets values of description
        getters & setters; set description & get description
        returns description string
        this = self, get self.description*/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Category getCategory() {
        return category;
    }

    //final makes the var constant
    public void setCategory(final Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //    public static void main(String ...args){
//        ToDoItem toDoItem = new ToDoItem();
//        Category category = new Category();
//
//        toDoItem.setCategory(category);
//        category.setName("foo");
//    }
}
