package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.repositories.UserReposiory;

/**
 * Created by adrian on 04.05.17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    protected UserReposiory userReposiory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
