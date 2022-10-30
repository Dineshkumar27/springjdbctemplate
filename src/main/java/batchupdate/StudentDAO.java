package batchupdate;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource ds);

	public List<Student> listStudents();

	public void batchInsert(final List<Student> students);

	public void batchUpdate(final List<Student> students);

}
