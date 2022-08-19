package com.sheep.summertest.vo;

import lombok.Data;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.vo
 * @datetime 2022/8/18 星期四
 */
@Data
public class ResetPwdVO {

    private String username;

    private String newPwd;

    private String verifyCode;
}
