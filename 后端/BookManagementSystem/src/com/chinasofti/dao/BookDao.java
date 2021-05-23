package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chinasofti.entity.Book;
/**
 * 
 * @author 林镕琛
 * @version 1.0
 * 将书籍对于在数据库的增删改查写在该类中
 */
public class BookDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	

	// 根据页数和书名进行获取书籍数据
		public List<Book> getBookList(String bookName,int pn, int rn){	
			String sql = "select * from book_tb where book_name like ? limit ?,? ";
			List<Book> list = new ArrayList<Book>();
			try {
				//通过公共类得到连接对象
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				if(bookName==null){
					bookName = "%";
				}
				else{
					bookName = "%"+bookName+"%";
				}		
				stmt.setString(1, bookName);
				stmt.setInt(2, (pn-1)*rn);
				stmt.setInt(3, rn);
				rs = stmt.executeQuery();
				while(rs.next()){
					int bookID = rs.getInt("book_id");
					bookName = rs.getString("book_name");
					String bookPublisher = rs.getString("book_publisher");
					String bookAuthor = rs.getString("book_Author");
					Book book = new Book(bookID, bookName, bookAuthor, bookPublisher);			
					list.add(book);
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
	
	
	// 根据书籍的ID查询数据
		public List<Book> getBookList(int bookID){
			String sql = "select * from book_tb where book_id = ? ";
			List<Book> list = new ArrayList<Book>();		
			try {
				//通过公共类得到连接对象
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);	
				stmt.setInt(1, bookID);
				rs = stmt.executeQuery();
				while(rs.next()){
					String bookName = rs.getString("book_name");
					String bookPublisher = rs.getString("book_publisher");
					String bookAuthor = rs.getString("book_Author");
					Book book = new Book(bookID, bookName, bookAuthor, bookPublisher);			
					list.add(book);
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
	
	// 根据页数进行获取书籍数据
	public List<Book> getBookList(int pn, int rn){
		String sql = "select * from book_tb limit ?,?";
		List<Book> list = new ArrayList<Book>();	
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pn-1)*rn);
			stmt.setInt(2, rn);
			rs = stmt.executeQuery();
			while(rs.next()){
				int bookID = rs.getInt("book_id");
				String bookName = rs.getString("book_name");
				String bookPublisher = rs.getString("book_publisher");
				String bookAuthor = rs.getString("book_Author");
				Book book = new Book(bookID, bookName, bookAuthor, bookPublisher);			
				list.add(book);
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
	
	
	// 获取书籍数据条数
		public int count(){
			String sql = "select count(*) num from book_tb ";
			try {
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()){
					return rs.getInt("num");
				}
				return 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			} finally{
				BaseDao.closeAll(conn, stmt, rs);
			}
		}
	
	// 根据书名获取书籍数据条数，用于查询时的分页显示
	public int count(String bookName){
		String sql = "select count(*) num from book_tb where book_name like ?";
		try {
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			if(bookName==null){
				bookName = "%";
			}
			else{
				bookName = "%"+bookName+"%";
			}		
			stmt.setString(1, bookName);
			rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt("num");
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}
	}
	
	// 获取所有书籍数据
	public List<Book> getBookList(){
		String sql = "select * from book_tb ";
		List<Book> list = new ArrayList<Book>();
		
		try {
			//通过公共类得到连接对象
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				int bookID = rs.getInt("book_id");
				String bookName = rs.getString("book_name");
				String bookPublisher = rs.getString("book_publisher");
				String bookAuthor = rs.getString("book_Author");
				Book book = new Book(bookID, bookName, bookAuthor, bookPublisher);			
				list.add(book);
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
	
	// 添加图书，传入Book对象
	public int addBook(Book book){
		String bookName = book.getBookName();
		String bookPublisher = book.getBookPublisher();
		String bookAuthor = book.getBookAuthor();
		System.out.println(bookAuthor);
		String sql = "INSERT INTO book_tb (book_name, book_author,book_publisher) "	
				   + "values('"+bookName+"'"
				   + ",'"+bookAuthor+"'"
				   + ",'"+bookPublisher+"' )";	
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
	
	
	// 根据书的ID删除数据
	public int deleteBook(int bookID){	
		List<Book> list = this.getBookList(bookID);
		if(null == list || list.size() ==0){
			return 0;
		}
		else{	
			try {
				// 修改书库中书的数量，减1
				String sql = "DELETE FROM  book_tb "
						   + "WHERE book_id = '"+bookID+"'";
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
	
	
	// 传入旧书的ID和新书的数据进行修改图书
	public int modifyBook(Book book,int bookID){
		String bookName = book.getBookName();
		String bookPublisher = book.getBookPublisher();
		String bookAuthor = book.getBookAuthor();	
		String sql = "UPDATE book_tb "
				   + "SET book_name = '" + bookName+"',"
				   + "book_author ='" + bookAuthor+"',"
				   + "book_publisher = '" + bookPublisher+"'"
				   + " WHERE book_id = '"+bookID+"'";
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
