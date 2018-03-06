# 远程连接mysql（安装在CentOS的远程服务器上）
1. 在服务器上执行
```
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '密码' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```
2. 远程连接,使用命令
```
mysql -h 120.78.82.56 -P 3306 -u root -p123456
```
