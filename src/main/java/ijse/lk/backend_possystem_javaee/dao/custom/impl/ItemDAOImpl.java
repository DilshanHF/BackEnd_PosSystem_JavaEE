package ijse.lk.backend_possystem_javaee.dao.custom.impl;

import ijse.lk.backend_possystem_javaee.dao.custom.ItemDAO;
import ijse.lk.backend_possystem_javaee.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public List<Item> getAll(Connection connection) throws SQLException {
        return List.of();
    }

    @Override
    public boolean save(Connection connection, Item dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Connection connection, Item dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String s) throws SQLException {
        return false;
    }
}
