package org.example.model;

public class Usuario {

    private String usuario;
    private String senha;

    public Usuario (String usuario, String senha){
        setUsuario(usuario);
        setSenha(senha);
    }

    public Mesa criarMesa(String nome, String senha){
        Mesa mesa = new Mesa(nome, senha, this);
        return mesa;
    }

    //public Mesa entrarMesa(String id, String senha) {
    //  Procurar na lista de objetos Mesa, o id e se a senha corresponde a esse objeto.
    //}

    public void setUsuario(String usuario){
        if (usuario == null || usuario.trim().isEmpty()){
            throw new IllegalArgumentException("Nome de usuário vazio.");
        }

        if (usuario.length() < 8 || usuario.length() > 20){
            throw new IllegalArgumentException("O nome de usuário deve ter entre 8 e 20 caracteres.");
        }

        if (!usuario.matches("[a-zA-Z].*")){
            throw new IllegalArgumentException("O nome de usuário deve começar com uma letra.");
        }

        if (!usuario.matches("[a-zA-Z0-9]*")){
            throw new IllegalArgumentException("O nome de usuário deve conter apenas letras ou números.");
        }

        if (usuario.contains(" ")){
            throw new IllegalArgumentException("O nome de usuário não pode conter espaços vazios.");
        }

        else{
            this.usuario = usuario;
        }
    }

    public void setSenha(String senha){
        if (senha == null || senha.trim().isEmpty()){
            throw new IllegalArgumentException("Senha vazia.");
        }

        if (senha.length() < 8 || senha.length() > 20){
            throw new IllegalArgumentException("A senha deve ter entre 8 e 20 caracteres.");
        }

        if (senha.contains(" ")){
            throw new IllegalArgumentException("A senha não pode conter espaços vazios.");
        }

        else{
            this.senha = senha;
        }
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getSenha(){
        return this.senha;
    }


}
