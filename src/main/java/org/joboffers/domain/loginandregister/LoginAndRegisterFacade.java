package org.joboffers.domain.loginandregister;


import lombok.AllArgsConstructor;
import org.joboffers.domain.loginandregister.dto.RegisterUserDto;
import org.joboffers.domain.loginandregister.dto.RegistrationResultDto;
import org.joboffers.domain.loginandregister.dto.UserDto;
@AllArgsConstructor
public class LoginAndRegisterFacade {

    private final LoginRepository repository;
    private static final String USER_NOT_FOUND="User not found";
    public UserDto findByUsername(String username)
    {
        return repository.findByUsername(username)
                .map(user -> new UserDto(user.id(),user.username(),user.password()))
                .orElseThrow(()->new RuntimeException(USER_NOT_FOUND));
    }

    public RegistrationResultDto register(RegisterUserDto registerUserDto)
    {
        final User savedUser = User.builder()
                .username(registerUserDto.username())
                .password(registerUserDto.password())
                .build();
        repository.save(savedUser);
        return new RegistrationResultDto(savedUser.id(), savedUser.username(), "User registered");
    }
}
