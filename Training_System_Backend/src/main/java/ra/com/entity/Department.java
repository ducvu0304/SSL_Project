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
@Table(name = "department", uniqueConstraints = @UniqueConstraint(columnNames = "department_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "department_id", unique = true, nullable = false)
    private Integer departmentId;

    @Basic(optional = false)
    @Column(name = "department_name", unique = true, nullable = false, length = 50)
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    @JsonIgnore
    private Collection<Account> accountCollection;

    @Basic(optional = false)
    @Column(name = "department_name_search", unique = true, nullable = false, length = 101)
    private String departmentNameSearch;
}
