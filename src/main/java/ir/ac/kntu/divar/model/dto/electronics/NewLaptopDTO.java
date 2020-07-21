package ir.ac.kntu.divar.model.dto.electronics;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewLaptopDTO {
    private String city, zone, title, description, mobile, brand;
    private Integer price;
}
