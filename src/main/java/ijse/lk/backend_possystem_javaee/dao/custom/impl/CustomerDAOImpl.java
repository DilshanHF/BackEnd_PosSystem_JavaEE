package ijse.lk.backend_possystem_javaee.dao.custom.impl;

import ijse.lk.backend_possystem_javaee.dao.custom.CustomerDAO;
import ijse.lk.backend_possystem_javaee.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        return List.of();
    }

    @Override
    public boolean save(Connection connection, Customer dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Connection connection, Customer dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String s) throws SQLException {
        return false;
    }
}
