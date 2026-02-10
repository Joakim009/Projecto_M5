package jogo_ti_m5;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo_TI_M5 {

    public static void main(String[] args) {

        BaseDadosJogos bd = new BaseDadosJogos();
        bd.carregarCSV("jogos.csv");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== BASE DE DADOS DE VIDEOJOGOS ===");
            System.out.println("1. Listar jogos");
            System.out.println("2. Pesquisar por título");
            System.out.println("3. Filtrar por avaliação mínima (Metacritic)");
            System.out.println("4. Filtrar por categoria (SinglePlayer / Multiplayer / Coop / VR)");
            System.out.println("5. Ver detalhes completos de um jogo");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    listarJogos(bd.getJogos());
                    break;

                case 2:
                    System.out.print("Termo de pesquisa: ");
                    String termo = sc.nextLine().toLowerCase();
                    pesquisarTitulo(bd.getJogos(), termo);
                    break;

                case 3:
                    System.out.print("Avaliação mínima (0-100): ");
                    int min = sc.nextInt();
                    filtrarMetacritic(bd.getJogos(), min);
                    break;

                case 4:
                    System.out.print("Categoria: ");
                    String cat = sc.nextLine();
                    filtrarCategoria(bd.getJogos(), cat);
                    break;

                case 5:
                    System.out.print("ID do jogo: ");
                    String id = sc.nextLine();
                    verDetalhes(bd.getJogos(), id);
                    break;

                case 6:
                    System.out.println("A sair...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void listarJogos(ArrayList<Jogo> jogos) {
        for (int i = 0; i < 20 && i < jogos.size(); i++) {
            System.out.println(jogos.get(i));
        }
    }

    private static void pesquisarTitulo(ArrayList<Jogo> jogos, String termo) {
        for (Jogo j : jogos) {
            if (j.getName().toLowerCase().contains(termo)) {
                System.out.println(j);
            }
        }
    }

    private static void filtrarMetacritic(ArrayList<Jogo> jogos, int min) {
        for (Jogo j : jogos) {
            if (j.getMetacritic() >= min) {
                System.out.println(j);
            }
        }
    }

    private static void filtrarCategoria(ArrayList<Jogo> jogos, String cat) {
        String c = cat.toLowerCase();

        for (Jogo j : jogos) {

            switch (c) {
                case "singleplayer":
                    if (j.isSinglePlayer()) System.out.println(j);
                    break;
                case "multiplayer":
                    if (j.isMultiplayer()) System.out.println(j);
                    break;
                case "coop":
                    if (j.isCoop()) System.out.println(j);
                    break;
                case "vr":
                    if (j.isVr()) System.out.println(j);
                    break;
                default:
                    System.out.println("Categoria inválida.");
                    return;
            }
        }
    }

    private static void verDetalhes(ArrayList<Jogo> jogos, String id) {
        for (Jogo j : jogos) {
            if (j.getId().equals(id)) {
                j.mostrarDetalhes();
                return;
            }
        }
        System.out.println("Jogo não encontrado.");
    }
}
