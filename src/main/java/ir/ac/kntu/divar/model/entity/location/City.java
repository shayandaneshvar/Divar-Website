package ir.ac.kntu.divar.model.entity.location;

import ir.ac.kntu.divar.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Data
@Entity(name = "City")
@Table(name = "CITY")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class City extends BaseEntity<Long> {
    @NotBlank
    @Basic(optional = false)
    @Column(length = 40,name = "_name",unique = true)
    private String name;
}
