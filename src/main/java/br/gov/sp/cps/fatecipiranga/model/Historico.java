package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data

public class Historico {
    private String nome_personagem;
    private String nome_arma;
    private int usos;
    private int mapa;

    public Historico(String nome_personagem, String nome_arma, int usos) {
        this.nome_personagem = nome_personagem;
        this.nome_arma = nome_arma;
        this.usos = usos;
        this.mapa = mapa;
    }

    public String getNome_personagem() { return nome_personagem; }
    public String getNome_arma() { return nome_arma; }
    public int getUsos() { return usos; }
    public int getMapa() {return mapa; }
}

    

