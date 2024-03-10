package ra.com.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


/**
 *
 * @author User
 */
@Entity
@Table(name = "`duration`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "duration_id", unique = true, nullable = false)
    private Integer durationId;

    @Basic(optional = false)
    @Column(name = "duration_value", unique = true, nullable = false)
    private int durationValue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "durationId")
    @JsonIgnore
    private Collection<Exam> examCollection;
}
