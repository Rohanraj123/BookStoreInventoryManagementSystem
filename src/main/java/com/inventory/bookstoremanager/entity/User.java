package com.inventory.bookstoremanager.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class User implements UserDetails {
    private int id;
    private String username;
    private String password;
    private String email;

    /** equals() method for external usage.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    /** hashCode() method to convert the values to their hash values.*/
    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }

    /** String representation of Object.*/
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     *
     * @return List of permissions assigned to the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     *
     * @return Boolean value that shows account expiry status
     */
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    /**
     *
     * @return Boolean value that shows account locked status
     */
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    /**
     *
     * @return Boolean value that shows credentials status
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    /**
     *
     * @return Boolean value that shows user status
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
