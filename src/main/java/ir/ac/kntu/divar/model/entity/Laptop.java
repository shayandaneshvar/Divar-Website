package ir.ac.kntu.divar.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "LAPTOP")
@Entity(name = "Laptop")
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Computer {
    @Column(length = 30)
    private String brand;
}
