package com.sheep.summertest.dao;

import com.sheep.summertest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.dao
 * @datetime 2022/8/17 星期三
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    /**
     * @param username
     * @return
     */
    boolean existsByName(String username);

    Optional<User> findByName(String username);
}
