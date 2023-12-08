package org.joboffers.domain.loginandregister;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userNotFound)
    {
        super(userNotFound);
    }

}
