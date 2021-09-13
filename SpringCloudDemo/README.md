| 工程名                                   | 端口 | 说明             | 备注                                   |
| ---------------------------------------- | ---- | ---------------- | -------------------------------------- |
| spring-cloud-eureka                      | 8761 | 注册中心1        |                                        |
| spring-cloud-eureka2                     | 8762 | 注册中心2        | 与1组成集群                            |
| spring-cloud-zuul                        |      | zuul网关         | 暂未支持，网关部分使用gateway          |
| spring-cloud-user-service                | 8030 | 用户服务         | 暂未支持，后续有需求业务会在这里面添加 |
| spring-cloud-payment-service             | 8020 | 支付模块         |                                        |
| spring-cloud-common                      |      | 公共模块         |                                        |
| spring-cloud-payment-api                 |      | 支付模块 api     | 暂未支持，后续可能改造需要             |
| spring-cloud-order-service               | 8010 | 订单模块         |                                        |
| spring-cloud-payment-service2            | 8021 | 支付模块         | 集群                                   |
| spring-cloud-payment-service-zk          | 8022 | 支付模块         | 注册中心为zookeeper                    |
| spring-cloud-order-service-zk            | 8011 | 订单模块         | 注册中心为zookeeper                    |
| spring-cloud-order-service-feign         | 8012 | 订单模块         | 集成openfeign                          |
| spring-cloud-payment-service-hystrix     | 8021 | 支付模块         | 集成hystrix服务降级熔断                |
| spring-cloud-order-service-feign-hystrix | 8012 | 订单模块         | 集成hystrix服务降级熔断                |
| spring-cloud-hystrix-dashboard           | 9800 | hystrix监控      | hystrix监控面板                        |
| spring-cloud-gateway                     | 8000 | 网关模块         |                                        |
| spring-cloud-conifg                      | 8888 | 配置中心         |                                        |
| spring-cloud-config-client               | 8889 | 配置中心客户端   |                                        |
| spring-cloud-stream-provider             | 9001 | 消息驱动生产模块 |                                        |
| spring-cloud-stream-consumer             | 9011 | 消息驱动消费模块 |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |
|                                          |      |                  |                                        |

