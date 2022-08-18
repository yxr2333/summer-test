package com.sheep.summertest.dao;

import com.sheep.summertest.entity.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.dao
 * @datetime 2022/8/18 星期四
 */
@Repository
public interface MovieSessionDao extends JpaRepository<MovieSession, Integer> {
}
