package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;


/**
 *
 * @author User
 */
@Entity
@Table(name = "code_examination")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_examination_id", unique = true, nullable = false)
    private Integer codeExaminationId;

    @Column(name = "status")
    @ColumnDefault("true")
    private Boolean status;

    @JoinColumn(name = "examination_id", referencedColumnName = "examination_id", nullable = false)
    @ManyToOne(optional = false)
    private Examination examinationId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeExaminationId")
    private Collection<ResultExam> resultExamCollection;

    @Basic(optional = false)
    @Column(name = "is_deleted")
    @ColumnDefault("0")
    private boolean isDeleted;
}
