package ir.ac.kntu.divar.model.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDTO {
    private String city, zone, title, description, mobile, model, forRent,
            advertiser, hasDocument, isTablet, brand, picture;
    private Integer price, productionYear, kilometerage, rooms, area, rent,
            prepayment;
}
