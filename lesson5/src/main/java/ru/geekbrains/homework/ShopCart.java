package ru.geekbrains.homework;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "ShopCart")
public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToMany
    @JoinTable(
            name = "carts_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns =  @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
