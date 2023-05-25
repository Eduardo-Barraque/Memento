package Memento;

public class QuartoStateOcupado extends QuartoState{
    private QuartoStateOcupado() {};
    private static QuartoStateOcupado instance = new QuartoStateOcupado();
    public static QuartoStateOcupado getInstance() {
        return instance;
    }

    public String getState() {
        return "Ocupado";
    }

    public boolean disponibilizar(Quarto quarto) {
        quarto.setState(QuartoStateDisponivel.getInstance());
        return true;
    }
}
