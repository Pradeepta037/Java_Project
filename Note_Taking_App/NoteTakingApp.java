import java.util.Scanner;

public class NoteTakingApp {
    private static NoteManager noteManager = new NoteManager(10);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Note Taking App");
            System.out.println("1. Add Note");
            System.out.println("2. Delete Note");
            System.out.println("3. Edit Note");
            System.out.println("4. Search Note");
            System.out.println("5. List Notes by Category");
            System.out.println("6. List All Notes");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    deleteNote();
                    break;
                case 3:
                    editNote();
                    break;
                case 4:
                    searchNote();
                    break;
                case 5:
                    listNotesByCategory();
                    break;
                case 6:
                    listAllNotes();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNote() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        Note note = new Note(title, content, category);
        noteManager.addNote(note);
        System.out.println("Note added.");
    }

    private static void deleteNote() {
        System.out.print("Enter title of note to delete: ");
        String title = scanner.nextLine();
        noteManager.deleteNoteByTitle(title);
        System.out.println("Note deleted.");
    }

    private static void editNote() {
        System.out.print("Enter title of note to edit: ");
        String oldTitle = scanner.nextLine();
        Note existingNote = noteManager.searchNoteByTitle(oldTitle);
        if (existingNote != null) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new content: ");
            String newContent = scanner.nextLine();
            System.out.print("Enter new category: ");
            String newCategory = scanner.nextLine();
            Note newNote = new Note(newTitle, newContent, newCategory);
            noteManager.editNote(oldTitle, newNote);
            System.out.println("Note edited.");
        } else {
            System.out.println("Note not found.");
        }
    }

    private static void searchNote() {
        System.out.print("Enter title of note to search: ");
        String title = scanner.nextLine();
        Note note = noteManager.searchNoteByTitle(title);
        if (note != null) {
            System.out.println(note);
        } else {
            System.out.println("Note not found.");
        }
    }

    private static void listNotesByCategory() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        Note[] notes = noteManager.getNotesByCategory(category);
        if (notes.length == 0) {
            System.out.println("No notes found in this category.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
                System.out.println("-----------------------------");
            }
        }
    }

    private static void listAllNotes() {
        noteManager.listAllNotes();
    }
}
