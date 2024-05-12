package com.example.proj6_professorsalario.model;

public class Titular extends Professor {

    private int anosInstituicao;
    private double salario;

    public Titular(){
        super();
    }
    @Override
    public double CalculaSalario(int tempo) {
        if (tempo >= 5){
            int fator = tempo % 2;
            salario = 5000 * (1 + (fator * 0.5));
        }
        return salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
