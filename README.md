# springcloud
springcloud原型架构

加入Feign，版本迭代到4.0，
使用feign时，代码做了以下变更
Feign版本所需变更
1.添加Feign的消费者更称
2.添加Feign的依赖
3.api工程中添加Feign的依赖，并且新建方接口的包
4.使用Feign后，消费者的controller将不再使用RestTemplate模板了，将使用Feign模式的rest调用，也及时直接使用api工程中的service接口的形式来调用
5.spring boot启动类，需要添加Feign相关的注解
