package ro.bogdancoseru.ecommercerestapi.entity.user;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * This is the Role entity class
 *
 * @author Coseru Ionut Bogdan
 */

@NoArgsConstructor
@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role implements Serializable{

    @Id
    @Column(updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    public Role(RoleName roleName){
        this.name = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getId() == role.getId() && getName() == role.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
