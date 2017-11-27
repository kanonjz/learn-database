## SQL注入与防范
### 什么是SQL注入
用户在表单或URL中输入SQL命令达到欺骗服务器的目的，输入的SQL语句改变了原有的SQL语义，导致信息泄露的漏洞

### 例子  
服务器中的sql语句：
```
"select * from user where username=' " + username + " 'and password=' " + password + " ' "
```
用户在输入界面输入：
```
用户名：zhangsan';--
密码：
```
结果：不需要密码也能登录  
原因是：分号后面那一部分被注释掉了
```
select * from user where username='zhangsan';--'and password='111';
```

### 解决：使用PreparedStatement方法
```
select * from user where username=? and password=?;
```
问号为占位符，确定了SQL的语义，防止被改变
