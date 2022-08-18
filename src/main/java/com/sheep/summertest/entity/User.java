package com.sheep.summertest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.entity
 * @datetime 2022/8/17 星期三
 */
@Entity
@Table(name = "t_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
    
}
