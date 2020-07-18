package ir.ac.kntu.divar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "User")
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity<Long> {
    @NotBlank
    @Basic(optional = false)
    @Column(length = 15)
    private String mobile;
    @OneToOne
    @JoinColumn(name = "divar_id")
    private Divar divar;
}