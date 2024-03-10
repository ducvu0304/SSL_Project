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
@Table(name = "result_exam")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "result_exam_id", unique = true, nullable = false)
    private Integer resultExamId;

    @Basic(optional = false)
    @Column(name = "total_mark_essay", nullable = false, precision = 12, scale = 0)
    private float totalMarkEssay;

    @Basic(optional = false)
    @Column(name = "total_mark_multiple_choice", nullable = false, precision = 12, scale = 0)
    private float totalMarkMultipleChoice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultExamId")
    @JsonIgnore
    private Collection<UserAnswer> userAnswerCollection;

    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id", nullable = false)
    @ManyToOne(optional = false)
    private Exam examId;

    @JoinColumn(name = "code_examination_id", referencedColumnName = "code_examination_id", nullable = false)
    @ManyToOne(optional = false)
    private CodeExamination codeExaminationId;

    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    private Account accountId;
}

