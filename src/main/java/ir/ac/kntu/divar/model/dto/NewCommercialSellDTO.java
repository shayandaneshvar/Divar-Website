package ir.ac.kntu.divar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewCommercialSellDTO {
    private String city, zone, title, description, mobile,advertiser;
    private Integer rooms, area, price;
    private Boolean hasDocument;
}
