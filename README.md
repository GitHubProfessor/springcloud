# springcloud
springcloud原型架构

添加了Hystrix，版本迭代到5.0。
使用了Hystrix后，可以对微服务进行服务熔断和服务降级，同时还可以使用HystrixDashboard来实时监控微服务的状态。

变更内容：
1.新建工程microservicecloud-consumer-hystrix-dashboard，用于展示监控信息
2.所有Provoider微服务提供类（8001/8002/8003)都需要监控依赖spring-boot-starter-actuator的支持。否则没法使用dashboard
3.添加了microservicecloud-provider-dept-hystrix-8001
4.api工程的service包添加了DeptClientServiceFallbackFactory.java
4.修改了api工程中的service包中的DeptService，与DeptClientServiceFallbackFactory.java共同使用，用来做服务熔断和降级用。这样可以做到解耦。让微服务制作相关业务，把所有处理熔断和降级的东西（比如注解）都放到单独的地方处理（api工程）。

下一次迭代，将添加zuul组件，实现路由功能
