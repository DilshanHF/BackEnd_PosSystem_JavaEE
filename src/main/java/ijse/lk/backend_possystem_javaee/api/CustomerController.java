package ijse.lk.backend_possystem_javaee.api;

import ijse.lk.backend_possystem_javaee.bo.BOFactory;
import ijse.lk.backend_possystem_javaee.bo.custom.CustomerBO;
import ijse.lk.backend_possystem_javaee.dto.CustomerDto;
import jakarta.json.JsonException;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/customer" )
public class CustomerController extends HttpServlet {

    JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    private Connection connection;
    Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

    @Override
    public void init() {

        logger.info("init the customer servlet");

        try {
            InitialContext initialContext = new InitialContext();
            DataSource pool = (DataSource) initialContext.lookup("java:comp/env/jdbc/javaee");
            this.connection = pool.getConnection();
        } catch (NamingException| SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")){

            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
            /*customerDto.setCustomerId("23");*/
            System.out.println(customerDto);

            try {
                if (customerBO.createCustomer(customerDto,connection)){
                    logger.info("Customer created");
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }else {
                    logger.error("Customer not created");
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }


        }else {
            logger.error("Did not contain json");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("come to put method");


        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")){
            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

            System.out.println(customerDto);

            try {
                if(customerBO.updateCustomer(customerDto,connection)){
                    logger.info("Customer updated");
                    resp.setStatus(HttpServletResponse.SC_OK);

                }else {
                    logger.error("Customer not updated");
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else {
            logger.error("Did not contain json");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }



    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Entered doDelete method");

        // Parse the incoming JSON request to extract customer details
        CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

        if (customerDto == null || customerDto.getId() == null) {
            logger.error("Invalid customer data provided for deletion");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            // Attempt to delete the customer from the database
            boolean isDeleted = customerBO.deleteCustomer(customerDto.getId(), connection);

            if (isDeleted) {
                logger.info("Customer deleted successfully with ID: " + customerDto.getId());
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                logger.warn("Customer with ID: " + customerDto.getId() + " not found or could not be deleted");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (SQLException e) {
            logger.error("SQL Exception occurred while deleting customer with ID: " + customerDto.getId(), e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while deleting customer with ID: " + customerDto.getId(), e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }




}
