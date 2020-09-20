package co.com.soaint.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrimary implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
    private String userName;
    private String email;
    private String password;

    public UserPrimary(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.user = nombre;
        this.userName = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    public static UserPrimary build(User user){
        return new UserPrimary(user.getNombre(), user.getNombreUsuario(), user.getEmail(), user.getPassword(), null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }
}
