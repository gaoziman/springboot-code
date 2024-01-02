package org.javatop.dynamic;

import org.javatop.dynamic.domain.User;
import org.javatop.dynamic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:32
 * @description :
 */
@SpringBootTest
public class DynamicTest {

    @Autowired
    private UserService userService;


    /**
     *  用于测试:
     */
    @Test
    public void test() {
        List<User> all = userService.getAll();
        if(all !=null){
            for (User user : all) {
                System.out.println(user);
            }
        }
    }

}
