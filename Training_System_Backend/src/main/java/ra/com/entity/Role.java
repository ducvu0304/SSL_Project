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
@Table(name = "`role`", uniqueConstraints = @UniqueConstraint(columnNames = "role_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id", unique = true, nullable = false)
    private Integer roleId;

    @Basic(optional = false)
    @Column(name = "role_name", unique = true, nullable = false, length = 50)
    private String roleName;

    @OneToMany(mappedBy = "roleId")
    @JsonIgnore
    private Collection<Account> accountCollection;

    @ManyToMany(mappedBy = "roleCollection")
    @JsonIgnore
    private Collection<Menu> menuCollection;
}
