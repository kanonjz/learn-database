PyMySQL 是在 Python3.x 版本中用于连接 MySQL 服务器的一个库，Python2中则使用mysqldb。

## 安装PyMySQL
```
pip install PyMySQL
```

## 代码
```
import pymysql  
  
# 打开数据库连接（ip/数据库用户名/登录密码/数据库名）  
db = pymysql.connect("10.96.110.215", "root", "123456", "cce")  
# 使用 cursor() 方法创建一个游标对象 cursor  
cursor = db.cursor()  
# 使用 execute()  方法执行 SQL 查询  
cursor.execute("SELECT VERSION()")  
# 使用 fetchone() 方法获取单条数据.  
data = cursor.fetchone()  
print("Database version : %s " % data)  
# 关闭数据库连接  
db.close()  
```

## 参考
[菜鸟教程](http://www.runoob.com/python3/python3-mysql.html)
