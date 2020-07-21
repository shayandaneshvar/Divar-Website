package ir.ac.kntu.divar.model.entity.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "REAL_ESTATE")
@Entity(name = "RealEstate")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public abstract class RealEstateAdvertisement extends Advertisement {
    private Double area;
    @Enumerated(EnumType.STRING)
    private AdvertiserType type;
    private Integer rooms;


    public enum AdvertiserType implements Converter<String, AdvertiserType> {
        REAL_ESTATE, PERSONAL;

        @Override
        public AdvertiserType convert(String s) {
            if (s.equals("شخصی")) {
                return PERSONAL;
            }
            return REAL_ESTATE;
        }

        public static AdvertiserType converter(String s){
            return PERSONAL.convert(s);
        }
    }
}
