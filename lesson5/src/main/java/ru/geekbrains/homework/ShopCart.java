package ru.geekbrains.homework;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "shopcart")
public class ShopCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "number", nullable = false, unique = true)
    private long number;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "carts_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns =  @JoinColumn(name = "product_id")
    )
    @ToString.Exclude
    private List<Product> products;
}
