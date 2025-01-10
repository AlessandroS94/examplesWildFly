package it.example.servlet_jpa.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "name", nullable = false, length = 120)
    private String name;


    @Column(name = "email", nullable = false, length = 220)
    private String email;

    @Column(name = "country", length = 120)
    private String country;

}