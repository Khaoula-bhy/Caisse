package com.example.caisse.Models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Products")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String category;
    private  Long price;

}
