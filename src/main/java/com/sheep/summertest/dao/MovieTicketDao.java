package com.sheep.summertest.dao;

import com.sheep.summertest.entity.MovieTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.dao
 * @datetime 2022/8/18 星期四
 */
@Repository
public interface MovieTicketDao extends JpaRepository<MovieTicket, Integer>, JpaSpecificationExecutor<MovieTicket> {

    Page<MovieTicket> findAllByBuyerUid(Integer uid, Pageable pageable);
}
