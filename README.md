# BorgesPhotoStudio
SpringCloud


> http://localhost:9775/hello?name=jennifer
> producer正常启动
>
> http://localhost:9776/hello/jennifer
> 说明客户端已经成功的通过feign调用了远程服务hello，并且将结果返回到了浏览器。

## Redis
实体类要实现序列化接口
```sbtshell
# 开启服务
➜  redis-5.0.7 redis-server /usr/local/tools/redis-5.0.7/conf/6379.conf
# 运行Redis
➜  redis-5.0.7 ./src/redis-cli -h 127.0.0.1 -p 6379

```

## hystrix
在consumer中
> http://localhost:9776/hello/jennifer

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191229134755130-1947183337.png)
断掉producer

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191229134916958-1154874475.png)


## HystrixDashboard
> http://localhost:9777/hystrix

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191229140742181-1326937265.png)

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191229171854918-1144003321.png)

访问 http://localhost:9777/hystrix.stream
不停地 ping 。。。

再次访问 http://localhost:9777/hello/jennifer
出现以下：
![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191229171637141-752905251.png)

此时 重新加载
![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191229172403560-1073034789.png)


# turbine


新建consumer——node01.node02

启动后 访问 
![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191230214421967-1551433193.png)
>http://localhost:9001/hello/jennifer
>http://localhost:9002/hello/jennifer

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191230213928104-168754613.png)

之后
>http://localhost:9778/turbine.stream

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191230213531658-1725989145.png)

进行图形化监控查看，输入：http://localhost:9778/hystrix，返回酷酷的小熊界面，输入： http://localhost:9778/turbine.stream，然后点击 Monitor Stream ,可以看到出现了俩个监控列表
hello01,hello02分别是node01,node02的不同名字的服务

## git config server
![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191230230410896-304042979.png)

![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191230213644372-844377687.png)
## git config client
获取了dev的配置
![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191231122544329-1129771271.png)
发现是冷配置，仓库变了，页面不变
#### refresh
改完之后
![](https://img2018.cnblogs.com/blog/1578595/201912/1578595-20191231123120978-1194927043.png)

## 配置中心高可用
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200101103405345-1325438164.png)


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200101140032989-673626946.png)

## 配置中心和消息总线
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200101140746969-1299496527.png) 

> https://www.jianshu.com/p/60c358235705
> https://www.cnblogs.com/java-zhao/p/5429091.html

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200105172359658-609557302.png)


启动
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200105173703495-1871458776.png)

更新前：
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200105181054693-543104184.png)

修改配置文件
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200106154408933-1911229746.png)

执行
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200106154520716-1537083472.png)

刷新
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200106154601459-1467623463.png)

### server / client

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107190223547-1152355497.png)


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107191435699-2052027503.png)


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107191530929-1489714326.png)

### 其他

#### 跟踪总线事件

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107193800323-849218094.png)

终端访问
> curl -X POST http://localhost:10084/bus/refresh


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107193926791-2027052483.png)

## zuul 网关

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107195904630-129262419.png)

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107195757284-1498572540.png)

.....

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107200720519-1351361451.png)

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200107200634285-893970335.png)

说明访问gateway-service-zuul-simple的请求自动转发到了spring-cloud-producer，并且将结果返回。

### 服务化

复制 producer

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108110532750-1326702030.png)

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108110551815-8722625.png)

说明通过zuul成功调用了producer服务并且做了均衡负载。

### 网关的默认路由规则
但是如果后端服务多达十几个的时候，每一个都这样配置也挺麻烦的，spring cloud zuul已经帮我们做了默认配置。默认情况下，Zuul会代理所有注册到Eureka Server的微服务，并且Zuul的路由规则如下：http://ZUUL_HOST:ZUUL_PORT/微服务在Eureka上的serviceId/**会被转发到serviceId对应的微服务。

我们注销掉gateway_zuul_service项目中关于路由的配置：


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108110406769-1300212364.png)


访问：
> http://localhost:18089/eureka-producer/hello?name=%E5%8C%97%E9%87%8E%E5%93%80

与结果相同

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108110532750-1326702030.png)
![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108110551815-8722625.png)


## Zuul的核心
![](http://favorites.ren/assets/images/2018/springcloud/zuul-core.png)

Zuul大部分功能都是通过过滤器来实现的，这些过滤器类型对应于请求的典型生命周期。

PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
ERROR：在其他阶段发生错误时执行该过滤器。 除了默认的过滤器类型，Zuul还允许我们创建自定义的过滤器类型。例如，我们可以定制一种STATIC类型的过滤器，直接在Zuul中生成响应，而不将请求转发到后端的微服务。

| 类型 |	顺序	| 过滤器 | 功能 |
|-----|-----|-------|-----|
|pre   |	-3 |	ServletDetectionFilter |	标记处理Servlet的类型|
|pre |	-2 |	Servlet30WrapperFilter |	包装HttpServletRequest请求|
|pre |	-1 |	FormBodyWrapperFilter |	包装请求体|
|route |	1 |	DebugFilter |	标记调试标志|
|route |	5 |	PreDecorationFilter |	处理请求上下文供后续使用|
|route |	10 |	RibbonRoutingFilter |	serviceId请求转发|
|route |	100 |	SimpleHostRoutingFilter |	url请求转发|
|route |	500 |	SendForwardFilter |	forward请求转发|
|post  |	0 |	SendErrorFilter |	处理有错误的请求响应|
|post |	1000 |	SendResponseFilter |	处理正常的请求响应|

### 自定义Filter示例

添加Filter extends ZuulFilter ; 启动类加上 

```
@Bean
   public TokenFilter tokenFilter() {
   	return new TokenFilter();
   }
 ```

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108125551450-1354530730.png)


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108125653765-1038405680.png)

