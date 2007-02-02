package br.quentinha.model;

public enum TamanhoQuentinha {

    GRANDE("G"), PEQUENA("P"), EXTRA("E");

    private final String valor;

    TamanhoQuentinha(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
