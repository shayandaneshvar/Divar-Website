package ir.ac.kntu.divar.model.entity.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "REAL_ESTATE")
@Entity(name = "RealEstate")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public abstract class RealEstateAdvertisement extends Advertisement {
    private Double area;
    @Enumerated(EnumType.STRING)
    private AdvertiserType type;
    private Integer rooms;


    public enum AdvertiserType {REAL_ESTATE, PERSONAL}
}
