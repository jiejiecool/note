## 1.安装
```bash
sudo apt update
sudo apt install mysql-server
```

## 2.启动服务
```bash
sudo service mysql start
```
## 3.开启远程访问

### 3.1 修改配置文件，使mysql可以远程访问
```bash
vi /etc/mysql/mysql.conf.d/mysqld.cnf
# 注释 bind-address = 127.0.0.1
```
### 3.2 登录mysql，新增用户并允许远程访问
```bash
sudo mysql -uroot -p
# 默认密码是root
# 此处 %指任意ip
mysql> GRANT ALL PRIVILEGES ON *.* TO '用户名'@'%'IDENTIFIED BY '密码' WITH GRANT OPTION;
# 刷新
mysql> flush privileges;
# 重启mysql 服务
sudo service msyql restart
```
## 4.远程连接

### 4.1 查看本地ip
```bash
ifconfig
# 如果没有这个命令，就sudo apt install net-tools
```
### 4.2 远程连接
```bash
navicate or sqlyog 连接即可
```
