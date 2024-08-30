package ijse.lk.backend_possystem_javaee.dao;

import ijse.lk.backend_possystem_javaee.dao.custom.impl.CustomerDAOImpl;
import ijse.lk.backend_possystem_javaee.dao.custom.impl.ItemDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS
    }

    public SuperDAO getDAO(DAOTypes daoType){
        switch (daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
//            case ORDER:
//                return new OrderDAOImpl();
//            case ORDER_DETAILS:
//                return new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
