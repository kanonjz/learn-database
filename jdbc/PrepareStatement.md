```
try {  
	conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
	// 3.执行SQL语句  
	ptmt = conn.prepareStatement("update info set firstname=? where id=?");  
	String name = "雅静";  
	int a = 3;  
	ptmt.setString(1, name);  
	ptmt.setInt(2, a);  
	ptmt.execute();  
} 
```
## PreparedStatement优点
1. 预编译，速度快
2. 可以写动态参数化的查询
3. 防止SQL注入

## 扩展阅读
[JDBC为什么要使用PreparedStatement而不是Statement](http://www.importnew.com/5006.html)
