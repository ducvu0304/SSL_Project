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
@Table(name = "category_question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id", unique = true, nullable = false)
    private Integer categoryId;

    @Basic(optional = false)
    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

    @Basic(optional = false)
    @Column(name = "category_code", nullable = false, length = 10)
    private String categoryCode;

    @Basic(optional = false)
    @Column(name = "create_date", length = 10, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Question> questionCollection;

    @JoinColumn(name = "creator_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    private Account creatorId;

    @Basic(optional = false)
    @Column(name = "category_name_search", unique = true, nullable = false, length = 101)
    private String categoryNameSearch;

    @Basic(optional = false)
    @Column(name = "is_deleted", insertable = false)
    @ColumnDefault("0")
    private boolean isDeleted;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Exam> examCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    @JsonIgnore
    private List<QuestionCLone> questionCloneCollection;
}
