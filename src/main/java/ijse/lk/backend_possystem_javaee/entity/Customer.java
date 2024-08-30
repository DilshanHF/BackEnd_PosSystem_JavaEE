package ijse.lk.backend_possystem_javaee.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Data
@ToString
@Getter
@AllArgsConstructor
@Setter

public class Customer implements Serializable {
    private String id;
    private String name;
    private String address;
    private Integer contact;
}
