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
@Table(name = "config")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "config_id", unique = true, nullable = false)
    private Integer configId;

    @Basic(optional = false)
    @Column(name = "config_name", unique = true, nullable = false, length = 200)
    private String configName;

    @Basic(optional = false)
    @Column(name = "config_value", nullable = false, length = 200)
    private String configValue;
}
