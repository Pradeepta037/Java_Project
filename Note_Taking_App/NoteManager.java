public class NoteManager {
    private Note[] notes;
    private int size;

    public NoteManager(int capacity) {
        notes = new Note[capacity];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= notes.length) {
            int newCapacity = notes.length * 2;
            Note[] newNotes = new Note[newCapacity];
            System.arraycopy(notes, 0, newNotes, 0, notes.length);
            notes = newNotes;
        }
    }

    public void addNote(Note note) {
        ensureCapacity();
        notes[size++] = note;
    }

    public void deleteNoteByTitle(String title) {
        int index = findNoteIndexByTitle(title);
        if (index != -1) {
            System.arraycopy(notes, index + 1, notes, index, size - index - 1);
            notes[--size] = null;
        }
    }

    public void editNote(String oldTitle, Note newNote) {
        int index = findNoteIndexByTitle(oldTitle);
        if (index != -1) {
            notes[index] = newNote;
        }
    }

    public Note searchNoteByTitle(String title) {
        int index = findNoteIndexByTitle(title);
        if (index != -1) {
            return notes[index];
        }
        return null;
    }

    public Note[] getNotesByCategory(String category) {
        Note[] categorizedNotes = new Note[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (notes[i].getCategory().equalsIgnoreCase(category)) {
                categorizedNotes[count++] = notes[i];
            }
        }
        return trimArray(categorizedNotes, count);
    }

    private int findNoteIndexByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (notes[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    private Note[] trimArray(Note[] array, int length) {
        Note[] trimmedArray = new Note[length];
        System.arraycopy(array, 0, trimmedArray, 0, length);
        return trimmedArray;
    }

    public void listAllNotes() {
        if (size == 0) {
            System.out.println("No notes available.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(notes[i]);
                System.out.println("-----------------------------");
            }
        }
    }
}
