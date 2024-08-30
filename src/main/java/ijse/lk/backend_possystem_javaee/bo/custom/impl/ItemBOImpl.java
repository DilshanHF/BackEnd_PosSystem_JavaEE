package ijse.lk.backend_possystem_javaee.bo.custom.impl;

import ijse.lk.backend_possystem_javaee.bo.custom.ItemBO;
import ijse.lk.backend_possystem_javaee.dao.DAOFactory;
import ijse.lk.backend_possystem_javaee.dao.custom.ItemDAO;
import ijse.lk.backend_possystem_javaee.dao.custom.impl.ItemDAOImpl;
import ijse.lk.backend_possystem_javaee.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean createItem(ItemDto itemDTO, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto itemDTO, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItem(String itemId, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public List<ItemDto> getAllItems(Connection connection) throws SQLException {
        return List.of();
    }
}
