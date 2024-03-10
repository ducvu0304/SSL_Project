package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_examination", uniqueConstraints = @UniqueConstraint(columnNames = {
        "examination_id", "account_id", "type_id" }))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_examination_id", unique = true, nullable = false)
    private Integer accountExaminationId;

    @JoinColumn(name = "examination_id", referencedColumnName = "examination_id", nullable = false)
    @ManyToOne(optional = false)
    private Examination examinationId;

    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne(optional = false)
    private Account accountId;

    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    @ManyToOne(optional = false)
    private Type typeId;
}
