import org.javatop.jwt.utils.JwtUtils;
import org.javatop.jwt.SpringBootTokenRenewalApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 22:33
 * @description :
 */
@SpringBootTest(classes = SpringBootTokenRenewalApplication.class)
public class Test {

    /**
     *  用于测试: jwt 测试
     */
    @org.junit.jupiter.api.Test
    public void testjwt() {
        String token = JwtUtils.createToken();
        System.out.println("token = " + token);
        String s = JwtUtils.parseToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhZDU4MmFhNi0yOTE0LTRiMDEtYjc0Yi0yZWZlNDg5ZGNhOGQiLCJpc3MiOiJMZW8iLCJpYXQiOjE3MDA1Nzc4NTEsInN1YiI6Imp3dGRlbW8iLCJleHAiOjE3MDA1NzgxNTEsInVuYW1lIjoiTGVvIn0.Fss1_vT_kB3Y_lTkPvQ1svPpbjDUP78M_JTU6iYW6-Y");
        System.out.println("s = " + s);
    }
}
