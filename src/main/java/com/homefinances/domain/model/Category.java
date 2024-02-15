package com.homefinances.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @OneToOne(mappedBy = "category")
    private Buy buy;

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(idCategory, category.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory);
    }
}
