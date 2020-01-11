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

## 注册中心 Consul 使用详解

|Feature |	euerka |	Consul |	zookeeper |	etcd |
| --- | ---- | ---- | ---  | ---- |
|服务健康检查 |	可配支持	| 服务状态，内存，硬盘等 |	(弱)长连接，keepalive |连接心跳|
|多数据中心 |	— |	支持 | 	— |	— |
|kv 存储服务|	— |	支持 |	支持 |	支持 |
|一致性 |	— |	raft |	paxos |	raft |
|cap |	ap |	cp |	cp |	cp |
|使用接口(多语言能力) |	http（sidecar） |支持 http 和 dns	客户端 |	http/grpc|
|watch | 支持 |支持 | long polling/大部分增量 |	全量/支持long polling	|支持 |	支持 long polling|
|自身监控 |metrics |	metrics |	— |	metrics |
|安全 |	— |	acl  /https	acl |https | 支持（弱）|
spring cloud 集成 |	已支持 |	已支持 |	已支持 |	已支持 |

## Consul 介绍
Consul 是 HashiCorp 公司推出的开源工具，用于实现分布式系统的服务发现与配置。与其它分布式服务注册与发现的方案，Consul 的方案更“一站式”，内置了服务注册与发现框 架、分布一致性协议实现、健康检查、Key/Value 存储、多数据中心方案，不再需要依赖其它工具（比如 ZooKeeper 等）。使用起来也较 为简单。Consul 使用 Go 语言编写，因此具有天然可移植性(支持Linux、windows和Mac OS X)；安装包仅包含一个可执行文件，方便部署，与 Docker 等轻量级容器可无缝配合。

### Consul 的优势：

使用 Raft 算法来保证一致性, 比复杂的 Paxos 算法更直接. 相比较而言, zookeeper 采用的是 Paxos, 而 etcd 使用的则是 Raft。
支持多数据中心，内外网的服务采用不同的端口进行监听。 多数据中心集群可以避免单数据中心的单点故障,而其部署则需要考虑网络延迟, 分片等情况等。 zookeeper 和 etcd 均不提供多数据中心功能的支持。
支持健康检查。 etcd 不提供此功能。
支持 http 和 dns 协议接口。 zookeeper 的集成较为复杂, etcd 只支持 http 协议。
官方提供 web 管理界面, etcd 无此功能。
综合比较, Consul 作为服务注册和配置管理的新星, 比较值得关注和研究。
### 特性：

* 服务发现
* 健康检查
* Key/Value 存储
* 多数据中心

### Consul 角色

client: 客户端, 无状态, 将 HTTP 和 DNS 接口请求转发给局域网内的服务端集群。
server: 服务端, 保存配置信息, 高可用集群, 在局域网内与本地客户端通讯, 通过广域网与其它数据中心通讯。 每个数据中心的 server 数量推荐为 3 个或是 5 个。
Consul 客户端、服务端还支持夸中心的使用，更加提高了它的高可用性。

