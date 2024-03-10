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
@Table(name = "status_exam", uniqueConstraints = @UniqueConstraint(columnNames = "status_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id", unique = true, nullable = false)
    private Integer statusId;

    @Basic(optional = false)
    @Column(name = "status_name", unique = true, nullable = false, length = 50)
    private String statusName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    @JsonIgnore
    private Collection<Exam> examCollection;

    @Basic(optional = false)
    @Column(name = "status_name_search", unique = true, nullable = false, length = 101)
    private String statusNameSearch;
}
