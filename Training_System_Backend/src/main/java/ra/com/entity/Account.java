package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_id", unique = true, nullable = false)
    private Integer accountId;

    @Basic(optional = false)
    @Column(name = "create_date", nullable = false, length = 10, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Basic(optional = false)
    @Column(name = "fullname", nullable = false, length = 50)
    private String fullname;

    @Basic(optional = false)
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private Collection<Question> questionCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<GroupAccount> groupAccountCollection;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AccountExamination> accountExaminationCollection;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private Collection<Exam> examCollection;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private Collection<CategoryQuestion> categoryQuestionCollection;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<ResultExam> resultExamCollection;

    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    @ManyToOne(optional = false)
    private Department departmentId;

    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    @ManyToOne(optional = false)
    private Position positionId;

    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    @JsonIgnore
    private Collection<Group> groupCollection;

    @Basic(optional = false)
    @Column(name = "fullname_search", nullable = false, length = 101)
    private String fullnameSearch;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    @JsonIgnore
    private List<QuestionCLone> questionCloneCollection;

}
