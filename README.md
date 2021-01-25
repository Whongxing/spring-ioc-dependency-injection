# spring-ioc-dependency-injection
Spring-IOC 依赖注入学习 及 Demo案例
# 依赖注入的模式和类型
## 手动注入
配置或编程，硬编码
- XML配置
- JAVA注解配置元信息
- API配置元信息
## 自动注入
Spring提供应用自动关联
AutoWiring(自动绑定模式)

## 依赖注入类型
- Setter方法

  - 手动模式
  
    - xml配置
    - java注解配置
    - API配置元信息
  - 自动模式
    
    - byName
    - byType
- 构造器

- 字段注入  @Autowired

  - @Autowired
     默认ByType
  - @Resource
     默认ByName
  - @Inject
- 方法注入  @Autowired
- 接口回调  
