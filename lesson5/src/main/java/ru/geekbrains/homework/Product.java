package ru.geekbrains.homework;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @NonNull
    @Column(name = "price", nullable = false)
    private int price;

    @ManyToMany
    @JoinTable(
            name = "carts_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns =  @JoinColumn(name = "cart_id")
    )
    @ToString.Exclude
    private List<ShopCart> shopCarts;
}
