package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;
import java.util.Date;


/**
 *
 * @author User
 */
@Entity
@Table(name = "examination")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examination_id", unique = true, nullable = false)
    private Integer examinationId;

    @Basic(optional = false)
    @Column(name = "end_date", nullable = false, length = 10)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Basic(optional = false)
    @Column(name = "start_date", nullable = false, length = 10)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Basic(optional = false)
    @Column(name = "title_search", nullable = false, length = 401)
    private String titleSearch;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examinationId")
    private Collection<CodeExamination> codeExaminationCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examinationId")
    @JsonIgnore
    private Collection<AccountExamination> accountExaminationCollection;

    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false)
    @ManyToOne(optional = false)
    private StatusExamination statusId;

    @Basic(optional = false)
    @Column(name = "is_deleted")
    @ColumnDefault("0")
    private boolean isDeleted;
}
