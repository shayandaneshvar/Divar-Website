package ir.ac.kntu.divar.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "RESIDENTIAL_SELL")
@Entity(name = "ResidentialSell")
@EqualsAndHashCode(callSuper = true)
public class ResidentialSell extends RealEstateAdvertisement {
    private Double price;
}
