# 向容器中注册bean的方式

-   ComponentScan
-   @Component
    -   @Service
    -   @Controller
    -   @Repository
    -   ……
-   @Bean
-   @Import
    -   @ImportSelector
    -   @ImportBeanDefinitionRegistrar
-   FactoryBean（工厂bean）
    -   加入容器的实际上是 `getObject` 方法返回的实例
    -   根据id获取bean的时候，在id前加个 `&` 前缀可以获取到FactoryBean的实例而非 `getObject` 方式返回的实例,前缀是在 `org.springframework.beans.factory.BeanFactory#FACTORY_BEAN_PREFIX` 中指定的。



# Bean生命周期配置

-   @Bean的 `initMethod` 和 `destroyMethod` 属性
    -   容器并不负责多实例bean的destroy
-   要注册到容器中的Bean 实现 `InitializingBean` 和 `DisposableBean` 接口
-   `JSR250` 规范
    -   `@PostConstruct`
    -   `@PreDestroy`
-   给容器中加入一个实现了 `BeanPostProcessor` 接口的bean
    -   `postProcessBeforeInitialization` 在 `任何初始化方法` 之前执行
    -   `postProcessAfterInitialization` 在 `任何初始化方法` 之后执行
    -   PS
        -   `ApplicationContextAware` 接口就是使用 `ApplicationContextAwareProcessor` 处理的
        -   `@PostConstruct` 和 `@PreDestroy` 也是使用 `BeanPostProcessor`实现的
        -   @Autowired
        -   @Async
        -   ……



# 加载配置文件

-   `@PropertySource` 加载 `properties` 配置文件
    -   `classpath:application.properties`
    -   `file:/path/to/config.properties`

# 自动注入

-   @AutoWired (`spring`)
    -   类型
    -   id
    -   @Qualifier
        -   Id
    -   @Primary
        -   优先使用
-   @Resource (`JSR250`)
    -   id (默认)
    -   没有@Primary和required的功能
-   @Inject (`JSR330`)
    -   依赖 `javax.inject` 包
    -   没有 required功能




# profile

`spring.profiles.active`