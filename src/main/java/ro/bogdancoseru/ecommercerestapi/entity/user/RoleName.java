package ro.bogdancoseru.ecommercerestapi.entity.user;

/**
 * This is the role name enum
 *
 * @author Mircea Stan
 */
public enum RoleName {
    ROLE_USER(1),
    ROLE_ADMIN(2);

    RoleName(int i) {}

    @Override
    public String toString() {
        return super.toString();
    }


}
