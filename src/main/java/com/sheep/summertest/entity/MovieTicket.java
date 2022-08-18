package com.sheep.summertest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.entity
 * @datetime 2022/8/18 星期四
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_movie_tickets")
public class MovieTicket {

    @Column(name = "order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_title", length = 40, unique = true, nullable = false)
    private String name;

    private Double price;

    @Column(length = 40)
    private String cinema;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "f_uid")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "f_movie_id")
    private Movie movie;
}
