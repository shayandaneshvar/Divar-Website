package ir.ac.kntu.divar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewCommercialSellDTO {
    private String city, zone, title, hasDocument, description, mobile,
            advertiser;
    private Integer rooms, area, price;
}
