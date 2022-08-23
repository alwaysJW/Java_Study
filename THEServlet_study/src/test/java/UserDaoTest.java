import com.example.bean.User;
import com.example.dao.UserDao;
import org.junit.jupiter.api.Test;

public class UserDaoTest {
    @Test
    public void insertTest(){
        User user = new User();
        user.setUsername("李四");
        user.setPassword("123");
        User user1 = new UserDao().login(user);
        System.out.println(user1);
    }
}
