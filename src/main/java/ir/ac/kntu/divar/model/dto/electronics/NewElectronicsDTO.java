package ir.ac.kntu.divar.model.dto.electronics;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewElectronicsDTO {
    private String city, zone, title, description, mobile;
    private Integer price;
}
