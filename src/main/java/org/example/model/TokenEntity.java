package org.example.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tokens")
public class TokenEntity {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, columnName = "mesa_id")
    private Mesa mesa;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField
    private double posX;

    @DatabaseField
    private double posY;

    @DatabaseField
    private String urlImagem;

    public TokenEntity() {
    }

    public TokenEntity(Mesa mesa, String nome, double posX, double posY, String urlImagem) {
        this.mesa = mesa;
        this.nome = nome;
        this.posX = posX;
        this.posY = posY;
        this.urlImagem = urlImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
