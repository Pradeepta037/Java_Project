public class Borrower {
    private String name;
    private Book[] borrowedBooks;
    private int borrowedCount;

    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new Book[10]; // Assume a borrower can borrow up to 10 books
        this.borrowedCount = 0;
    }

    public String getName() {
        return name;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void borrowBook(Book book) {
        if (borrowedCount < borrowedBooks.length) {
            borrowedBooks[borrowedCount++] = book;
            book.setAvailable(false);
        } else {
            System.out.println("Borrower has reached the maximum number of borrowed books.");
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] == book) {
                borrowedBooks[i] = borrowedBooks[--borrowedCount];
                borrowedBooks[borrowedCount] = null;
                book.setAvailable(true);
                return;
            }
        }
        System.out.println("This book was not borrowed by this borrower.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(", Borrowed Books: ");
        for (int i = 0; i < borrowedCount; i++) {
            sb.append(borrowedBooks[i].getTitle()).append(", ");
        }
        return sb.toString();
    }
}
