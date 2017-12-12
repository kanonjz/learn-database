### 1. cmd插入中文数据时报如下错误
```
mysql> insert into test1 (id, salary, name) values (6, 10, '小明');
ERROR 1366 (HY000): Incorrect string value: '\xC3\xF7' for column 'name' at row 1
```
凡是出现1366 ERROR都是编码不匹配的问题，我在使用Workbench时也出现过这种情况

##### 解决：告诉mysql我这边的文字编码是GBK（cmd默认编码是GBK）
```
mysql> set character_set_client=gbk;
```

### 2. cmd查询数据时中文乱码
##### 解决：告诉mysql希望返回的结果集编码
```
mysql> set character_set_results=gbk;
```

### 3. 查看表字段存储时的编码
```
mysql> show full columns from 表名;
```

### 4. 查看数据库的编码
```
mysql> show variables like '%character%';
```
我们来看看没做任何修改前数据库中的编码<br><br>
![](http://oyrpkn4bk.bkt.clouddn.com/encode2.JPG)<br><br>
可以清楚地看到对于`character_set_client`和`character_set_results`都默认为`utf8`，由于cmd的默认编码是`GBK`,直接导致了mysql无法识别中文字符以及传出到cmd的中文字符乱码！！！<br><br>
既然我们知道了问题出现的原因，那么接下来就是

## 终极大招
```
mysql> set names gbk;
```
这一招相当于既解决了中文插入的问题，也解决了显示乱码的问题。唯一的缺点就是每次连接断开后都会失效。<br><br>
我们可以再来看看数据库中的编码信息<br><br>
![](http://oyrpkn4bk.bkt.clouddn.com/encode.JPG)<br><br>
ok,大功告成，问题已解决

## 修改配置文件
有时候数据库内部的编码`character_set_database`和`character_set_server`可能不是utf-8，这时候就需要去修改配置文件。

Windows系统对应的配置文件为`my.ini`,Linux对应的为`my.cnf`。

在[mysqld]下面添加两行
```
[mysqld]
character-set-server = utf8
collation-server = utf8_general_ci
```

重启mysql服务
```
service mysqld restart
```

搞定！

**注意事项**: 在修改字符集之前已经建立的数据库，character_set_database值不会发生改变，往数据库中插入中文数据仍然会显示乱码，所以最好在安装完MySQL后就将字符集改成utf8，否则后续修改会较麻烦。

## 疑问
到了最后，我们不禁有疑问，为啥cmd和mysql的编码不同，只有中文会出现乱码，而英文却没有乱码，emmmm这里就得移步关于编码另一个的问题
![逼乎](https://www.zhihu.com/question/38500793?sort=created)

## 参考资料
[10分钟学会理解和解决MySQL乱码问题](http://cenalulu.github.io/mysql/mysql-mojibake/)  
[在CMD中操作mysql数据库出现中文乱码解决方案](http://blog.csdn.net/jq_ak47/article/details/55261124)  
[MySQL中UTF-8编码的数据在CMD命令行显示乱码解决方案](http://blog.csdn.net/dunylin/article/details/54947865)  
[Centos7下设置mysql5.6字符集编码为utf8](https://jingyan.baidu.com/article/86112f1398c70827379787f8.html)
