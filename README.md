###### 服务说明
1. 9001、9002 用于测试feign的参数传递
2. 9002 提供数据，9001 消费数据




##### 2023-05-30 服务说明
1. 8070-auth auth服务
2. 8090-gateway
3. 9001
4. 9011、9012 是同一个服务的不同实例，供9001调用
5. 9022 单独的一个服务，用于与security集成的

05-30：待改造项目9001、9011、9012都引入的oauth2的依赖，
导致了服务feign之间的调用需要带上Authorization头信息，
应该是在gateway服务中，校验token,在放行。