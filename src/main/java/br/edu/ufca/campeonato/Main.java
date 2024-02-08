package br.edu.ufca.campeonato;

import br.edu.ufca.campeonato.entidades.Clube;
import br.edu.ufca.campeonato.entidades.Campeonato;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Clube> clubes = new ArrayList<>();
        int quantidadeDeClubes;

        do {
            System.out.print("Digite uma quantidade de clubes: ");
            quantidadeDeClubes = scanner.nextInt();
            scanner.nextLine();
        } while (quantidadeDeClubes < 2);

        for (int indice = 0; indice < quantidadeDeClubes; indice++) {
            System.out.println("Digite um nome para o " + (indice + 1) + "° clube:");
            final String nome = scanner.nextLine();
            final Clube clube = new Clube(nome);
            clubes.add(clube);
        }

        final Campeonato campeonato = new Campeonato(clubes);
        campeonato.jogarCampeonato();
        final String classificacao = campeonato.getClassificacao();
        final Clube clubeCampeao = campeonato.getCampeao();

        System.out.println("\n\nO campeonato foi realizado!\nVeja a classificação:\n");
        System.out.println(classificacao);

        System.out.print("Parabéns ao time campeão " + clubeCampeao.nome + "!");
        System.out.println("\nPontos: " + clubeCampeao.pontos + "\nSaldo de gols: " + clubeCampeao.saldoGols);
    }
}
