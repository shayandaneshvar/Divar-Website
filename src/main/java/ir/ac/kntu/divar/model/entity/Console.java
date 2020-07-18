package ir.ac.kntu.divar.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "CONSOLE")
@Entity(name = "Console")
@EqualsAndHashCode(callSuper = true)
public class Console extends Computer {
}
