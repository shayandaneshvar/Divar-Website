package ir.ac.kntu.divar.model.dto.electronics;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewMobileDTO {
    private String city, zone, title, description, mobile, brand,isTablet;
    private Integer price;
}
