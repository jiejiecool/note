# 简单实现类 Mybatis 的 orm

## 实现执行sql的语句封装

### 1、加载jdbc配置
### 2、一个数据源生成一个SqlSessionFactory
### 3、每执行一个sql，都需要获得一个sqlsession，执行sql，执行完要么归还sqlsession，要么关闭sqlsession

