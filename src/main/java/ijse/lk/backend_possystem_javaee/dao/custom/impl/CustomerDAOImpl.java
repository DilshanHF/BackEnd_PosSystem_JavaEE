package ijse.lk.backend_possystem_javaee.dao.custom.impl;

import ijse.lk.backend_possystem_javaee.dao.SQLUtil;
import ijse.lk.backend_possystem_javaee.dao.custom.CustomerDAO;
import ijse.lk.backend_possystem_javaee.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static final String GET_QUERY = "SELECT * FROM customer";
    private static final String SAVE_QUERY = "INSERT INTO customer(customerId, name, address, contact) VALUES (?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE customer SET name = ?, address = ?, contact = ? WHERE customerId = ?";
    private static final String DELETE_QUERY = "DELETE FROM customer WHERE customerId = ?";

    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        return List.of();
    }

    @Override
    public boolean save(Connection connection, Customer dto) throws SQLException {
        return SQLUtil.execute(connection,
                SAVE_QUERY,
                dto.getCustomerId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
                );
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
