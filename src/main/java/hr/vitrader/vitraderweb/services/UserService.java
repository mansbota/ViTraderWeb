package hr.vitrader.vitraderweb.services;

import hr.vitrader.vitraderweb.dto.RegisterDTO;
import hr.vitrader.vitraderweb.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(RegisterDTO register);

    UserDTO getUser(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO updatedUser, Long userId);

    void deleteUser(Long userId);
}