### 路由熔断
加入  ProducerFallback implements FallbackProvider 

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108145155584-1702835705.png)

### 路由重试

访问地址：http://localhost:8888/spring-cloud-producer/hello?name=北野哀&token=xx，当页面返回：The service is unavailable.时查看项目eureka-producer2后台日志如下：

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108153950647-1953870709.png)


### zuul 高可用 
![](http://favorites.ren/assets/images/2018/springcloud/zuul-case.png)

## 使用Spring Cloud Sleuth和Zipkin进行分布式链路跟踪

### Spring Cloud Sleuth

一般的，一个分布式服务跟踪系统，主要有三部分：数据收集、数据存储和数据展示。根据系统大小不同，每一部分的结构又有一定变化。譬如，对于大规模分布式系统，数据存储可分为实时数据和全量数据两部分，实时数据用于故障排查（troubleshooting），全量数据用于系统优化；数据收集除了支持平台无关和开发语言无关系统的数据收集，还包括异步数据收集（需要跟踪队列中的消息，保证调用的连贯性），以及确保更小的侵入性；数据展示又涉及到数据挖掘和分析。虽然每一部分都可能变得很复杂，但基本原理都类似。
![](http://favorites.ren/assets/images/2018/springcloud/tracing1.png)
服务追踪的追踪单元是从客户发起请求（request）抵达被追踪系统的边界开始，到被追踪系统向客户返回响应（response）为止的过程，称为一个“trace”。每个 trace 中会调用若干个服务，为了记录调用了哪些服务，以及每次调用的消耗时间等信息，在每次调用服务时，埋入一个调用记录，称为一个“span”。这样，若干个有序的 span 就组成了一个 trace。在系统向外界提供服务的过程中，会不断地有请求和响应发生，也就会不断生成 trace，把这些带有span 的 trace 记录下来，就可以描绘出一幅系统的服务拓扑图。附带上 span 中的响应时间，以及请求成功与否等信息，就可以在发生问题的时候，找到异常的服务；根据历史数据，还可以从系统整体层面分析出哪里性能差，定位性能优化的目标。

Spring Cloud Sleuth为服务之间调用提供链路追踪。通过Sleuth可以很清楚的了解到一个服务请求经过了哪些服务，每个服务处理花费了多长。从而让我们可以很方便的理清各微服务间的调用关系。此外Sleuth可以帮助我们：

* 耗时分析: 通过Sleuth可以很方便的了解到每个采样请求的耗时，从而分析出哪些服务调用比较耗时;
* 可视化错误: 对于程序未捕捉的异常，可以通过集成Zipkin服务界面上看到;
* 链路优化: 对于调用比较频繁的服务，可以针对这些服务实施一些优化措施。
spring cloud sleuth可以结合zipkin，将信息发送到zipkin，利用zipkin的存储来存储信息，利用zipkin ui来展示数据。

这是Spring Cloud Sleuth的概念图：

![](http://favorites.ren/assets/images/2018/springcloud/tracing2.png)

### ZipKin

Zipkin 是一个开放源代码分布式的跟踪系统，由Twitter公司开源，它致力于收集服务的定时数据，以解决微服务架构中的延迟问题，包括数据的收集、存储、查找和展现。

每个服务向zipkin报告计时数据，zipkin会根据调用关系通过Zipkin UI生成依赖关系图，显示了多少跟踪请求通过每个服务，该系统让开发者可通过一个 Web 前端轻松的收集和分析数据，例如用户每次请求服务的处理时间等，可方便的监测系统中存在的瓶颈。

Zipkin提供了可插拔数据存储方式：In-Memory、MySql、Cassandra以及Elasticsearch。接下来的测试为方便直接采用In-Memory方式进行存储，生产推荐Elasticsearch。

配置完成后依次启动示例项目：spring-cloud-eureka、zipkin-server项目。刚问地址:http://localhost:18090/zipkin/可以看到Zipkin后台页面



![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200108163519173-1823737342.png)


未完成 先提交
> http://www.ityouknow.com/springcloud/2018/02/02/spring-cloud-sleuth-zipkin.html







# Spring Cloud 架构

![](http://favorites.ren/assets/images/2017/springcloud/springcloud-question.png)

![](http://favorites.ren/assets/images/2017/springcloud/spring-cloud-architecture.png)

* 1、外部或者内部的非Spring Cloud项目都统一通过API网关（Zuul）来访问内部服务.
* 2、网关接收到请求后，从注册中心（Eureka）获取可用服务
* 3、由Ribbon进行均衡负载后，分发到后端的具体实例
* 4、微服务之间通过Feign进行通信处理业务
* 5、Hystrix负责处理服务超时熔断
* 6、Turbine监控服务间的调用和熔断相关指标

图中没有画出配置中心，配置中心管理各微服务不同环境


