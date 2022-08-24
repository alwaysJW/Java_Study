import com.example.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","zhangSan");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
