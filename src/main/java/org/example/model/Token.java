package org.example.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Token {
    private final StringProperty nome = new SimpleStringProperty();
    private final DoubleProperty posX = new SimpleDoubleProperty();
    private final DoubleProperty posY = new SimpleDoubleProperty();
    private final String urlImagem;

    public Token(String nome, double x, double y, String urlImagem) {
        this.nome.set(nome);
        this.posX.set(x);
        this.posY.set(y);
        this.urlImagem = urlImagem;
    }

    public StringProperty nomeProperty() { return nome; }
    public DoubleProperty posXProperty() { return posX; }
    public DoubleProperty posYProperty() { return posY; }
    public String getUrlImagem() { return urlImagem; }
}