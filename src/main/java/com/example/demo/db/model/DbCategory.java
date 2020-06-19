package com.example.demo.db.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(
        name = "to_do_category",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class DbCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "dbCategory", fetch = FetchType.LAZY)
    private List<DbToDoItem> dbToDoItems;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
