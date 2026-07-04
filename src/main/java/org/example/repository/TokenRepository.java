package org.example.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.example.database.DatabaseConnection;
import org.example.model.Mesa;
import org.example.model.TokenEntity;

import java.util.List;

public class TokenRepository {

    private Dao<TokenEntity, Integer> tokenDao;

    public TokenRepository() {
        try {
            ConnectionSource connection = DatabaseConnection.getConnectionSource();
            this.tokenDao = DaoManager.createDao(connection, TokenEntity.class);
            TableUtils.createTableIfNotExists(connection, TokenEntity.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inicializar DAO Token.", e);
        }
    }

    public void salvar(TokenEntity token) {
        try {
            this.tokenDao.createOrUpdate(token);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar token.", e);
        }
    }

    public List<TokenEntity> buscarPorMesa(Mesa mesa) {
        try {
            return this.tokenDao.queryForEq("mesa_id", mesa.getId());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar tokens da mesa.", e);
        }
    }

    public void excluir(TokenEntity token) {
        try {
            this.tokenDao.delete(token);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir token.", e);
        }
    }

    public void excluirTodosDaMesa(Mesa mesa) {
        try {
            List<TokenEntity> tokensDaMesa = buscarPorMesa(mesa);
            this.tokenDao.delete(tokensDaMesa);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir tokens da mesa.", e);
        }
    }
}
