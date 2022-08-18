package com.sheep.summertest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.vo
 * @datetime 2022/8/18 星期四
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterVO {

    private String username;
    private String password;
    
    private String mailBox;
}
