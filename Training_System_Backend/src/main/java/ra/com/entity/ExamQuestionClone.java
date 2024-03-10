package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author User
 */
@Entity
@Table(name = "exam_question_clone", uniqueConstraints = @UniqueConstraint(columnNames = {
        "exam_id", "question_clone_id" }))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamQuestionClone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exam_question_id", unique = true, nullable = false)
    private Integer examQuestionId;

    @Basic(optional = false)
    @Column(name = "score", nullable = false, precision = 12, scale = 0)
    private float score;

    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Exam examId;

    @JoinColumn(name = "question_clone_id", referencedColumnName = "question_clone_id", nullable = false)
    @ManyToOne(optional = false)
    private QuestionCLone questionCloneId;
}
