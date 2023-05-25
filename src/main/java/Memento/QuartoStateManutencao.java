package Memento;

public class QuartoStateManutencao extends QuartoState{
    private QuartoStateManutencao() {};
    private static QuartoStateManutencao instance = new QuartoStateManutencao();
    public static QuartoStateManutencao getInstance() {
        return instance;
    }

    public String getState() {
        return "Manutencao";
    }

    public boolean disponibilizar(Quarto quarto) {
        quarto.setState(QuartoStateDisponivel.getInstance());
        return true;
    }
}
