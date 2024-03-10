package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


/**
 *
 * @author User
 */
@Entity
@Table(name = "tag", uniqueConstraints = @UniqueConstraint(columnNames = "tag_name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tag_id", unique = true, nullable = false)
    private Integer tagId;

    @Basic(optional = false)
    @Column(name = "tag_name", unique = true, nullable = false, length = 50)
    private String tagName;

    @JoinTable(name = "tag_question", joinColumns = {
            @JoinColumn(name = "tag_id", referencedColumnName = "tag_id", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false, updatable = false) })
    @ManyToMany
    @JsonIgnore
    private Collection<Question> questionCollection;

    @Basic(optional = false)
    @Column(name = "tag_name_search", unique = true, nullable = false, length = 101)
    private String tagNameSearch;
}
