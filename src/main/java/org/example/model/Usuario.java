package org.example.model;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName="usuarios")
public class Usuario
{
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(dataType=DataType.STRING)    
    private String nomeCompleto;
    
    @DatabaseField(dataType=DataType.STRING)    
    private String nomeUsuario;
    
    @DatabaseField(dataType=DataType.STRING)    
    private String enderecoEmail;
    
    @DatabaseField(dataType=DataType.STRING)    
    private String senha;

    public int getId(){
        return this.id;
    }

    public String getNomeCompleto(){
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario(){
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    public String getEnderecoEmail(){
        return this.enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail){
        this.enderecoEmail = enderecoEmail;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    @Override
    public String toString(){
        return this.nomeUsuario;
    }

}