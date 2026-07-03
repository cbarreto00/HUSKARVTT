package org.example.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.example.database.DatabaseConnection;
import org.example.model.Mesa;
import java.util.List;

public class MesaRepository {

    private Dao<Mesa, Integer> mesaDao;

    public MesaRepository(){
        try{
            ConnectionSource connection = DatabaseConnection.getConnectionSource();
            this.mesaDao = DaoManager.createDao(connection, Mesa.class);
            TableUtils.createTableIfNotExists(connection, Mesa.class);
        } catch (Exception e){
            throw new RuntimeException("Erro ao inicializar DAO Mesa.", e);
        }
    }

    public void salvar(Mesa mesa){
        try {
            this.mesaDao.createOrUpdate(mesa);
        } catch (Exception e){
            throw new RuntimeException("Erro ao salvar mesa.", e);
        }
    }

    public List<Mesa> buscarTodas(){
        try{
            return this.mesaDao.queryForAll();
        } catch (Exception e){
            throw new RuntimeException("Erro ao buscar mesas.", e);
        }
    }

}
