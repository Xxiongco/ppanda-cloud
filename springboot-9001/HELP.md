###### 读取property的4种方式
1. @Value() 注解
2. @ConfigurationProperties(prefix = "panda")
   @Component
   @PropertySource(value = "myProperties.properties") 这几个注解一起