package org.joboffers.domain.loginandregister;

import org.joboffers.domain.loginandregister.dto.RegisterUserDto;
import org.joboffers.domain.loginandregister.dto.RegistrationResultDto;
import org.joboffers.domain.loginandregister.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAndRegisterFacadeTest {

    LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryLoginRepository());

    @Test
    public void it_should_return_user_by_username() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "pass");
        RegistrationResultDto register = loginAndRegisterFacade.register(registerUserDto);
        //when
        UserDto userDto = loginAndRegisterFacade.findByUsername(register.username());
        //then
        assertThat(userDto).isEqualTo(new UserDto(register.id(), "username", "pass"));

    }

    @Test
    public void it_should_return_user_not_found() {
        //given
        String username = "username";
        //when
        Throwable thrown = catchThrowable(()-> loginAndRegisterFacade.findByUsername(username));
        //then
        assertThat(thrown)
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User not found");

    }

    @Test
    public void it_should_register_user() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "pass");
        //when
        RegistrationResultDto resultDto = loginAndRegisterFacade.register(registerUserDto);

        assertAll(
                () -> assertThat(resultDto.created()).isTrue(),
                () -> assertThat(resultDto.username()).isEqualTo("username")

        );
    }
}