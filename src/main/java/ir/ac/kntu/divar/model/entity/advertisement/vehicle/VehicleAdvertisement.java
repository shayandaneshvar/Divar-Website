package ir.ac.kntu.divar.model.entity.advertisement.vehicle;

import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Table(name = "VEHICLE")
@Entity(name = "Vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public abstract class VehicleAdvertisement extends Advertisement {
    @NotBlank
    @Column(length = 30)
    private String model;
    private Double price;
    private Integer productionYear;
    private Boolean forRent;
}
