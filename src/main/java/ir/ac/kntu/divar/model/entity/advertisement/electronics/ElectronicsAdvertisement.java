package ir.ac.kntu.divar.model.entity.advertisement.electronics;

import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "ELECTRONICS")
@Entity(name = "Electronics")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ElectronicsAdvertisement extends Advertisement {
    private Double price;
}
