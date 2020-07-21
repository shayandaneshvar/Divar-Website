package ir.ac.kntu.divar.model.entity.advertisement.vehicle;

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
@Table(name = "CAR")
@Entity(name = "Car")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class Car extends VehicleAdvertisement {
    private Double kilometerage;
}
