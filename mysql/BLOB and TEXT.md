# BLOB and TEXT
BLOB values are treated as binary strings (`byte strings`). They have the binary character set and collation, and comparison and sorting are based on the numeric values of the bytes in column values. 
TEXT values are treated as nonbinary strings (`character strings`). 
They have a character set other than binary, and values are sorted and compared based on the collation of the character set.

## 参考
![The BLOB and TEXT Types](https://dev.mysql.com/doc/refman/5.7/en/blob.html)
