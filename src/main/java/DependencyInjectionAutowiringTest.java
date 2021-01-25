import domain.UserTest;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *Spring 依赖注入自动绑定测试Demo
 *   优点：
 *     AutoWiring可以有效的减少属性或者构造器参数的配置
 *         <bean id="userTest" class="domain.UserTest">
 *              <property name="id" value="1"/>
 *         </bean>
 *     其中property中 value其实就是简单的依赖注入，只不过注入的是简单的基本类型而已，如果是引用类型的话，就是ref属性
 *
 *   模式：
 *      no           -默认值，no,未激活需要手动绑定
 *      byName
 *      byType       -为了确保唯一，设置主类或者删除重复类型的Bean
 *      constructor  -一种byType,用于构造器参数
 */
public class DependencyInjectionAutowiringTest {

    /**
     * 自动绑定，打印UserDao绑定的user
     *   byName     <bean id="userDao" class="domain.UserDao" autowire="byName"/>
     *   byType     <bean id="userDao" class="domain.UserDao" autowire="byType"/>
     *
     */
    @Test
    public void dependencyInjectionAutowiring(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("MATE-INF/dependency-injection.xml");
        //byName
        beanFactory.getBean("userDao");
        System.out.println(beanFactory.getBean("userDao"));
        //byType
        beanFactory.getBean(UserTest.class);
        System.out.println( beanFactory.getBean(UserTest.class));
    }

}
