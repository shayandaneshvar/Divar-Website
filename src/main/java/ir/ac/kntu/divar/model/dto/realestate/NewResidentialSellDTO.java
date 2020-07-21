package ir.ac.kntu.divar.model.dto.realestate;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewResidentialSellDTO {
    private String city, zone, title, description, mobile,advertiser;
    private Integer rooms, area, price;
}
