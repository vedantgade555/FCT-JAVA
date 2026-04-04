package com.vedant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*; // <-- This handles @Id, @Entity, @GeneratedValue, etc.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// DELETE this line: import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngridientsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngridientsItem> ingridientsItems = new ArrayList<>();

}