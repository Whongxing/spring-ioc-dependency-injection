import domain.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过API 注入实现
 *      -属于setter注入
 */
public class DependencyInjectionSetterApiTest {


    /**
     * setter注入，通过Annotation注入Demo
     *   创建Bean工厂
     *   获取BeanDefinition
     *   注册BeanDefinition
     *   加载beanDefinitionReader
     *   启动容器
     *   依赖查找一个bean
     */
    @Test
    public void dependencyInjectionAPI(){
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition userDaoDefinition = createUserDaoBeanDefinition();
        applicationContext.registerBeanDefinition("userDao",userDaoDefinition);
        //创建beanDefinitionReader
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "MATE-INF/dependency-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        applicationContext.refresh();
        UserDao userDao = applicationContext.getBean(UserDao.class);
        System.out.println(userDao);
        applicationContext.close();
    }

    /**
     * @return 为UserDao生成BeanDefinition
     */
    private static BeanDefinition createUserDaoBeanDefinition(){
       BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserDao.class);
        beanDefinitionBuilder.addPropertyReference("userTest","userTest");
       return  beanDefinitionBuilder.getBeanDefinition();
    }

}
