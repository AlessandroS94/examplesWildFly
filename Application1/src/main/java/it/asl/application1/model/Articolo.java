package it.asl.application1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Articolo {
    private String nome;
    private String descrizione;
    private int quantita;
    private int codice;

}
