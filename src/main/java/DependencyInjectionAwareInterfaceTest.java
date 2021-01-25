import domain.UserDao;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于回调接口Aware的依赖注入
 */
public class DependencyInjectionAwareInterfaceTest implements BeanFactoryAware, ApplicationContextAware {

    private static BeanFactory beanFactory;

    private static ApplicationContext applicationContext;
    @Test
    public void DependencyInjectionSetterAnnotation(){
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration Class(配置类)
        applicationContext.register(DependencyInjectionAwareInterfaceTest.class);
        //启动上下文
        applicationContext.refresh();
        System.out.println(beanFactory);
        System.out.println(applicationContext.getBeanFactory());
        System.out.println(beanFactory == applicationContext.getBeanFactory());
        applicationContext.close();


    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        DependencyInjectionAwareInterfaceTest.beanFactory = beanFactory;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DependencyInjectionAwareInterfaceTest.applicationContext = applicationContext;
    }
}