![](http://favorites.ren/assets/images/2018/springcloud/consul-server-client.png)
Consul 工作原理：
![](http://favorites.ren/assets/images/2018/springcloud/consol_service.png)

* 1、当 Producer 启动的时候，会向 Consul 发送一个 post 请求，告诉 Consul 自己的 IP 和 Port
* 2、Consul 接收到 Producer 的注册后，每隔10s（默认）会向 Producer 发送一个健康检查的请求，检验Producer是否健康
* 3、当 Consumer 发送 GET 方式请求 /api/address 到 Producer 时，会先从 Consul 中拿到一个存储服务 IP 和 Port 的临时表，从表中拿到 Producer 的 IP 和 Port 后再发送 GET 方式请求 /api/address
* 4、该临时表每隔10s会更新，只包含有通过了健康检查的 Producer
Spring Cloud Consul 项目是针对 Consul 的服务治理实现。Consul 是一个分布式高可用的系统，它包含多个组件，但是作为一个整体，在微服务架构中为我们的基础设施提供服务发现和服务配置的工具。

### Consul 安装
1. https://www.consul.io/downloads.html

2.将解压后的文件consul  拷贝到/usr/local/bin下sudo cp consul /usr/local/bin

3.打开bin文件，执行consul，查看consul命令，如下即表示成功


### Consul VS Eureka
Eureka 是一个服务发现工具。该体系结构主要是客户端/服务器，每个数据中心有一组 Eureka 服务器，通常每个可用区域一个。通常 Eureka 的客户使用嵌入式 SDK 来注册和发现服务。对于非本地集成的客户，官方提供的 Eureka 一些 REST 操作 API，其它语言可以使用这些 API 来实现对 Eureka Server 的操作从而实现一个非 jvm 语言的 Eureka Client。

Eureka 提供了一个弱一致的服务视图，尽可能的提供服务可用性。当客户端向服务器注册时，该服务器将尝试复制到其它服务器，但不提供保证复制完成。服务注册的生存时间（TTL）较短，要求客户端对服务器心跳检测。不健康的服务或节点停止心跳，导致它们超时并从注册表中删除。服务发现可以路由到注册的任何服务，由于心跳检测机制有时间间隔，可能会导致部分服务不可用。这个简化的模型允许简单的群集管理和高可扩展性。

Consul 提供了一些列特性，包括更丰富的健康检查，键值对存储以及多数据中心。Consul 需要每个数据中心都有一套服务，以及每个客户端的 agent，类似于使用像 Ribbon 这样的服务。Consul agent 允许大多数应用程序成为 Consul 不知情者，通过配置文件执行服务注册并通过 DNS 或负载平衡器 sidecars 发现。

Consul 提供强大的一致性保证，因为服务器使用 Raft 协议复制状态 。Consul 支持丰富的健康检查，包括 TCP，HTTP，Nagios / Sensu 兼容脚本或基于 Eureka 的 TTL。客户端节点参与基于 Gossip 协议的健康检查，该检查分发健康检查工作，而不像集中式心跳检测那样成为可扩展性挑战。发现请求被路由到选举出来的 leader，这使他们默认情况下强一致性。允许客户端过时读取取使任何服务器处理他们的请求，从而实现像 Eureka 这样的线性可伸缩性。

Consul 强烈的一致性意味着它可以作为领导选举和集群协调的锁定服务。Eureka 不提供类似的保证，并且通常需要为需要执行协调或具有更强一致性需求的服务运行 ZooKeeper。

Consul 提供了支持面向服务的体系结构所需的一系列功能。这包括服务发现，还包括丰富的运行状况检查，锁定，密钥/值，多数据中心联合，事件系统和 ACL。Consul 和 consul-template 和 envconsul 等工具生态系统都试图尽量减少集成所需的应用程序更改，以避免需要通过 SDK 进行本地集成。Eureka 是一个更大的 Netflix OSS 套件的一部分，该套件预计应用程序相对均匀且紧密集成。因此 Eureka 只解决了一小部分问题，可以和 ZooKeeper 等其它工具可以一起使用。

Consul 强一致性(C)带来的是：

服务注册相比 Eureka 会稍慢一些。因为 Consul 的 raft 协议要求必须过半数的节点都写入成功才认为注册成功 Leader 挂掉时，重新选举期间整个 Consul 不可用。保证了强一致性但牺牲了可用性。

Eureka 保证高可用(A)和最终一致性：

服务注册相对要快，因为不需要等注册信息 replicate 到其它节点，也不保证注册信息是否 replicate 成功 当数据出现不一致时，虽然 A, B 上的注册信息不完全相同，但每个 Eureka 节点依然能够正常对外提供服务，这会出现查询服务信息时如果请求 A 查不到，但请求 B 就能查到。如此保证了可用性但牺牲了一致性。

其它方面，eureka 就是个 servlet 程序，跑在 servlet 容器中; Consul 则是 go 编写而成。

> https://blog.csdn.net/kanglovejava/article/details/100622113

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109123525025-788179590.png)


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109123649749-1479892865.png)

### Consul 服务端
新建 producer、producer02

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109125415276-1995971812.png)


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109125517777-925720220.png)

新建 consumer
ServiceController



![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109141825290-638829668.png)

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109141503544-1142936713.png)

##### 第二次 CallHelloController


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109142334946-1912128265.png)

说明我们已经成功的调用了 Consul 服务端提供的服务，并且实现了服务端的均衡负载功能。通过今天的实践我们发现 Consul 提供的服务发现易用、强大。


## 服务网关 Spring Cloud GateWay 入门

### Spring Cloud Gateway
Spring Cloud Gateway 是 Spring Cloud 的一个全新项目，该项目是基于 Spring 5.0，Spring Boot 2.0 和 Project Reactor 等技术开发的网关，它旨在为微服务架构提供一种简单有效的统一的 API 路由管理方式。

Spring Cloud Gateway 作为 Spring Cloud 生态系统中的网关，目标是替代 Netflix Zuul，其不仅提供统一的路由方式，并且基于 Filter 链的方式提供了网关基本的功能，例如：安全，监控/指标，和限流。

