# springcloud
在eureka的基础上，迭代了ribbon，版本更新为3.0

添加了ribbon后，微服务就有了前端的负载均衡功能，基于eureka，项目主要变更了以下内容：
1.microservicecloud-consumer-dept-80工程添加了关于ribbon的pom.xml，添加了eureka的注解和ribbon的注解
2.为了验证ribbon的负载均衡，添加了microservicecloud-provider-dept-8002和microservicecloud-provider-dept-8003两个新的微服务server。
3.为了验证ribbon负载均衡成功配置，数据库新增了clouddb02和clouddb03两个数据库，同时创建了跟clouddb01相同的dept表。

如上内容添加后，启动所有的工程，最后启动消费者microservicecloud-consumer-dept-80，然后在浏览器访问http://localhost/consumer/dept/list,
观察页面返回json数据中【db_source】的内容，会发现每次访问它的值都会在clouddb01，clouddb02，clouddb03之间切换
这就说明实现了负载均衡了。因为这三个值分别来自8001到8003三个微服务各自连接的数据库查询到的数据。【tip：何为微服务？就是每个服务单独自己一个工程，连接各自的数据库。】

以上证明，添加ribbon成功。赢实现eureka服务注册发现和ribbon的前端负载均衡了。

后面的版本将继续迭代其他的springcloud的东东

