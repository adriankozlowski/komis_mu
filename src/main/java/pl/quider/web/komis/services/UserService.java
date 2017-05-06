package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.UserDto;
import pl.quider.web.komis.models.User;
import pl.quider.web.komis.repositories.RoleRepository;
import pl.quider.web.komis.repositories.UserReposiory;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adrian on 06.05.17.
 */
@Service
public class UserService {
    @Autowired
    private UserReposiory userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     *
     * @param user
     */
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    /**
     *
     */
    public void createNewUserIfNooneExists() {
        long count = userRepository.count();
        if (count == 0 ){
            User user = new User();
            user.setUsername("admin");
            user.setPassword("password");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRoles(new HashSet<>(roleRepository.findAll()));
            userRepository.save(user);
        }
    }

    /**
     *
     * @return
     */
    public List<UserDto> getAll() {
        List<User> all = userRepository.findAll();
        return all.stream().map(this::mapUsers).collect(Collectors.toList());
    }

    /**
     *
     * @param user
     * @return
     */
    private UserDto mapUsers(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setId(user.getId());
        dto.setModified(user.getModified());
        dto.setAdded(user.getAdded());
        return  dto;
    }
}
