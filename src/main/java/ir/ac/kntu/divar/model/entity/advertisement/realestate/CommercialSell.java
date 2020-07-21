package ir.ac.kntu.divar.model.entity.advertisement.realestate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "COMMERCIAL_SELL")
@Entity(name = "CommercialSell")
@EqualsAndHashCode(callSuper = true)
public class CommercialSell extends RealEstateAdvertisement {
    private Double price;
    private Boolean legalInstrument;
}
