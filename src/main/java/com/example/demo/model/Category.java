package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
public class Category {

    @JsonProperty(access = READ_ONLY)
    private long id;

    private String name;
    private String description;

    @JsonProperty(access = READ_ONLY)
    private Date createdAt;
    @JsonProperty(access = READ_ONLY)
    private Date updatedAt;
}
