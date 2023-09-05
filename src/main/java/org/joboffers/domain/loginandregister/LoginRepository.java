package org.joboffers.domain.loginandregister;

import java.util.Optional;
import java.util.Set;

public interface LoginRepository {

    Optional<User> findByUsername(String username);

    User save(User savedUser);
}
