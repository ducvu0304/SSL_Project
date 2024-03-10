package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 *
 * @author User
 */
@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_id", unique = true, nullable = false)
    private Integer questionId;

    @Basic(optional = false)
    @Column(name = "content", nullable = false, length = 1500)
    private String content;

    @Basic(optional = false)
    @Column(name = "file_image", length = 255)
    private String fileImage;

    @Basic(optional = false)
    @Column(name = "create_date", nullable = false, length = 10, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToMany(mappedBy = "questionCollection")
    @JsonIgnore
    private Collection<Tag> tagCollection;

    @JoinColumn(name = "level_id", referencedColumnName = "level_id", nullable = false)
    @ManyToOne(optional = false)
    private LevelQuestion levelId;

    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryQuestion categoryId;

    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    @ManyToOne(optional = false)
    private TypeQuestion typeId;

    @JoinColumn(name = "creator_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    private Account creatorId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    @JsonIgnore
    private Collection<UserAnswer> userAnswerCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private Collection<Answer> answerCollection;

    @Basic(optional = false)
    @Column(name = "content_search", nullable = false, length = 3001)
    private String contentSearch;

    @Basic(optional = false)
    @Column(name = "is_deleted")
    @ColumnDefault("0")
    private boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    @JsonIgnore
    private List<QuestionCLone> questionCloneCollection;
}
