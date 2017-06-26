package notebook.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Note {
	private int id;
	private String title;
	private String note;
	private String date;
	
	private java.util.Date d = new java.util.Date();
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public Note() {
		this.date = format.format(d);
	}

	public Note(int id, String title, String note) {
		this.id = id;
		this.title = title;
		this.note = note;
		this.date = format.format(d);
	}

	public Note(String title, String note) {
		this.title = title;
		this.note = note;
		this.date = format.format(d);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Note";
	}
	
}
