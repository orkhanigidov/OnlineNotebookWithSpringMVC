package notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notebook.business.NoteDao;
import notebook.model.Note;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteDao dao;
	
	@Override
	public int remove(int id) {
		return dao.remove(id);
	}

	@Override
	public Note create(Note note) {
		return dao.create(note);
	}

	@Override
	public int update(Note note) {
		return dao.update(note);
	}

	@Override
	public List<Note> getAll() {
		return dao.getAll();
	}

	@Override
	public Note getNoteById(int id) {
		return dao.getNoteById(id);
	}
	
	@Override
	public List<Note> search(String title) {
		return dao.search(title);
	}

}
