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
@Table(name = "position", uniqueConstraints = @UniqueConstraint(columnNames = "position_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "position_id", unique = true, nullable = false)
    private Integer positionId;

    @Basic(optional = false)
    @Column(name = "position_name", unique = true, nullable = false, length = 50)
    private String positionName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionId")
    @JsonIgnore
    private Collection<Account> accountCollection;

    @Basic(optional = false)
    @Column(name = "position_name_search", unique = true, nullable = false, length = 101)
    private String positionNameSearch;
}
