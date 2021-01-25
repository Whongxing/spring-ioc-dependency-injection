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
 *      方法注入测试Demo
 *       不需要关注方法名，只需要关注参数
 */
public class DependencyInjectionMethodTest {

    private  UserDao userDao;

    private  UserDao userDao1;

    @Autowired
    public void initUserDao(UserDao userDao){
       this.userDao = userDao;
    }

    @Resource
    public void initUserDao1(UserDao userDao1){
        this.userDao1 = userDao1;
    }

    @Test
    public void DependencyInjectionSetterAnnotation(){
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration Class(配置类)
        applicationContext.register(DependencyInjectionMethodTest.class);
        //创建beanDefinitionReader
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "MATE-INF/dependency-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        //启动上下文
        applicationContext.refresh();

        //依赖查找
        DependencyInjectionMethodTest dependencyInjectionFieldTest = applicationContext.getBean(DependencyInjectionMethodTest.class);
        UserDao userDao1 = dependencyInjectionFieldTest.userDao1;
        UserDao userDao = dependencyInjectionFieldTest.userDao;
        System.out.println(userDao);
        System.out.println(userDao1);
        System.out.println(userDao==userDao1);

        applicationContext.close();


    }

    @Bean
    public UserDao userDao(UserTest userTest){
        return new UserDao(userTest);
    }
}
