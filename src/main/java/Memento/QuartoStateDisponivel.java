package Memento;

public class QuartoStateDisponivel extends QuartoState {
    private QuartoStateDisponivel() {};
    private static QuartoStateDisponivel instance = new QuartoStateDisponivel();
    public static QuartoStateDisponivel getInstance() {
        return instance;
    }

    public String getState() {
        return "Disponivel";
    }

    public boolean manutenir(Quarto quarto) {
        quarto.setState(QuartoStateManutencao.getInstance());
        return true;
    }
    public boolean ocupar(Quarto quarto) {
        quarto.setState(QuartoStateOcupado.getInstance());
        return true;
    }
    public boolean reservar(Quarto quarto) {
        quarto.setState(QuartoStateReservado.getInstance());
        return true;
    }
}
