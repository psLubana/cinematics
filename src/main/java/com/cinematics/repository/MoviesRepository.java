package com.cinematics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cinematics.domain.Movies;

/**
 * Spring Data MongoDB repository for the User entity.
 */
@Repository
public interface MoviesRepository extends MongoRepository<Movies, String> {

	boolean findOneById(String id);

   /* String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<User> findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<User> findOneByEmailIgnoreCase(String email);

    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<User> findOneByLogin(String login);

    Page<User> findAllByLoginNot(Pageable pageable, String login);*/
}
