1. 本地下载nacos-server, [根据nacos最新tag下载](https://github.com/alibaba/nacos/tags)

2. 本地安装

本地启动时，startup.cmd默认使用cluster，必须配置数据库，否则启动失败，可以参考这篇文章
[nacos本地启动报错：load jdbc.properties error](https://www.cnblogs.com/juyss/p/14005059.html)

所以我们把启动模式改为standalone

