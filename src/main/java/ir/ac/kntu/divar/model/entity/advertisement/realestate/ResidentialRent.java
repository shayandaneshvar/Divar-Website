package ir.ac.kntu.divar.model.entity.advertisement.realestate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "RESIDENTIAL_RENT")
@Entity(name = "ResidentialRent")
@EqualsAndHashCode(callSuper = true)
public class ResidentialRent extends RealEstateAdvertisement {
    private Double rent;
    private Double deposit;
}
