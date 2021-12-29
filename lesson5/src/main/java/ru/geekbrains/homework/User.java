package ru.geekbrains.homework;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<ShopCart> shopCarts;

}
