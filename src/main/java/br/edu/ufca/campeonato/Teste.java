package br.edu.ufca.campeonato;

import static br.edu.ufca.campeonato.utils.Constantes.NOMES_DE_CLUBES;
import static br.edu.ufca.campeonato.utils.Gerador.*;
import br.edu.ufca.campeonato.entidades.Clube;
import br.edu.ufca.campeonato.entidades.Campeonato;

import java.util.List;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        final int quantidadeDeClubes = NOMES_DE_CLUBES.length;
        final List<String> nomesAleatorios = gerarListaDeNomesAleatorios(quantidadeDeClubes);
        final List<Clube> clubes = new ArrayList<>();

        System.out.println("A quantidade de clubes será: " + quantidadeDeClubes);
        System.out.println("Os clubes serão gerados de forma aleatória com uma lista de nomes pré-definida");

        for (String nome: nomesAleatorios) {
            clubes.add(new Clube(nome));
        }

        final Campeonato campeonato = new Campeonato(clubes);
        campeonato.jogarCampeonato();

        final String classificacao = campeonato.getClassificacao();
        final Clube clubeCampeao = campeonato.getCampeao();

        System.out.println("\nClassificação:\n");
        System.out.println(classificacao);

        System.out.print("Time campeão: " + clubeCampeao.nome);
        System.out.println("\nPontos: " + clubeCampeao.pontos + "\nSaldo de gols: " + clubeCampeao.saldoGols);
    }
}
