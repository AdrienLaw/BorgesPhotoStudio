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