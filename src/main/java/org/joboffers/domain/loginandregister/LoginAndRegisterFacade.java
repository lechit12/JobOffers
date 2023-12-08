package org.joboffers.domain.loginandregister;


import lombok.AllArgsConstructor;
import org.joboffers.domain.loginandregister.dto.RegisterUserDto;
import org.joboffers.domain.loginandregister.dto.RegistrationResultDto;
import org.joboffers.domain.loginandregister.dto.UserDto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class LoginAndRegisterFacade {

    private final LoginRepository repository;
    private static final String USER_NOT_FOUND="User not found";
    public UserDto findByUsername(String username)
    {
        return repository.findByUsername(username)
                .map(user -> new UserDto(user.id(),user.username(),user.password()))
                .orElseThrow(()->new UserNotFoundException(USER_NOT_FOUND));
    }

    public RegistrationResultDto register(RegisterUserDto registerUserDto)
    {
        final User user = User.builder()
                .username(registerUserDto.username())
                .password(registerUserDto.password())
                .build();
        User savedUser = repository.save(user);
        return new RegistrationResultDto(savedUser.id(), true, savedUser.username());
    }
}
//public class Welcome {
//    public static String greet(String language){
//
//        Map<String country,String language> database= new ConcurrentHashMap<>();
//
//    }
//}
//
//public class Database{
//    Map<String country,String language> database= new ConcurrentHashMap<>();
//    database.put("english","welcome");
//
//}