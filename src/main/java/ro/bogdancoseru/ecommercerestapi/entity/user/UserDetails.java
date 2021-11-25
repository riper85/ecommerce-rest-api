package ro.bogdancoseru.ecommercerestapi.entity.user;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_details")
public class UserDetails implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Size(max = 255)
    private String phone;

    @Size(max = 255)
    private String address;

    @NotNull
    private int age;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private User user;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDetails.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("phone='" + phone + "'")
                .add("address='" + address + "'")
                .add("age=" + age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetails)) return false;
        UserDetails that = (UserDetails) o;
        return getId() == that.getId() && getAge() == that.getAge() && getPhone().equals(that.getPhone()) && getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhone(), getAddress(), getAge());
    }
}
