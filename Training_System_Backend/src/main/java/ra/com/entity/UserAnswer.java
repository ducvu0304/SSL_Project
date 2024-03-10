package ra.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_answer_id", unique = true, nullable = false)
    private Integer userAnswerId;

    @Basic(optional = false)
    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @JoinColumn(name = "result_exam_id", referencedColumnName = "result_exam_id", nullable = false)
    @ManyToOne(optional = false)
    private ResultExam resultExamId;

    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
    @ManyToOne(optional = false)
    private Question questionId;

    @Basic(optional = false)
    @Column(name = "content_search", nullable = false, length = 1001)
    private String contentSearch;
}
