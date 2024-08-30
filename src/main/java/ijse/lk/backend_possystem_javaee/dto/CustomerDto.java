package ijse.lk.backend_possystem_javaee.dto;


import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Data
@ToString
@Getter
@AllArgsConstructor
@Setter

public class CustomerDto implements Serializable {
    @JsonbProperty("id")
    private String id;
    @JsonbProperty("name")
    private String name;
    @JsonbProperty("address")
    private String address;
    @JsonbProperty("contact")
    private Integer contact;

}
