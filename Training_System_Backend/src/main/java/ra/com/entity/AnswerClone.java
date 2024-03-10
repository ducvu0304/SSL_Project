package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "answer_clone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerClone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answer_clone_id", unique = true, nullable = false)
    private Integer answerCloneId;

    @Basic(optional = false)
    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Basic(optional = false)
    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    @Basic(optional = false)
    @Column(name = "content_search", nullable = false, length = 1001)
    private String contentSearch;

    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id", nullable = false)
    @ManyToOne(optional = false)
    private Answer answerId;

    @JoinColumn(name = "question_clone_id", referencedColumnName = "question_clone_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private QuestionCLone questionCloneId;
}
