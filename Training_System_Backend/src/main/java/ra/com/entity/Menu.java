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
@Table(name = "menu", uniqueConstraints = { @UniqueConstraint(columnNames = "menu_link"),
        @UniqueConstraint(columnNames = "menu_name") })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id", unique = true, nullable = false)
    private Integer menuId;

    @Basic(optional = false)
    @Column(name = "icon_css", nullable = false, length = 200)
    private String iconCss;

    @Basic(optional = false)
    @Column(name = "menu_name", unique = true, nullable = false, length = 200)
    private String menuName;

    @Basic(optional = false)
    @Column(name = "menu_link", unique = true, nullable = false, length = 200)
    private String menuLink;

    @JoinTable(name = "menu_role", joinColumns = {
            @JoinColumn(name = "menu_id", referencedColumnName = "menu_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    @ManyToMany
    @JsonIgnore
    private Collection<Role> roleCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuId")
    private Collection<SubMenu> subMenuCollection;
}
