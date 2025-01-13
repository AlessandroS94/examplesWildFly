package it.example.jpa_jboss_servlet_ejb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "instructor")

public class Instructor {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
}