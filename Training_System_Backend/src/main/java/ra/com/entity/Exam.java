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
@Table(name = "exam")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exam_id", unique = true, nullable = false)
    private Integer examId;

    @Basic(optional = false)
    @Column(name = "code", length = 50)
    private String code;

    @Basic(optional = false)
    @Column(name = "create_date", length = 10, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Basic(optional = false)
    @Column(name = "is_assign")
    private boolean isAssign;

    @Basic(optional = false)
    @Column(name = "note", length = 500)
    private String note;

    @Basic(optional = false)
    @Column(name = "number_of_question")
    @ColumnDefault("0")
    private int numberOfQuestion;

    @JoinColumn(name = "duration_id", referencedColumnName = "duration_id", nullable = false)
    @ManyToOne(optional = false)
    private Duration durationId;

    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Basic(optional = false)
    @Column(name = "total_score", precision = 12, scale = 0)
    @ColumnDefault("0")
    private float totalScore;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examId")
    private Collection<ExamQuestionClone> examQuestionCloneCollection;

    @JoinColumn(name = "status_id", referencedColumnName = "status_id", insertable = false)
    @ManyToOne(optional = false)
    private StatusExam statusId;

    @JoinColumn(name = "creator_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    private Account creatorId;

    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryQuestion categoryId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examId")
    @JsonIgnore
    private Collection<ResultExam> resultExamCollection;

    @Basic(optional = false)
    @Column(name = "title_search", nullable = false, length = 401)
    private String titleSearch;

    @Basic(optional = false)
    @Column(name = "is_deleted")
    @ColumnDefault("0")
    private boolean isDeleted;
}
