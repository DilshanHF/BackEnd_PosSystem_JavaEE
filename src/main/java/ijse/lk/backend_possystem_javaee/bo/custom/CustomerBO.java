package ijse.lk.backend_possystem_javaee.bo.custom;

import ijse.lk.backend_possystem_javaee.bo.SuperBo;
import ijse.lk.backend_possystem_javaee.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBo {
    boolean createCustomer(CustomerDto customerDTO, Connection connection) throws SQLException;

    boolean updateCustomer(CustomerDto customerDTO, Connection connection) throws SQLException;

    boolean deleteCustomer(String customerId, Connection connection) throws SQLException;

    List<CustomerDto> getAllCustomers(Connection connection) throws SQLException;
}
