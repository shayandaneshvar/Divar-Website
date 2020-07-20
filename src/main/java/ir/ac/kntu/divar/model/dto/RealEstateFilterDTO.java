package ir.ac.kntu.divar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateFilterDTO {
    private Boolean withImageOnly,urgentOnly,personal,realEstate;
    private String zone;
}
