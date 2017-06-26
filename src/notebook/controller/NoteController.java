package notebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notebook.model.Note;
import notebook.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService service;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView getNoteForCreate(Note note) {
		return new ModelAndView("create_note", "command", note);
	}

	@RequestMapping(value = "/create", params = "createSaveBtn", method = RequestMethod.POST)
	public ModelAndView create(Note note) {
		return new ModelAndView("redirect:/", "create", service.create(note));
	}

	@RequestMapping(value = "/create", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelCreate() {
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView getNoteForUpdate(@PathVariable("id") int id) {
		return new ModelAndView("update_note", "command", service.getNoteById(id));
	}

	@RequestMapping(value = "/update", params = "updateSaveBtn", method = RequestMethod.POST)
	public ModelAndView update(Note note) {
		return new ModelAndView("redirect:/", "update", service.update(note));
	}

	@RequestMapping(value = "/update", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelUpdate() {
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public ModelAndView getNoteForRead(@PathVariable("id") int id) {
		Note note = service.getNoteById(id);
		return new ModelAndView("read_note", "note", note);
	}

	@RequestMapping(value = "/read", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelRead() {
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllNote() {
		return new ModelAndView("index", "notes", service.getAll());
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("title") String title) {
		return new ModelAndView("search", "search", service.search(title));
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ModelAndView remove(@PathVariable(value = "id") int id) {
		return new ModelAndView("redirect:/", "remove", service.remove(id));
	}

}
