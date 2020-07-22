package ir.ac.kntu.divar.model.entity.user;

import ir.ac.kntu.divar.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "User")
@Table(name = "USER")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity<Long> {
    @NotBlank
    @Basic(optional = false)
    @Column(length = 15)
    private String mobile;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "divar_id")
    private Divar divar;
}
