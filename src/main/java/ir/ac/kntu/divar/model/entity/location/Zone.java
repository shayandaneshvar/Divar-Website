package ir.ac.kntu.divar.model.entity.location;

import ir.ac.kntu.divar.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity(name = "Zone")
@Table(name = "ZONE")
@EqualsAndHashCode(callSuper = false)
public class Zone extends BaseEntity<Long> {
    @Basic(optional = false)
    @Column(length = 30,name = "_name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "city_id")
    private City city;
}
