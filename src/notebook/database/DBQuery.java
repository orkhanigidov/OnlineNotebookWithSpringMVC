package notebook.database;

import java.io.InputStream;
import java.util.Properties;

public class DBQuery {

	private Properties prop = null;
	private InputStream is = null;

	private String selectAll = "";
	private String selectNoteById = "";
	private String deleteNote = "";
	private String updateNote = "";
	private String insertNote = "";
	private String searchNote = "";

	public DBQuery() {
		try {
			prop = new Properties();
			is = this.getClass().getClassLoader().getResourceAsStream("resources/db_query.properties");
			prop.load(is);

			setSelectAll(prop.getProperty("selectAll"));
			setSelectNoteById(prop.getProperty("selectNoteById"));
			setDeleteNote(prop.getProperty("deleteNote"));
			setUpdateNote(prop.getProperty("updateNote"));
			setInsertNote(prop.getProperty("insertNote"));
			setSearchNote(prop.getProperty("searchNote"));
		} catch (Exception e) {
			// use logging
			System.out.println(e.getMessage());
		}
	}

	public String getSelectAll() {
		return selectAll;
	}

	public void setSelectAll(String selectAll) {
		this.selectAll = selectAll;
	}

	public String getSelectNoteById() {
		return selectNoteById;
	}

	public void setSelectNoteById(String selectNoteById) {
		this.selectNoteById = selectNoteById;
	}

	public String getDeleteNote() {
		return deleteNote;
	}

	public void setDeleteNote(String deleteNote) {
		this.deleteNote = deleteNote;
	}

	public String getUpdateNote() {
		return updateNote;
	}

	public void setUpdateNote(String updateNote) {
		this.updateNote = updateNote;
	}

	public String getInsertNote() {
		return insertNote;
	}

	public void setInsertNote(String insertNote) {
		this.insertNote = insertNote;
	}

	public String getSearchNote() {
		return searchNote;
	}

	public void setSearchNote(String searchNote) {
		this.searchNote = searchNote;
	}

	@Override
	public String toString() {
		return "DBQuery Class";
	}
}
