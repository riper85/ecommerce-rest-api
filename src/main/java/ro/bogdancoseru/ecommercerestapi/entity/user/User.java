package ro.bogdancoseru.ecommercerestapi.entity.user;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * This is the User entity class
 *
 * @author Coseru Ionut Bogdan
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max=255)
    private String name;

    @Email
    @Size(max=255)
    @Column(name = "previous_email")
    private String previousEmail;

    @Email
    @Size(max=255)
    private String email;

    @NotBlank
    @Size(max=255)
    private String password;

    @OneToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserDetails userDetails;

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("previousEmail='" + previousEmail + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("role=" + role)
                .add("userDetails=" + userDetails)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getName().equals(user.getName()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword());
    }
}
