package oleg.mikheev.currencyapp.common.security;

import oleg.mikheev.currencyapp.common.service.service.UserService;
import oleg.mikheev.currencyapp.data.entity.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Oleg on 30.08.2017.
 *
 * @see UserDetails
 * fpr Spring Security
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	private final transient Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isNotBlank(username)) {
			User user = userService.getByLogin(username.toLowerCase());
			if (user != null) {
				UserDetailsImpl result = new UserDetailsImpl(user);
				return result;
			} else
				throw new UsernameNotFoundException("User not found!");
		}
		throw new UsernameNotFoundException("User not found!");
	}
}
