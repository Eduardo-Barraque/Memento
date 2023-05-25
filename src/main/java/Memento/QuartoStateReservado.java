package Memento;

public class QuartoStateReservado extends QuartoState {
    private QuartoStateReservado() {};
    private static QuartoStateReservado instance = new QuartoStateReservado();
    public static QuartoStateReservado getInstance() {
        return instance;
    }

    public String getState() {
        return "Reservado";
    }

    public boolean disponibilizar(Quarto quarto) {
        quarto.setState(QuartoStateDisponivel.getInstance());
        return true;
    }
    public boolean ocupar(Quarto quarto) {
        quarto.setState(QuartoStateOcupado.getInstance());
        return true;
    }
}
