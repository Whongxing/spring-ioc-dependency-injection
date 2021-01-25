import domain.UserDao;
import domain.UserTest;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 依赖注入 Setter方法注入 测试Demo
 * 1、注解  annotationConfigApplicationCont    ext
 * 2、配置文件  ClassPathXmlApplicationContext
 */
public class DependencyInjectionSetterTest {

    /**
     * 手动注入，通过配置文件注入
     *      <bean id="userDao" class="domain.UserDao">
     *         <property name="userTest" ref="userTest"/>
     *      </bean> 手动注入UserTest
     */
    @Test
    public void DependencyInjectionSetter(){
        //新建一个DefaultListAbleBeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "MATE-INF/dependency-injection.xml";
        //加载xml资源，解析并且生成BeanDefinitions
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        UserDao userDao = beanFactory.getBean(UserDao.class);
        System.out.println(userDao);

    }

    /**
     * setter注入，通过Annotation注入Demo
     *   创建Bean工厂, 注册配置类
     *   创建一个BeanDefinitionReader ,读取配置信息
     *   启动容器
     *   依赖查找一个bean
     */
    @Test
    public void DependencyInjectionSetterAnnotation(){
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration Class(配置类)
        applicationContext.register(DependencyInjectionSetterTest.class);
        //创建beanDefinitionReader
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "MATE-INF/dependency-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        //启动上下文
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(UserDao.class));
        applicationContext.close();


    }

    @Bean
    public UserDao  userDao(UserTest userTest){
        return new UserDao(userTest);
    }
}
