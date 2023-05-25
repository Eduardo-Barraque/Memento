package Memento;

public abstract class QuartoState {
    public abstract String getState();

    public boolean disponibilizar(Quarto quarto) {
        return false;
    }

    public boolean ocupar(Quarto quarto) {
        return false;
    }

    public boolean manutenir(Quarto quarto) {
        return false;
    }

    public boolean reservar(Quarto quarto) {
        return false;
    }


}
