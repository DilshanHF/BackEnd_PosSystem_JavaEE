package ijse.lk.backend_possystem_javaee.bo;

import ijse.lk.backend_possystem_javaee.bo.custom.impl.CustomerBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS
    }

    public SuperBo getBO(BOTypes boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBoImpl();
//            case ITEM:
//                return new ItemBOImpl();
//            case ORDER:
//                return new OrderBOImpl();
//            case ORDER_DETAILS:
//                return new OrderDetailsBOImpl();
            default:
                return null;
        }
    }
}
