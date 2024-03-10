package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;


/**
 *
 * @author User
 */
@Entity
@Table(name = "level_question", uniqueConstraints = @UniqueConstraint(columnNames = "level_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "level_id", unique = true, nullable = false)
    private Integer levelId;

    @Basic(optional = false)
    @Column(name = "level_name", unique = true, nullable = false, length = 50)
    private String levelName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    @JsonIgnore
    private Collection<Question> questionCollection;

    @Basic(optional = false)
    @Column(name = "level_name_search", unique = true, nullable = false, length = 101)
    private String levelNameSearch;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    @JsonIgnore
    private List<QuestionCLone> questionCloneCollection;
}
