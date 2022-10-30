package batchupdate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<Student> listStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	public void batchUpdate(final List<Student> students) {
		String SQL = "update Student set age = ?,name=? where id = ?";
		int[] updateCounts = jdbcTemplateObject.batchUpdate(SQL, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, students.get(i).getAge());
				ps.setString(2, students.get(i).getName());
				ps.setInt(3, students.get(i).getId());

			}

			public int getBatchSize() {
				return students.size();
			}
		});
		System.out.println("Records updated!");
	}

	public void batchInsert(final List<Student> students) {

		String sql = "INSERT INTO student (id,age,name)" + " VALUES(?,?,?)";

		jdbcTemplateObject.batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Student student = students.get(i);
				ps.setInt(1, student.getId());
				ps.setInt(2, student.getAge());
				ps.setString(3, student.getName());

			}

			public int getBatchSize() {
				return students.size();
			}
		});
	}
}
