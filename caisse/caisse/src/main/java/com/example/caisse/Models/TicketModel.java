package com.example.caisse.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="Ticket")
@Data
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String date;
    private Double montant;
    @ManyToMany(fetch=FetchType.LAZY)
            @JoinTable(name="ticket_products" , joinColumns=@JoinColumn(name = "ticket_model_id"),inverseJoinColumns = @JoinColumn(name = "products_id"))

    List<ProductModel> products;
}
