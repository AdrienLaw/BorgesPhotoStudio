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


