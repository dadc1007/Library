package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private User user1;
    private User user2;

    private User createUser(String name, String id) {
        User user = new User();
        user.setName(name);
        user.setId(id);

        return user;
    }

    private void addBooks() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
    }

 
    
    @BeforeEach
    public void setUp() {
        library = new Library();

        book1 = new Book("El principito", "Antoine de Saint-Exupéry", "978-607-99498-0-8");
        book2 = new Book("El principito", "Antoine de Saint-Exupéry", "978-607-99498-0-8");
        book3 = new Book("El principito", "Antoine de Saint-Exupéry", "978-607-99498-0-8");
        book4 = new Book("El principito", "Antoine de Saint-Exupéry", "978-847-88871-9-4");
        book5 = new Book("Cien años de soledad", "Gabriel García Márquez", "978-849-75922-0-8");
        book6 = new Book("Don Quijote de la Mancha", "Miguel de Cervantes", "978-958-30044-4-5");

        user1 = createUser("Daniel", "1032373105");
        user2 = createUser("Vicente", "1028461832");

        library.addUser(user1);
        library.addUser(user2);
    }

    @Test
    public void shouldAddBook() {
        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
        assertTrue(library.addBook(book3));
        assertTrue(library.addBook(book4));
        assertTrue(library.addBook(book5));
        assertTrue(library.addBook(book6));
    }

    @Test
    public void shouldIncreaseAmountIfBookExists() {
        library.addBook(book1);
        assertEquals(1,  library.getNumberBooks(book1));
        library.addBook(book2);
        assertEquals(2,  library.getNumberBooks(book2));
        library.addBook(book3);
        assertEquals(3,  library.getNumberBooks(book3));
    }

    @Test
    public void shouldAmountBeOneForNewBook() {
        library.addBook(book1);
        assertEquals(1,  library.getNumberBooks(book1));
        library.addBook(book4);
        assertEquals(1,  library.getNumberBooks(book4));
        library.addBook(book5);
        assertEquals(1,  library.getNumberBooks(book5));
        library.addBook(book6);
        assertEquals(1,  library.getNumberBooks(book6));
    }

    @Test
    public void shouldLoanABook() {
        addBooks();

        // Loan to Daniel
        Loan loan1 = library.loanABook("1032373105", "978-607-99498-0-8");
        assertNotNull(loan1);
        assertEquals(LoanStatus.ACTIVE, loan1.getStatus());
        assertEquals("1032373105", loan1.getUser().getId());
        assertEquals("978-607-99498-0-8", loan1.getBook().getIsbn());

        Loan loan2 = library.loanABook("1032373105", "978-847-88871-9-4");
        assertNotNull(loan2);
        assertEquals(LoanStatus.ACTIVE, loan2.getStatus());
        assertEquals("1032373105", loan2.getUser().getId());
        assertEquals("978-847-88871-9-4", loan2.getBook().getIsbn());
        
        // Loan to Vicente
        Loan loan3 = library.loanABook("1028461832", "978-849-75922-0-8");
        assertNotNull(loan3);
        assertEquals(LoanStatus.ACTIVE, loan3.getStatus());
        assertEquals("1028461832", loan3.getUser().getId());
        assertEquals("978-849-75922-0-8", loan3.getBook().getIsbn());
    }
    
    @Test
    public void notShouldLoanABookIfIsNotAvailable() {
        addBooks();
        
        // Loan to Daniel
        library.loanABook("1032373105", "978-847-88871-9-4");
        library.loanABook("1032373105", "978-849-75922-0-8");
        library.loanABook("1032373105", "978-958-30044-4-5");
        
        // Cannot loan to Vicente
        Loan loan4 = library.loanABook("1028461832", "978-847-88871-9-4");
        assertNull(loan4);
        Loan loan5 = library.loanABook("1028461832", "978-849-75922-0-8");
        assertNull(loan5);
        Loan loan6 = library.loanABook("1028461832", "978-958-30044-4-5");
        assertNull(loan6);
    }

    @Test
    public void notShouldLoanABookIfUserNotExist() {
        addBooks();

        Loan loan1 = library.loanABook("1028366452", "978-607-99498-0-8");
        assertNull(loan1);
        
        Loan loan2 = library.loanABook("1029938226", "978-849-75922-0-8");
        assertNull(loan2);
    }

    @Test
    public void notShouldLoanABookForTheSameBook() {
        addBooks();
        
        library.loanABook("1032373105", "978-607-99498-0-8");
        Loan loan2 = library.loanABook("1032373105", "978-607-99498-0-8");
        assertNull(loan2);

        library.loanABook("1028461832", "978-607-99498-0-8");
        Loan loan4 = library.loanABook("1028461832", "978-607-99498-0-8");
        assertNull(loan4);
    }

    @Test
    public void shouldDecreaseBookCountWhenLoanIsCreated() {
        addBooks();

        assertEquals(3, library.getNumberBooks("978-607-99498-0-8"));
        library.loanABook("1032373105", "978-607-99498-0-8");
        assertEquals(2, library.getNumberBooks("978-607-99498-0-8"));
        library.loanABook("1028461832", "978-607-99498-0-8");
        assertEquals(1, library.getNumberBooks("978-607-99498-0-8"));
        
        assertEquals(1, library.getNumberBooks("978-849-75922-0-8"));
        library.loanABook("1032373105", "978-849-75922-0-8");
        assertEquals(0, library.getNumberBooks("978-849-75922-0-8"));

        assertEquals(1, library.getNumberBooks("978-958-30044-4-5"));
        library.loanABook("1028461832", "978-958-30044-4-5");
        assertEquals(0, library.getNumberBooks("978-958-30044-4-5"));
    }

    @Test
    public void shouldIncreasedBookCountWhenLoanIsReturned(){
        addBooks();

        Loan loan1 = library.loanABook("1032373105", "978-607-99498-0-8");
        Loan loan2 = library.loanABook("1028461832", "978-607-99498-0-8");
        Loan loan3 = library.loanABook("1032373105", "978-849-75922-0-8");
        Loan loan4 = library.loanABook("1028461832", "978-958-30044-4-5");

        assertEquals(1, library.getNumberBooks("978-607-99498-0-8"));
        library.returnLoan(loan1);
        assertEquals(2, library.getNumberBooks("978-607-99498-0-8"));
        library.returnLoan(loan2);
        assertEquals(3, library.getNumberBooks("978-607-99498-0-8"));

        assertEquals(0, library.getNumberBooks("978-849-75922-0-8"));
        library.returnLoan(loan3);
        assertEquals(1, library.getNumberBooks("978-849-75922-0-8"));

        assertEquals(0, library.getNumberBooks("978-958-30044-4-5"));
        library.returnLoan(loan4);
        assertEquals(1, library.getNumberBooks("978-958-30044-4-5"));
    }

    @Test
    public void shouldReturnLoan(){
        addBooks();

        Loan loan1 = library.loanABook("1032373105", "978-607-99498-0-8");
        Loan loan2 = library.loanABook("1028461832", "978-607-99498-0-8");
        Loan loan3 = library.loanABook("1032373105", "978-849-75922-0-8");
        Loan loan4 = library.loanABook("1028461832", "978-958-30044-4-5");

        library.returnLoan(loan1);
        assertEquals(LoanStatus.RETURNED, loan1.getStatus());

        library.returnLoan(loan2);
        assertEquals(LoanStatus.RETURNED, loan2.getStatus());

        library.returnLoan(loan3);
        assertEquals(LoanStatus.RETURNED, loan3.getStatus());

        library.returnLoan(loan4);
        assertEquals(LoanStatus.RETURNED, loan4.getStatus());
    }
}
