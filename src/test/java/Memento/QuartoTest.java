package Memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuartoTest {
    Quarto quarto;

    @BeforeEach
    public void setUp() {
        quarto = new Quarto();
    }

    //Memento Testes

    @Test
    void deveArmazenarEstados() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        quarto.setState(QuartoStateOcupado.getInstance());
        assertEquals(2, quarto.getStates().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        quarto.setState(QuartoStateReservado.getInstance());
        quarto.restaurarState(0);
        assertEquals(QuartoStateDisponivel.getInstance(), quarto.getState());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        quarto.setState(QuartoStateReservado.getInstance());
        quarto.setState(QuartoStateOcupado.getInstance());
        quarto.setState(QuartoStateDisponivel.getInstance());
        quarto.restaurarState(2);
        assertEquals(QuartoStateOcupado.getInstance(), quarto.getState());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            quarto.restaurarState(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }



    //Quarto Disponivel

    @Test
    public void naoDeveDisponibilizarQuartoDisponivel() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        assertFalse(quarto.disponibilizar());
    }

    @Test
    public void deveManutenirQuartoDisponivel() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        assertTrue(quarto.manutenir());
        assertEquals(QuartoStateManutencao.getInstance(), quarto.getState());
    }
    @Test
    public void deveOcuparQuartoDisponivel() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        assertTrue(quarto.ocupar());
        assertEquals(QuartoStateOcupado.getInstance(), quarto.getState());
    }
    @Test
    public void deveReservarQuartoDisponivel() {
        quarto.setState(QuartoStateDisponivel.getInstance());
        assertTrue(quarto.reservar());
        assertEquals(QuartoStateReservado.getInstance(), quarto.getState());
    }

    // Quarto Manutencao

    @Test
    public void deveDisponibilizarQuartoManutencao() {
        quarto.setState(QuartoStateManutencao.getInstance());
        assertTrue(quarto.disponibilizar());
        assertEquals(QuartoStateDisponivel.getInstance(), quarto.getState());
    }
    @Test
    public void naoDeveManutenirQuartoManutencao() {
        quarto.setState(QuartoStateManutencao.getInstance());
        assertFalse(quarto.manutenir());
    }
    @Test
    public void naoDeveOcuparQuartoManutencao() {
        quarto.setState(QuartoStateManutencao.getInstance());
        assertFalse(quarto.ocupar());
    }
    @Test
    public void naoDeveReservarQuartoManutencao() {
        quarto.setState(QuartoStateManutencao.getInstance());
        assertFalse(quarto.reservar());
    }

    //Quarto Ocupado

    @Test
    public void deveDisponibilizarQuartoOcupado() {
        quarto.setState(QuartoStateOcupado.getInstance());
        assertTrue(quarto.disponibilizar());
        assertEquals(QuartoStateDisponivel.getInstance(), quarto.getState());
    }

    @Test
    public void naoDeveManutenirQuartoOcupado() {
        quarto.setState(QuartoStateOcupado.getInstance());
        assertFalse(quarto.manutenir());
    }
    @Test
    public void naoDeveOcuparQuartoOcupado() {
        quarto.setState(QuartoStateOcupado.getInstance());
        assertFalse(quarto.ocupar());
    }
    @Test
    public void naoDeveReservarQuartoOcupado() {
        quarto.setState(QuartoStateOcupado.getInstance());
        assertFalse(quarto.reservar());
    }

    //Quarto Reservado

    @Test
    public void deveDisponibilizarQuartoReservado() {
        quarto.setState(QuartoStateReservado.getInstance());
        assertTrue(quarto.disponibilizar());
        assertEquals(QuartoStateDisponivel.getInstance(), quarto.getState());
    }
    @Test
    public void naoDeveManutenirQuartoReservado() {
        quarto.setState(QuartoStateReservado.getInstance());
        assertFalse(quarto.manutenir());
    }
    @Test
    public void deveOcuparQuartoReservado() {
        quarto.setState(QuartoStateReservado.getInstance());
        assertTrue(quarto.ocupar());
        assertEquals(QuartoStateOcupado.getInstance(), quarto.getState());
    }
    @Test
    public void naoDeveReservarQuartoReservado() {
        quarto.setState(QuartoStateReservado.getInstance());
        assertFalse(quarto.reservar());
    }
}
