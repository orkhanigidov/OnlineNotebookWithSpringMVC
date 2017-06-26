package notebook.util;

public class Resize {
	
	public static  String resizeNote(String note) {
		return note.length() <= 20 ? note.substring(0, note.length()) : note.substring(0, 21);
	}
	
	public static String resizeTitle(String title){
		return title.length() <= 12 ? title.substring(0, title.length()) : title.substring(0, 13);
	}
	
}
