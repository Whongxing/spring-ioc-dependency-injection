import domain.UserDao;
import domain.UserTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 依赖注入
 *      字段注入测试Demo
 *          @AutoWired 会忽略掉静态字段  默认按类型装配
 *          @Resource  默认按名称装配
 *
 */
public class DependencyInjectionFieldTest {

    @Autowired
    private  UserDao userDao;

    @Resource
    private  UserDao userDao1;

    @Test
    public void DependencyInjectionSetterAnnotation(){
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration Class(配置类)
        applicationContext.register(DependencyInjectionFieldTest.class);
        //创建beanDefinitionReader
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "MATE-INF/dependency-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        //启动上下文
        applicationContext.refresh();

        //依赖查找
        DependencyInjectionFieldTest dependencyInjectionFieldTest = applicationContext.getBean(DependencyInjectionFieldTest.class);
        UserDao userDao1 = dependencyInjectionFieldTest.userDao1;
        UserDao userDao = dependencyInjectionFieldTest.userDao;
        System.out.println(userDao);
        System.out.println(userDao==userDao1);

        applicationContext.close();


    }

    @Bean
    public UserDao userDao(UserTest userTest){
        return new UserDao(userTest);
    }
}
