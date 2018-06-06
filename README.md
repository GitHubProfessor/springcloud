# springcloud
springcloud原型架构
此分支为迭代到springcloud的Zuul组件，版本为6.0.
到此为止，还差一个springcloud的config组件，微服务的基本组件使用就全都齐了。

Zuul主要用于网关路由，可以隐藏真实的微服务url地址，使用zuul映射的地址来访问。
同时还可以禁用原始的url访问地址。

Zuul要和Eureka一起使用，因为Zuul也需要作为一个微服务注册到Eureka中。

此版本运行的方式：\n
1.启动3个Eureka集群
2.启动我们微服务的提供者microservicecloud-provider-dept-8001
3.启用专门用于网关的zuul模块工程microservicecloud-zuul-gateway-9527。
