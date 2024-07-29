package org.leocoder.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.leocoder.plus.domain.User;
import org.leocoder.plus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-07-25 09:51
 * @description :
 */

@SpringBootTest(classes = MyBatisPlusApplication.class)
public class ApiTest {


    @Autowired
    private UserMapper userMapper;

    /**
     *  用于测试: mp
     */
    @Test
    public void test01() {
        User user = User.builder()
                .id(1L)
                .name("leo")
                .age(20)
                .gender(1)
                .build();

        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

    }

    /**
     *  用于测试:
     */
    @Test
    public void test02() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, 2L);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println("users = " + users);
    }
}
