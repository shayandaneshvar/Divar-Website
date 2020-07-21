package ir.ac.kntu.divar.model.entity.advertisement.electronics;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "MOBILE")
@Entity(name = "Mobile")
@EqualsAndHashCode(callSuper = true)
public class Mobile extends ElectronicsAdvertisement {
    @Column(length = 30)
    private String brand;
    private Boolean tablet;
}
