package ijse.lk.backend_possystem_javaee.bo.custom;

import ijse.lk.backend_possystem_javaee.bo.SuperBo;
import ijse.lk.backend_possystem_javaee.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBo {
    boolean createItem(ItemDto itemDTO, Connection connection) throws SQLException;

    boolean updateItem(ItemDto itemDTO, Connection connection) throws SQLException;

    boolean deleteItem(String itemId, Connection connection) throws SQLException;

    List<ItemDto> getAllItems(Connection connection) throws SQLException;
}
