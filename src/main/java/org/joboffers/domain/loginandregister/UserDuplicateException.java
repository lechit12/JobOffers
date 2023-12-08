package org.joboffers.domain.loginandregister;

public class UserDuplicateException extends RuntimeException{

    private final String id;

    public UserDuplicateException(String id)
    {
        super(String.format("User with id %s already exists", id));
        this.id=id;
    }
}
