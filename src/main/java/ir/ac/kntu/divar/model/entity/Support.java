package ir.ac.kntu.divar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "Support")
@Table(name = "SUPPORT")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Support extends BaseEntity<Long> {
    @NotBlank
    @Column(length = 100)
    private String subject;
    @Email
    @NotBlank
    @Column(length = 100)
    private String email;
    @NotBlank
    private String description;
}
