package Memento;

import java.util.ArrayList;
import java.util.List;

public class Quarto {private String numero;
    private QuartoState state;
    private List<QuartoState> memento = new ArrayList<QuartoState>();

    public Quarto() {
        this.state = QuartoStateDisponivel.getInstance();
    }

    public void setState(QuartoState state) {
        this.state = state;
        this.memento.add(this.state);
    }
    public void restaurarState(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.state = this.memento.get(indice);
    }

    public boolean disponibilizar() {
        return state.disponibilizar(this);
    }

    public boolean ocupar() {
        return state.ocupar(this);
    }

    public boolean manutenir() {
        return state.manutenir(this);
    }

    public boolean reservar() {
        return state.reservar(this);
    }

    public String getNumerostate() {
        return state.getState();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public QuartoState getState() {
        return state;
    }
    public List<QuartoState> getStates() {
        return this.memento;
    }
}