相关概念:

* Route（路由）：这是网关的基本构建块。它由一个 ID，一个目标 URI，一组断言和一组过滤器定义。如果断言为真，则路由匹配。
* Predicate（断言）：这是一个 Java 8 的 Predicate。输入类型是一个 ServerWebExchange。我们可以使用它来匹配来自 HTTP 请求的任何内容，例如 headers 或参数。
* Filter（过滤器）：这是org.springframework.cloud.gateway.filter.GatewayFilter的实例，我们可以使用它修改请求和响应。

![](http://favorites.ren/assets/images/2018/springcloud/spring-cloud-gateway.png)

客户端向 Spring Cloud Gateway 发出请求。如果 Gateway Handler Mapping 中找到与请求相匹配的路由，将其发送到 Gateway Web Handler。Handler 再通过指定的过滤器链来将请求发送到我们实际的服务执行业务逻辑，然后返回。 过滤器之间用虚线分开是因为过滤器可能会在发送代理请求之前（“pre”）或之后（“post”）执行业务逻辑。

Spring Cloud Gateway 的特征：

* 基于 Spring Framework 5，Project Reactor 和 Spring Boot 2.0
* 动态路由
* Predicates 和 Filters 作用于特定路由
* 集成 Hystrix 断路器
* 集成 Spring Cloud DiscoveryClient
* 易于编写的 Predicates 和 Filters
* 限流
* 路径重写



### 快速上手

上面这段配置的意思是，配置了一个 id 为 neo_route 的路由规则，当访问地址 http://localhost:8080/spring-cloud时会自动转发到地址：http://www.ityouknow.com/spring-cloud。配置完成启动项目即可在浏览器访问进行测试，当我们访问地址http://localhost:8080/spring-cloud 时会展示页面展示如下：


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109152534885-978193744.png)
证明页面转发成功。

======

转发功能同样可以通过代码来实现，我们可以在启动类 GateWayApplication 中添加方法 customRouteLocator() 来定制转发规则。
上面配置了一个 id 为 path_route 的路由，当访问地址http://localhost:8080/about时会自动转发到地址：http://www.ityouknow.com/about和上面的转发效果一样，只是这里转发的是以项目地址/about格式的请求地址。


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109152847525-284790907.png)


### 路由规则

Spring Cloud Gateway 的功能很强大，我们仅仅通过 Predicates 的设计就可以看出来，前面我们只是使用了 predicates 进行了简单的条件匹配，其实 Spring Cloud Gataway 帮我们内置了很多 Predicates 功能。

Spring Cloud Gateway 是通过 Spring WebFlux 的 HandlerMapping 做为底层支持来匹配到转发路由，Spring Cloud Gateway 内置了很多 Predicates 工厂，这些 Predicates 工厂通过不同的 HTTP 请求参数来匹配，多个 Predicates 工厂可以组合使用。

#### Predicate 介绍
Predicate 来源于 Java 8，是 Java 8 中引入的一个函数，Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）。可以用于接口请求参数校验、判断新老数据是否有变化需要进行更新操作。

在 Spring Cloud Gateway 中 Spring 利用 Predicate 的特性实现了各种路由匹配规则，有通过 Header、请求参数等不同的条件来进行作为条件匹配到对应的路由。网上有一张图总结了 Spring Cloud 内置的几种 Predicate 的实现。

![](http://favorites.ren/assets/images/2018/springcloud/spring-cloud-gateway3.png)
说白了 Predicate 就是为了实现一组匹配规则，方便让请求过来找到对应的 Route 进行处理，接下来我们接下 Spring Cloud GateWay 内置几种 Predicate 的使用。

#### 通过时间匹配

 - -002 配置--
##### Predicate

Predicate 支持设置一个时间，在请求进行转发的时候，可以通过判断在这个时间之前或者之后进行转发。比如我们现在设置只有在2019年1月1日才会转发到我的网站，在这之前不进行转发，我就可以这样配置：

Spring 是通过 ZonedDateTime 来对时间进行的对比，ZonedDateTime 是 Java 8 中日期时间功能里，用于表示带时区的日期与时间信息的类，ZonedDateTime 支持通过时区来设置时间，中国的时区是：Asia/Shanghai。

After Route Predicate 是指在这个时间之后的请求都转发到目标地址。上面的示例是指，请求时间在 2018年1月20日6点6分6秒之后的所有请求都转发到地址http://ityouknow.com。+08:00是指时间和UTC时间相差八个小时，时间地区为Asia/Shanghai。

添加完路由规则之后，访问地址http://localhost:8080会自动转发到http://ityouknow.com

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109154700930-103056830.png)


