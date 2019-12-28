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
