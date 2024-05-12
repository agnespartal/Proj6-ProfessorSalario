package com.example.proj6_professorsalario.model;

public class Horista extends Professor{

    private int horasAula;
    private double valorHoraAula;

    public Horista(){
        super();
    }
    @Override
    public double CalculaSalario(int tempo)
    {
        return tempo * 35;
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
}
