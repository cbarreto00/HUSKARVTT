package org.example.repository;

import org.example.model.Usuario;
import org.example.database.DatabaseConnection;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import com.j256.ormlite.support.ConnectionSource;
import java.util.List;

public class UsuarioRepository
{

    private static Dao<Usuario, Integer> daoUsuario;
    private Usuario usuario;
    
    public UsuarioRepository(){
    try{
            ConnectionSource connection = DatabaseConnection.getConnectionSource();
            this.daoUsuario = DaoManager.createDao(connection, Usuario.class);
            TableUtils.createTableIfNotExists(connection, Usuario.class);
        } catch (Exception e){
            throw new RuntimeException("Erro ao inicializar DAO Usuario.", e);
        }
    }
    
    public void cadastrar(Usuario usuario){
        try {
            this.daoUsuario.create(usuario);
        } catch (Exception e){
            throw new RuntimeException("Erro ao salvar usuario.", e);
        }
    }
    

    public List<Usuario> buscarPorUsuario(String userName){
        List<Usuario> usuarios;
        try{
            usuarios = daoUsuario.queryForEq("nomeUsuario", userName);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar usuario.", e);
        }
        return usuarios;
    }
    
    public List<Usuario> buscarPorEmail(String email){
        List<Usuario> usuarios;
        try{
            usuarios = daoUsuario.queryForEq("enderecoEmail", email);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar usuario.", e);
        }
        return usuarios;
    }
}