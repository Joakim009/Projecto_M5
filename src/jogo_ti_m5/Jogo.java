package jogo_ti_m5;

public class Jogo {

    private String id;
    private String name;
    private String releaseDate;
    private int requiredAge;
    private int metacritic;
    private boolean singlePlayer;
    private boolean multiplayer;
    private boolean coop;
    private boolean vr;
    private String aboutText;
    private String headerImage;

    public Jogo(String id, String name, String releaseDate, int requiredAge, int metacritic,
                boolean singlePlayer, boolean multiplayer, boolean coop, boolean vr,
                String aboutText, String headerImage) {

        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.requiredAge = requiredAge;
        this.metacritic = metacritic;
        this.singlePlayer = singlePlayer;
        this.multiplayer = multiplayer;
        this.coop = coop;
        this.vr = vr;
        this.aboutText = aboutText;
        this.headerImage = headerImage;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getMetacritic() { return metacritic; }
    public boolean isSinglePlayer() { return singlePlayer; }
    public boolean isMultiplayer() { return multiplayer; }
    public boolean isCoop() { return coop; }
    public boolean isVr() { return vr; }

    @Override
    public String toString() {
        return id + " | " + name + " | Metacritic: " + metacritic;
    }

    public void mostrarDetalhes() {
        System.out.println("\n=== DETALHES DO JOGO ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + name);
        System.out.println("Data de lançamento: " + releaseDate);
        System.out.println("Idade recomendada: " + requiredAge);
        System.out.println("Metacritic: " + metacritic);
        System.out.println("Singleplayer: " + singlePlayer);
        System.out.println("Multiplayer: " + multiplayer);
        System.out.println("Coop: " + coop);
        System.out.println("VR: " + vr);
        System.out.println("Descrição: " + aboutText);
        System.out.println("Imagem: " + headerImage);
    }
}
