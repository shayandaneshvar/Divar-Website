package ir.ac.kntu.divar.model.entity.advertisement.vehicle;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "TRUCK")
@Entity(name = "Truck")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class Truck extends VehicleAdvertisement {
    private Double kilometerage;
}
