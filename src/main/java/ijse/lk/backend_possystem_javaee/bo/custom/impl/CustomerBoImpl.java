package ijse.lk.backend_possystem_javaee.bo.custom.impl;

import ijse.lk.backend_possystem_javaee.bo.custom.CustomerBO;
import ijse.lk.backend_possystem_javaee.dao.DAOFactory;
import ijse.lk.backend_possystem_javaee.dao.custom.CustomerDAO;
import ijse.lk.backend_possystem_javaee.dto.CustomerDto;
import ijse.lk.backend_possystem_javaee.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

public class CustomerBoImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);


    @Override
    public boolean createCustomer(CustomerDto customerDTO, Connection connection) throws SQLException {
       return customerDAO.save(connection,
               new Customer(customerDTO.getCustomerId(),
                       customerDTO.getName(),
                       customerDTO.getAddress(),
                       customerDTO.getContact()
                       )
               );
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDTO, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String customerId, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) throws SQLException {
        return List.of();
    }
}
