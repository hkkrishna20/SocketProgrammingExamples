package name.javacode.javaee.userpref.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import name.javacode.javaee.userpref.domain.UserPreferenceEntity;
import name.javacode.javaee.userpref.domain.UserPreferenceId;

public interface JPAUserPreferenceRepository
	extends Repository<UserPreferenceEntity, UserPreferenceId> {

    Optional<UserPreferenceEntity> findOne(UserPreferenceId id);

    Optional<UserPreferenceEntity> save(UserPreferenceEntity userPreference);

    void delete(UserPreferenceId id);
}
