package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;


/**
 *
 * @author User
 */
@Entity
@Table(name = "question_clone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionCLone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_clone_id", unique = true, nullable = false)
    private Integer questionCloneId;

    @Basic(optional = false)
    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "file_image", length = 255)
    private String fileImage;

    @Basic(optional = false)
    @Column(name = "create_date", nullable = false, length = 10)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Basic(optional = false)
    @Column(name = "content_search", nullable = false, length = 1001)
    private String contentSearch;

    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false)
    @ManyToOne(optional = false)
    private Question questionId;

    @JoinColumn(name = "creator_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    private Account creatorId;

    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    @ManyToOne(optional = false)
    private TypeQuestion typeId;

    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryQuestion categoryId;

    @JoinColumn(name = "level_id", referencedColumnName = "level_id", nullable = false)
    @ManyToOne(optional = false)
    private LevelQuestion levelId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionCloneId")
    private Collection<AnswerClone> answerCloneCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionCloneId")
    @JsonIgnore
    private Collection<ExamQuestionClone> examQuestionCloneCollection;
}
