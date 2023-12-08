package org.joboffers.domain.loginandregister;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLoginRepository implements LoginRepository {

    public Map<String, User> database = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(database.get(username));
    }

    @Override
    public User save(User savedUser) {
        if (database.values().stream().anyMatch(user -> user.id().equals(savedUser.id()))
        ) {
            throw new UserDuplicateException(savedUser.id());
        }
        UUID id = UUID.randomUUID();
        User user = new User(id.toString(),
                savedUser.username(),
                savedUser.password()
        );
        database.put(user.username(),user);

        return user;

    }
}
