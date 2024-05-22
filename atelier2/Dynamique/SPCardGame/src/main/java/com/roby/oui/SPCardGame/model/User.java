package com.roby.oui.SPCardGame.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    private int credits = 100;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards;
}
