package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.chinasofti.entity.Reader;

public class ReaderDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// 根据人名查询数据
	public List<Reader> getReaderList(String readerName){
		String sql = "select * from reader_tb where reader_name like ? ";
		List<Reader> list = new ArrayList<Reader>();
		
		try {
			//通过公共类得到连接对象
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			if(readerName==null){
				readerName = "%";
			}
			else{
				readerName = "%"+readerName+"%";
			}
			//给sql中的？占位符指定数据，注意数据类型
		
			stmt.setString(1, readerName);
			rs = stmt.executeQuery();
			while(rs.next()){
				int readerID = rs.getInt("reader_id");
				readerName = rs.getString("reader_name");
				String readerSex = rs.getString("reader_sex");
				int readerAge = rs.getInt("reader_age");
				Reader reader = new Reader(readerID,readerName, readerSex,readerAge);			
				list.add(reader);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}
	
	// 添加图书
	public int addReader(Reader reader){
		String readerName = reader.getReaderName();
		String readerSex = reader.getReaderSex();
		int readerAge = reader.getReaderAge();

		String sql = "INSERT INTO reader_tb (reader_name, reader_age,reader_sex) "	
				   + "values('"+readerName+"'"
				   + ",'"+readerAge+"'"
				   + ",'"+readerSex+"' )";
		
		try {
			//通过公共类得到连接对象
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			
			//给sql中的？占位符指定数据，注意数据类型
			int res= stmt.executeUpdate();
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}
	// 根据书名删除数据
	public int deleteReader(String readerName){	
		List<Reader> list = this.getReaderList(readerName);
		if(null == list || list.size() ==0){
			return 0;
		}
		else{
		
			try {
				// 修改书库中书的数量，减1
				String sql = "DELETE FROM  reader_tb "
						   + "WHERE reader_name = '"+readerName+"'";
				//通过公共类得到连接对象
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				int res= stmt.executeUpdate();
				return res;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			} finally{
				BaseDao.closeAll(conn, stmt, rs);
			}
		}
	}
	
	// 修改图书
	public int modifyReader(Reader book,String oldreaderName){
		String readerName = book.getReaderName();
		String readerSex = book.getReaderSex();
		int readerAge = book.getReaderAge();
		
		
		String sql = "UPDATE reader_tb "
				   + "SET reader_name = '" + readerName+"',"
				   + "reader_age ='" + readerAge+"',"
				   + "reader_sex = '" + readerSex+"'"
				   + " WHERE reader_name = '"+oldreaderName+"'";
		
		try {
			//通过公共类得到连接对象
			conn = BaseDao.getConn();
			stmt =conn.prepareStatement(sql);
			int res= stmt.executeUpdate();
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}
}
