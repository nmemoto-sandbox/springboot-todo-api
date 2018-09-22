package jp.nmemoto.todo.domain.service;

import jp.nmemoto.todo.api.v1.dto.UserDTO;
import jp.nmemoto.todo.domain.model.User;
import jp.nmemoto.todo.domain.repository.UserRepository;
import jp.nmemoto.todo.lib.LoginUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(UserDTO userDTO) {
        String password = bCryptPasswordEncoder.encode(userDTO.getPassword());
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(LoginUser::new).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
