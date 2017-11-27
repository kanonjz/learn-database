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
