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
