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
@Table(name = "LAPTOP")
@Entity(name = "Laptop")
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Computer {
    @Column(length = 30)
    private String brand;
}
