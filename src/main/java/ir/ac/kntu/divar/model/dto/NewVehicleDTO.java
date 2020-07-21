package ir.ac.kntu.divar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewVehicleDTO {
    private String city, zone, title, description, mobile, model, forRent;
    private Integer price, productionYear,kilometerage;
}
