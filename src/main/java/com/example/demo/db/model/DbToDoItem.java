package com.example.demo.db.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

// lombok getters & setters
@Data
@Entity
@Table(name = "toDos")
public class DbToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private Date dueDate;
    private boolean isDone;

    @ManyToOne(fetch = FetchType.LAZY)
    private DbCategory dbCategory;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
