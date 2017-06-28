package notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notebook.model.Note;
import notebook.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository repository;
	
	@Override
	public int remove(int id) {
		return repository.remove(id);
	}

	@Override
	public Note create(Note note) {
		return repository.create(note);
	}

	@Override
	public int update(Note note) {
		return repository.update(note);
	}

	@Override
	public List<Note> getAll() {
		return repository.getAll();
	}

	@Override
	public Note getNoteById(int id) {
		return repository.getNoteById(id);
	}
	
	@Override
	public List<Note> search(String title) {
		return repository.search(title);
	}

}
