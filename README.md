# springcloud

eureka分支（2.0版本）

eureka分支实现了spring boot 和eureka集群的集成。

分支中的代码讲述了，使用spring boot和eureka的基础框架，包括了springcloud微服务的消费者和生产者，讲述了如何通过RestTemplate来访问提供了restful形式的生产者。
如果将spring boot服务注册到服务中心eureka中，通过如何使用DiscoveryClient类来发现服务。同时讲述了eureka集群的实现。

springcloud架构的搭建，建通过分支迭代的方式，每个分支在原先分支的基础上添加新的springcloud微服务组件，根据版本号来区分迭代的程度，版本号越大，集成的spring cloud的部件越多。所形成的微服务体系越完善

在3.0版本，将会把ribban集成进来，形成rabbin分支，版本号为3.0
