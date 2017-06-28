package notebook.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import notebook.database.Close;
import notebook.database.DBConnection;
import notebook.database.DBQuery;
import notebook.model.Note;
import notebook.util.Resize;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private DBQuery query = null;

	private java.util.Date d = new java.util.Date();
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public NoteRepositoryImpl() {
		query = new DBQuery();
	}

	@Override
	public int remove(int id) {
		int flag = 0;

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.getDeleteNote());
			ps.setInt(1, id);
			flag = ps.executeUpdate();

		} catch (Exception e) {
			Close.close(conn, ps);
		}

		return flag;
	}

	@Override
	public Note create(Note note) {
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.getInsertNote());
			ps.setString(1, note.getTitle());
			ps.setString(2, note.getNote());
			ps.setString(3, note.getDate());

			ps.executeUpdate();

		} catch (Exception e) {
			Close.close(conn, ps);
		}

		return note;
	}

	@Override
	public int update(Note note) {
		int flag = 0;
		note.setDate(format.format(d));

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.getUpdateNote());
			ps.setString(1, note.getTitle());
			ps.setString(2, note.getNote());
			ps.setString(3, note.getDate());
			ps.setInt(4, note.getId());

			flag = ps.executeUpdate();

		} catch (Exception e) {
			Close.close(conn, ps);
		}

		return flag;
	}

	@Override
	public List<Note> getAll() {
		List<Note> notes = new ArrayList<Note>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.getSelectAll());
			rs = ps.executeQuery();

			while (rs.next()) {
				Note note = new Note();
				note.setId(rs.getInt("id"));
				note.setTitle(Resize.resizeTitle(rs.getString("title")));
				note.setNote(Resize.resizeNote(rs.getString("note")));
				note.setDate(rs.getString("date"));

				notes.add(note);
			}

		} catch (Exception e) {
			Close.close(conn, ps, rs);
		}

		return notes;
	}


	@Override
	public Note getNoteById(int id) {
		Note note = new Note();

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.getSelectNoteById());
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.first()) {
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setNote(rs.getString("note"));
				note.setDate(rs.getString("date"));
			}

		} catch (Exception e) {
			Close.close(conn, ps, rs);
		}

		return note;
	}

	@Override
	public List<Note> search(String title) {
		List<Note> notes = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(query.getSearchNote());
			ps.setString(1, title + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				Note n = new Note();
				n.setId(rs.getInt("id"));
				n.setTitle(Resize.resizeTitle(rs.getString("title")));
				n.setNote(Resize.resizeNote(rs.getString("note")));
				n.setDate(rs.getString("date"));

				notes.add(n);
			}

		} catch (Exception e) {
			Close.close(conn, ps, rs);
		}

		return notes;
	}

}
