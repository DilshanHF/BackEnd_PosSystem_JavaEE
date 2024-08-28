package ijse.lk.backend_possystem_javaee.entity;

import lombok.*;

@NoArgsConstructor
@Data
@ToString
@Getter
@AllArgsConstructor
@Setter

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private Integer contact;
}
