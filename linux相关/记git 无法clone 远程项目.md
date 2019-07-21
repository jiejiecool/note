## 问题描述

使用git clone github仓库中的项目失败

git 返回信息: 可能是sshkey配置错误，或者没有权限

## 解决步骤

1.  可能是公钥配置错误, 重新根据github的用户名生成公钥并保存在github中

```shell
ssh-keygen -t rsa -C "username" (注：username为你git上的用户名)
```

2. git clone 还是不行，使用ping github.com超时

3.  本身使用具有ssh的功能
   
   ```
    sudo apt-get install ssh
   ```

4. 使用以下命令
```
ssh -T git@github.com
```

等待结果返回，发现这条命令自动给我在host中加入了域名解析，再clone即成功了。

## 结论

结论就是 使用 `ssh -T git@github.com` 解决问题，但是`man ssh`发现这个参数的意义只是不分配伪终端，搞不懂.先这样