##### Before Route Predicate
Before Route Predicate 刚好相反，在某个时间之前的请求的请求都进行转发。

##### Between Route Predicate 来实现。
除过在时间之前或者之后外，Gateway 还支持限制路由请求在某一个时间段范围内，可以使用 Between Route Predicate 来实现。

#### 通过 Cookie 匹配
Cookie Route Predicate 可以接收两个参数，一个是 Cookie name ,一个是正则表达式，路由规则会通过获取对应的 Cookie name 值和正则表达式去匹配，如果匹配上就会执行路由，如果没有匹配上则不执行。
> curl http://localhost:8080 --cookie "ityouknow=kee.e"


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109160522675-1589687221.png)

则会返回页面代码，如果去掉 --cookie "ityouknow=kee.e"，后台汇报 404 错误。

#### 通过 Header 属性匹配

> curl http://localhost:8080  -H "X-Request-Id:666666" 

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200109160634985-2126469806.png)

则返回页面代码证明匹配成功。将参数-H "X-Request-Id:666666"改为-H "X-Request-Id:neo"再次执行时返回404证明没有匹配。

#### 通过 Host 匹配
> curl http://localhost:8080  -H "Host: www.ityouknow.com" 
>
> curl http://localhost:8080  -H "Host: md.ityouknow.com" 
经测试以上两种 host 均可匹配到 host_route 路由，去掉 host 参数则会报 404 错误。

#### 通过请求方式匹配
> curl http://localhost:8080

> curl -X POST http://localhost:8080

#### 通过请求路径匹配
> curl http://localhost:8080/foo/1
>
> curl http://localhost:8080/foo/xx
>
> curl http://localhost:8080/boo/xx

经过测试第一和第二条命令可以正常获取到页面返回值，最后一个命令报404，证明路由是通过指定路由来匹配。

#### 通过请求参数匹配

> curl localhost:8080?smile=x&id=2

这样只要当请求中包含 keep 属性并且参数值是以 pu 开头的长度为三位的字符串才会进行匹配和路由。
> curl localhost:8080?keep=pub

#### 通过请求 ip 地址进行匹配
> curl localhost:8080

#### 组合使用

## 服务网关 Spring Cloud GateWay 服务化和过滤器

在介绍服务网关 zuul 的使用时，提供了 spring-cloud-eureka 、spring-cloud-producer 项目示例，本次演示我们将两个项目版本升级到 Finchley.SR2 后继续演示使用。

### 服务网关注册到注册中心
新建 spring_cloud_gateway_producer spring_cloud_gateway_producer2 spring_cloud_eureka_gateway


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200110124139069-1997285854.png)

### 测试

> http://localhost:8888/SPRING-CLOUD-PRODUCER/hello


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200110124728124-843890104.png)

## 基于 Filter(过滤器) 实现的高级功能

Spring Cloud Gateway 的 Filter 的生命周期不像 Zuul 的那么丰富，它只有两个：“pre” 和 “post”。

* PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
* POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
Spring Cloud Gateway 的 Filter 分为两种：GatewayFilter 与 GlobalFilter。GlobalFilter 会应用到所有的路由上，而 GatewayFilter 将应用到单个路由或者一个分组的路由上。

Spring Cloud Gateway 内置了9种 GlobalFilter，比如 Netty Routing Filter、LoadBalancerClient Filter、Websocket Routing Filter 等，根据名字即可猜测出这些 Filter 的作者，具体大家可以参考官网内容：Global Filters

利用 GatewayFilter 可以修改请求的 Http 的请求或者响应，或者根据请求或者响应做一些特殊的限制。 更多时候我们会利用 GatewayFilter 做一些具体的路由配置，下面我们做一些简单的介绍。

再次修改配置文件

> http://localhost:8888/foo
>
> http://localhost:9000/foo

这里的 routes 手动指定了服务的转发地址，设置所有的 GET 方法都会自动添加foo=bar，http://localhost:9000 是 spring-cloud-producer 项目，我们在此项目中添加一个 foo() 方法，用来接收转发中添加的参数 foo。

```java
    @RequestMapping("/foo")
    public String foo(String foo) {
        return "hello "+foo+"!";
    }

```
修改完成后重启 cloud-gateway-eureka、spring-cloud-producer 项目。访问地址http://localhost:9000/foo页面返回：hello null!，说明并没有接受到参数 foo；通过网关来调用此服务，浏览器访问地址http://localhost:8888/foo页面返回：hello bar!，说明成功接收到参数 foo 参数的值 bar ,证明网关在转发的过程中已经通过 filter 添加了设置的参数和值。


