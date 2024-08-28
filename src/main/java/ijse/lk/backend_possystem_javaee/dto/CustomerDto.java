package ijse.lk.backend_possystem_javaee.dto;


import lombok.*;

@NoArgsConstructor
@Data
@ToString
@Getter
@AllArgsConstructor
@Setter

public class CustomerDto {

    private String customerId;
    private String name;
    private String address;
    private Integer contact;

}
