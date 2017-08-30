package oleg.mikheev.currencyapp.web.controller;

import oleg.mikheev.currencyapp.common.security.UserDetailsImpl;
import oleg.mikheev.currencyapp.common.service.service.UserService;
import oleg.mikheev.currencyapp.data.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 20.05.2017.
 */
@Controller("baseController")
public class BaseController {

    @Autowired
    private UserService userService;

    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    public ModelAndView show403Page() {
        return new ModelAndView("403");
    }

    public ModelAndView show404Page() {
        return new ModelAndView("404");
    }

    public ModelAndView show500Page() {
        return new ModelAndView("500");
    }

    protected User getCurrentUser() {
        updateUserInfo();
        UserDetailsImpl details = getCurrentUserDetails();
        return details == null ? null : details.getUser();
    }

    private void updateUserInfo() {
        UserDetailsImpl details = getCurrentUserDetails();
        if (details != null && details.getUser() != null) {
            User user = userService.getById(details.getUser().getId());
            details.setUser(user);
        }
    }

    private UserDetailsImpl getCurrentUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            final Object principal = auth.getPrincipal();
            if (principal != null && principal instanceof UserDetailsImpl)
                return (UserDetailsImpl) principal;
            else
                return null;
        }
        return null;
    }
}
