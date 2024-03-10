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
@Table(name = "`group`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id", unique = true, nullable = false)
    private Integer groupId;

    @Basic(optional = false)
    @Column(name = "create_date", nullable = false, length = 10, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Basic(optional = false)
    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<GroupAccount> groupAccountCollection;

    @JoinColumn(name = "creator_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    private Account creatorId;

    @Transient
    private long numberOfMembers;

    @Basic(optional = false)
    @Column(name = "group_name_search", unique = true, nullable = false, length = 101)
    private String groupNameSearch;

    @Basic(optional = false)
    @Column(name = "is_deleted", insertable = false)
    @ColumnDefault("0")
    private boolean isDeleted;
}
