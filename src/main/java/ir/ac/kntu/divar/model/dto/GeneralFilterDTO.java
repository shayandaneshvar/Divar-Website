package ir.ac.kntu.divar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GeneralFilterDTO {
    private Boolean withImageOnly, urgentOnly, onSale, requested,
            removeNegotiation, exchangeOnly, removeExchange;
    private String zone;
    private Integer minPrice, maxPrice;
}
