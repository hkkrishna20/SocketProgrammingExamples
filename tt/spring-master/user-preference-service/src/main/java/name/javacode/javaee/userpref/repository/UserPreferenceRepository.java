package name.javacode.javaee.userpref.repository;

import java.util.Optional;

import name.javacode.javaee.userpref.domain.UserPreference;

public interface UserPreferenceRepository {
	Optional<UserPreference> findOne(UserPreference userPreference);

	default Optional<UserPreference> save(UserPreference userPreference) {
		throw new UnsupportedOperationException("Implement me!");
	}

	default Optional<UserPreference> delete(UserPreference userPreference) {
		throw new UnsupportedOperationException("Implement me!");
	}
}
