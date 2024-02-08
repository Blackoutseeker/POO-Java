package br.edu.ufca.campeonato.entidades;

public class Clube {
    public String nome;
    public int pontos;
    public int saldoGols;

    public Clube(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("O nome do clube não pode estar vazio");
        }
        this.nome = nome;
        this.pontos = 0;
        this.saldoGols = 0;
    }
}
