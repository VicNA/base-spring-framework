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
@Table(name = "Product")
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private int price;

    @ManyToMany
    @JoinTable(
            name = "carts_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns =  @JoinColumn(name = "cart_id")
    )
    private List<ShopCart> shopCarts;

}
