package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author User
 */
@Entity
@Table(name = "sub_menu", uniqueConstraints = { @UniqueConstraint(columnNames = "sub_menu_link"),
        @UniqueConstraint(columnNames = { "sub_menu_link", "sub_menu_name" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_menu_id", unique = true, nullable = false)
    private Integer subMenuId;

    @Basic(optional = false)
    @Column(name = "sub_menu_link", unique = true, nullable = false, length = 200)
    private String subMenuLink;

    @Basic(optional = false)
    @Column(name = "sub_menu_name", nullable = false, length = 200)
    private String subMenuName;

    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Menu menuId;
}
