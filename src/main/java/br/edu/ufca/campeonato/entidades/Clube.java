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

    /** Irá adicionar 3 pontos ao clube, além de somar seu placar ao saldo de gols.
     * @param saldoGols O número de gols que será somado com o saldo já existente.
     */
    public void ganhar(int saldoGols) {
        pontos += 3;
        this.saldoGols += saldoGols;
    }
}