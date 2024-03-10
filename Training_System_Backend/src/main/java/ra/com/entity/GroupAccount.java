package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "group_account", uniqueConstraints = @UniqueConstraint(columnNames = { "group_id",
        "account_id" }))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_account_id", unique = true, nullable = false)
    private Integer groupAccountId;

    @Basic(optional = false)
    @Column(name = "join_date", nullable = false, length = 10, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Account accountId;

    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Group groupId;
}
