package ra.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the role_permission database table.
 *
 */
@Entity
@Table(name = "role_permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int enable;

    // bi-directional many-to-one association to Permission
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    // bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
