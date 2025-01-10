package it.example.servlet_jdbc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;

    private String name;

    private String email;

    private String country;

}