package oleg.mikheev.currencyapp.common.security;

import oleg.mikheev.currencyapp.data.entity.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Oleg on 30.08.2017.
 *
 * @see User
 * for Spring Security
 */
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -463171786540643549L;
	private User user;
	private String accessToken;

	private final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	private final transient Logger logger = LoggerFactory.getLogger(getClass());

	public UserDetailsImpl(User user) {
		setUser(user);
		setUserAuthorities("ROLE_USER");
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public final void setUserAuthorities(String userRoles) {
		authorities.clear();
		if (StringUtils.isNotBlank(userRoles)) {
			String[] roles = userRoles.split(",");
			for (final String role : roles) {
				final GrantedAuthority authority = new SimpleGrantedAuthority(role);
				authorities.add(authority);
			}
		} else
			throw new BadCredentialsException(String.format("User [id=%d] has no any roles.", user.getId()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
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
		return user.getActive();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getId() {
		return user == null ? null : user.getId();
	}

}
