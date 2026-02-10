package jogo_ti_m5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BaseDadosJogos {

    private ArrayList<Jogo> jogos = new ArrayList<>();

    public void carregarCSV(String nomeFicheiro) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
            String linha;

            br.readLine(); // ignorar cabeçalho

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(",", -1);

                if (partes.length < 11) continue;

                String id = partes[0];
                String name = partes[1];
                String release = partes[2];

                int age = partes[3].isEmpty() ? 0 : Integer.parseInt(partes[3]);
                int meta = partes[4].isEmpty() ? 0 : Integer.parseInt(partes[4]);

                boolean sp = Boolean.parseBoolean(partes[5]);
                boolean mp = Boolean.parseBoolean(partes[6]);
                boolean cp = Boolean.parseBoolean(partes[7]);
                boolean vr = Boolean.parseBoolean(partes[8]);

                String about = partes[9];
                String image = partes[10];

                Jogo j = new Jogo(id, name, release, age, meta, sp, mp, cp, vr, about, image);
                jogos.add(j);
            }

            br.close();
            System.out.println("Jogos carregados: " + jogos.size());

        } catch (Exception e) {
            System.out.println("Erro ao ler ficheiro: " + e.getMessage());
        }
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }
}
