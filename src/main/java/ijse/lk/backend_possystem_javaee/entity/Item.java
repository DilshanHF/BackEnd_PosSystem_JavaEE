package ijse.lk.backend_possystem_javaee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Item implements Serializable {
    private String id;
    private String description;
    private Double unitPrice;
    private int qty;

}
