package com.sheep.summertest.dao;

import com.sheep.summertest.entity.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.dao
 * @datetime 2022/8/18 星期四
 */
@Repository
public interface MovieSessionDao extends JpaRepository<MovieSession, Integer> {


    List<MovieSession> getAllByMovieId(Integer id);

    @Modifying
    @Query("update MovieSession m set m.votes = m.votes - 1 where m.id = ?1")
    void sellTicket(Integer id);

    @Modifying
    @Query("update MovieSession m set m.votes = m.votes + 1 where m.id = ?1")
    void returnTicket(Integer id);
}
