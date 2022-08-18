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
@Table(name = "t_movies")
public class Movie {

    @Column(name = "movie_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_title", length = 40)
    private String name;

    @Column(length = 40)
    private String director;

    private String authors;

    private String actors;

    private String category;

    private String country;

    @Column(name = "lang")
    private String language;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime releaseDate;

    private Integer duration;

    private Double score;

    private String description;

    private String movieCover;
}
