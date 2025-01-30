/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author becca
 */
public class Oferta {
    private int ofertaId;
    private double valor;
    private int pago;
    private String categoria;
    private int usuarioId;
    private int membroId;
    private String membroNome;

    public Oferta() {
    }

    public Oferta(int ofertaId, double valor, int pago, String categoria, int usuarioId, int membroId, String membroNome) {
        this.ofertaId = ofertaId;
        this.valor = valor;
        this.pago = pago;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
        this.membroId = membroId;
        this.membroNome = membroNome;
    }
    
    public Oferta(int ofertaId, double valor, int pago, String categoria, int usuarioId, int membroId) {
        this.ofertaId = ofertaId;
        this.valor = valor;
        this.pago = pago;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
        this.membroId = membroId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getMembroId() {
        return membroId;
    }

    public void setMembroId(int membroId) {
        this.membroId = membroId;
    }

    public String getMembroNome() {
        return membroNome;
    }

    public void setMembro(String membroNome) {
        this.membroNome = membroNome;
    }
}

