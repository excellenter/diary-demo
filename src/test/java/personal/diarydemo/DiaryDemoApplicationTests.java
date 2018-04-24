package personal.diarydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import personal.entity.TUser;
import personal.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiaryDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        TUser user = userService.getById("admin");
        System.out.println(user);
    }

}
