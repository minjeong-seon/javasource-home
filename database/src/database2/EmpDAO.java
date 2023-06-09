package database2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "TIGER";
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//select - many : ArrayList 리턴
	public ArrayList<EmpDTO> getList(String ename) {
		ArrayList<EmpDTO> list = new ArrayList<>();
		try {
			con=getConnection();
			//ename = 김도일인 사람 (empno, ename, job, hiredate)조회
			String sql = "select empno, ename, job, hiredate from emp_temp where ename = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setHirdate(rs.getDate(4));
				
				list.add(empDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	//select -one : DTO 리턴
	public EmpDTO getrow(int empno) {
		EmpDTO empDTO =null;
		try {
			con=getConnection();
			//where절에 pk(primary key: 기본키 = 중복불가, null불가)가 조건으로 들어오는 경우:  무조건 하나의 행이 나옴
			//empno(pk), deptno(pk)
			String sql = "select empno, ename, job, sal, comm, deptno from emp_temp where empno = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setSal(rs.getInt(4));
				empDTO.setComm(rs.getInt(5));
				empDTO.setDeptno( rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return empDTO;
	}

	
	//급여 수정
	public boolean update(int sal, int empno) {
		boolean status = false;
		try {
			con = getConnection();
			//사번이 일치하면 급여 수정
			String sql = "update emp_temp set sal = ? where empno = ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sal);
			pstmt.setInt(2, empno);
			int result = pstmt.executeUpdate();
			if(result>0) status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return status;
	}
	
	
	//사원 정보 삭제
	public boolean delete(int empno) {
		boolean status = false;
		try {
			con=getConnection();
			String sql="delete from emp_temp where empno = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			int result = pstmt.executeUpdate();
			if(result>0) status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return status;
	}
	
	
	public boolean insert (EmpDTO dto) {
		boolean status = false;
		try {
			con=getConnection();
			String sql = "insert into emp_temp(empno, ename, job, mgr, hiredate, sal, comm,deptno) values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setInt(4, dto.getMgr());
			pstmt.setDate(5, dto.getHirdate());
			pstmt.setInt(6, dto.getSal());
			pstmt.setInt(7, dto.getComm());
			pstmt.setInt(8, dto.getDeptno());
			int result = pstmt.executeUpdate();
			if(result>0) status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}		
		return status;
	}
	
	//사원 추가(입사일=시스템 날짜)
//	public boolean insert(EmpDTO dto) {
//		boolean status = false;
//		try {
//			//오늘 입사한 사원에 대한 정보 입력
//			con=getConnection();
//			String sql = "insert into emp_temp(empno, ename, job, mgr, hiredate, sal, comm,deptno) values(?,?,?,?,sysdate,?,?,?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, dto.getEmpno());
//			pstmt.setString(2, dto.getEname());
//			pstmt.setString(3, dto.getJob());
//			pstmt.setInt(4, dto.getMgr());
//			pstmt.setInt(5, dto.getSal());
//			pstmt.setInt(6, dto.getComm());
//			pstmt.setInt(7, dto.getDeptno());
//			int result = pstmt.executeUpdate();
//			if(result>0) status = true;		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(con, pstmt);
//		}
//		return status;
//	}
	
}
