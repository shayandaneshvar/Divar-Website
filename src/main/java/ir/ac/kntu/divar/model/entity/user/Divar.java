package ir.ac.kntu.divar.model.entity.user;

import ir.ac.kntu.divar.model.entity.BaseEntity;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "DIVAR")
@Entity(name = "Divar")
@EqualsAndHashCode(callSuper = false)
public class Divar extends BaseEntity<Long> {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_ads", inverseJoinColumns = @JoinColumn(name = "ad_id"))
    private List<Advertisement> userAdvertisements = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "marked_ads", inverseJoinColumns = @JoinColumn(name = "ad_id"))
    private List<Advertisement> markedAdvertisements = null;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recent_ads", inverseJoinColumns = @JoinColumn(name = "ad_id"))
    private List<Advertisement> recentAdvertisements = null;

}
