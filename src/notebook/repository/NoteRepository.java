package notebook.repository;

import java.util.List;

import notebook.model.Note;

public interface NoteRepository {

	public int remove(int id);

	public Note create(Note note);

	public int update(Note note);

	public List<Note> getAll();

	public Note getNoteById(int id);
	
	public List<Note> search(String title);

}
