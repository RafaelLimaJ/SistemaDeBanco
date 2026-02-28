package com.sistemabanco.entitys;

public class ContaBancaria {
    private int numeroDaconta;
    private String nomedaconta;
    private double saldo = 0.0;

    public ContaBancaria() {
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroDaconta() {
        return numeroDaconta;
    }

    public String getNomedaconta() {
        return nomedaconta;
    }

    public void setNomedaconta(String nomedaconta) {
        this.nomedaconta = nomedaconta;
    }

    public void setNumeroDaconta(int numeroDaconta) {
        this.numeroDaconta = numeroDaconta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

