package ijse.lk.backend_possystem_javaee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto implements Serializable {
    private String id;
    private String description;
    private Double unitPrice;
    private int qty;
}
