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

    public Articolo(String nome, String descrizione, int quantita) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
    }
}
