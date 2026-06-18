package org.example.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mesas")
public class Mesa {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(canBeNull = false)
    private String senha;

    @DatabaseField(canBeNull = false)
    private String capa;

    public Mesa(){
    }

    public Mesa(String nome, String senha, String capa){
        this.nome = nome;
        this.senha = senha;
        this.capa = capa;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getCapa(){
        return capa;
    }

    public void setCapa(String capa){
        this.capa = capa;
    }
}
