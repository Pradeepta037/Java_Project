public class Library {
    private Book[] books;
    private int bookCount;
    private Borrower[] borrowers;
    private int borrowerCount;

    public Library(int bookCapacity, int borrowerCapacity) {
        this.books = new Book[bookCapacity];
        this.bookCount = 0;
        this.borrowers = new Borrower[borrowerCapacity];
        this.borrowerCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i] = books[--bookCount];
                books[bookCount] = null;
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void registerBorrower(Borrower borrower) {
        if (borrowerCount < borrowers.length) {
            borrowers[borrowerCount++] = borrower;
        } else {
            System.out.println("Library is full. Cannot register more borrowers.");
        }
    }

    public void borrowBook(String title, String borrowerName) {
        Book book = findBookByTitle(title);
        Borrower borrower = findBorrowerByName(borrowerName);

        if (book != null && book.isAvailable() && borrower != null) {
            borrower.borrowBook(book);
            System.out.println(borrowerName + " borrowed \"" + title + "\".");
        } else {
            System.out.println("Book not available or borrower not found.");
        }
    }

    public void returnBook(String title, String borrowerName) {
        Book book = findBookByTitle(title);
        Borrower borrower = findBorrowerByName(borrowerName);

        if (book != null && borrower != null && !book.isAvailable()) {
            borrower.returnBook(book);
            System.out.println(borrowerName + " returned \"" + title + "\".");
        } else {
            System.out.println("Book not borrowed by this borrower or book not found.");
        }
    }

    public void searchBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private Book findBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    private Borrower findBorrowerByName(String name) {
        for (int i = 0; i < borrowerCount; i++) {
            if (borrowers[i].getName().equalsIgnoreCase(name)) {
                return borrowers[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Books in Library:\n");
        for (int i = 0; i < bookCount; i++) {
            sb.append(books[i]).append("\n");
        }
        sb.append("Borrowers:\n");
        for (int i = 0; i < borrowerCount; i++) {
            sb.append(borrowers[i]).append("\n");
        }
        return sb.toString();
    }
}
