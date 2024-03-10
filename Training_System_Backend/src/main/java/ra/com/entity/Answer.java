package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answer_id", unique = true, nullable = false)
    private Integer answerId;

    @Basic(optional = false)
    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Basic(optional = false)
    @Column(name = "is_correct")
    private Boolean isCorrect;

    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Question questionId;

    @Basic(optional = false)
    @Column(name = "content_search", nullable = false, length = 1001)
    private String contentSearch;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answerId")
    @JsonIgnore
    private Collection<AnswerClone> answerCloneCollection;

}
