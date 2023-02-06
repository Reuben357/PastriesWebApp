package com.pastries.Pastries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cake")
public class Cake implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String size;
    private String price;
    private String messageOnCake;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String cakeCode;

}

