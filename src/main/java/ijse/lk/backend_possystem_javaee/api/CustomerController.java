package ijse.lk.backend_possystem_javaee.api;

import ijse.lk.backend_possystem_javaee.bo.BOFactory;
import ijse.lk.backend_possystem_javaee.bo.custom.CustomerBO;
import ijse.lk.backend_possystem_javaee.dto.CustomerDto;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
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


@WebServlet(name = "customer",urlPatterns = "/customer" ,loadOnStartup=5)
public class CustomerController extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    private Connection connection;
    Jsonb jsonb = JsonbBuilder.create();

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


}
