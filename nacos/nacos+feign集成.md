## 1. 本地下载nacos-server

[根据nacos最新tag下载](https://github.com/alibaba/nacos/tags)

## 2. 本地启动

nacos运行模式分 单节点和集群模式，单节点模式毫无挑战，直接集群模式整齐，需要配置两部分内容：

- 数据库连接，用于存放nacos的配置信息

1. 安装一个远程mysql，过程可参考：[ubuntu安装mysql教程](https://github.com/jiejiecool/note/blob/master/ubuntu%E5%AE%89%E8%A3%85mysql.md)

2. 修改安装路径下conf/application.properties的配置
```txt
spring.datasource.platform=mysql
db.num=1
db.url.0
db.user.0
db.password.0
```

- 集群模式配置

nacos安装路径下conf/cluster.conf.example文件名修改为cluster.conf

- 双击nacos安装路径下bin/startup.cmd
- 输入本地访问地址：localhost:8848/nacos
- 输入用户名密码 nacos/nacos