![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200110125855777-1232704553.png)

### 服务化路由转发

上面我们使用 uri 指定了一个服务转发地址，单个服务这样使用问题不大，但是我们在注册中心往往会使用多个服务来共同支撑整个服务的使用，这个时候我们就期望可以将 Filter 作用到每个应用的实例上，spring cloud gateway 工了这样的功能，只需要简单配置即可。

为了测试两个服务提供者是否都被调用，我们在 spring-cloud-producer-1 项目中也同样添加 foo() 方法。

```java

@RequestMapping("/foo")
public String foo(String foo) {
    return "hello "+foo+"!!";
}
```
为了和 spring-cloud-producer 中 foo() 方法有所区别，这里使用了两个感叹号。同时将 cloud-gateway-eureka 项目配置文件中的 uri 内容修改如下：

#格式为：lb://应用注册服务名
uri: lb://spring-cloud-producer
修改完之后，重新启动项目 cloud-gateway-eureka、spring-cloud-producer-1，浏览器访问地址:http://localhost:8888/foo页面交替出现：
```bash

hello bar!
hello bar!!
```
证明请求依据均匀转发到后端服务，并且后端服务均接收到了 filter 增加的参数 foo 值。

这里其实默认使用了全局过滤器 LoadBalancerClient ，当路由配置中 uri 所用的协议为 lb 时（以uri: lb://spring-cloud-producer为例），gateway 将使用 LoadBalancerClient 把 spring-cloud-producer 通过 eureka 解析为实际的主机和端口，并进行负载均衡。

下篇再给大家介绍集中比较常用的 Filter 功能。


## 服务网关 Spring Cloud GateWay 熔断、限流、重试

### 修改请求路径的过滤器

StripPrefix Filter

StripPrefix Filter 是一个请求路径截取的功能，我们可以利用这个功能来做特殊业务的转发。

根据上面配置的例子表示，当请求路径匹配到/name/**会将包含name和后边的字符串接去掉转发， StripPrefix=2就代表截取路径的个数，这样配置后当请求/name/bar/foo后端匹配到的请求路径就会变成http://nameservice/foo。

我们还是在 cloud-gateway-eureka 项目中进行测试，修改 application.yml 如下：

```java

    spring:
      cloud:
         routes:
         - id: nameRoot
           uri: lb://spring-cloud-producer
           predicates:
           - Path=/name/**
           filters:
           - StripPrefix=2
```
配置完后重启 cloud-gateway-eureka 项目，访问地址：http://localhost:8888/name/foo/hello页面会交替显示：

hello world!
hello world smile!
和直接访问地址 http://localhost:8888/hello展示的效果一致，说明请求路径中的 name/foo/ 已经被截取。

![](https://img2018.cnblogs.com/blog/1578595/202001/1578595-20200110162955873-1081238278.png)


和直接访问地址 http://localhost:8888/hello展示的效果一致，说明请求路径中的 name/foo/ 已经被截取。（但是我没玩成功）

### 限速路由器
限速在高并发场景中比较常用的手段之一，可以有效的保障服务的整体稳定性，Spring Cloud Gateway 提供了基于 Redis 的限流方案。所以我们首先需要添加对应的依赖包spring-boot-starter-data-redis-reactive


### 熔断路由器

fallbackUri: forward:/incaseoffailureusethis配置了 fallback 时要会调的路径，当调用 Hystrix 的 fallback 被调用时，请求将转发到/incaseoffailureuset这个 URI。

### 重试路由器

RetryGatewayFilter 是 Spring Cloud Gateway 对请求重试提供的一个 GatewayFilter Factory

Retry GatewayFilter 通过这四个参数来控制重试机制： retries, statuses, methods, 和 series。

retries：重试次数，默认值是 3 次
statuses：HTTP 的状态返回码，取值请参考：org.springframework.http.HttpStatus
methods：指定哪些方法的请求需要进行重试逻辑，默认值是 GET 方法，取值参考：org.springframework.http.HttpMethod
series：一些列的状态码配置，取值参考：org.springframework.http.HttpStatus.Series。符合的某段状态码才会进行重试逻辑，默认值是 SERVER_ERROR，值是 5，也就是 5XX(5 开头的状态码)，共有5 个值。
以上便是项目中常用的一些网关操作，更多关于 Spring Cloud GateWay 的使用请参考官网。




=====================================================================

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


