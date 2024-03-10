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
@Table(name = "type", uniqueConstraints = @UniqueConstraint(columnNames = "type_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_id", unique = true, nullable = false)
    private Integer typeId;

    @Basic(optional = false)
    @Column(name = "type_name", unique = true, nullable = false, length = 50)
    private String typeName;

    @Basic(optional = false)
    @Column(name = "type_name_search", unique = true, nullable = false, length = 101)
    private String typeNameSearch;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    @JsonIgnore
    private Collection<AccountExamination> accountExaminationCollection;
}
