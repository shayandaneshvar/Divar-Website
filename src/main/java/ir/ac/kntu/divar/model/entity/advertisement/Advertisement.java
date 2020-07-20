package ir.ac.kntu.divar.model.entity.advertisement;

import ir.ac.kntu.divar.model.entity.BaseEntity;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Advertisement")
@Table(name = "ADVERTISEMENT")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Advertisement extends BaseEntity<Long> {
    private String picture;
    @Column(length = 15)
    private String mobile;
    @Column(length = 100)
    private String title;
    private Boolean exchange;
    private Boolean urgent;
    private String description;
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "city_id")
    private City city;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_id")
    private Zone zone;

    private Boolean hasImage;
    @Enumerated(EnumType.STRING)
    private Type adType;

    public enum Type {
        REQUESTED, ON_SALE
    }
}
