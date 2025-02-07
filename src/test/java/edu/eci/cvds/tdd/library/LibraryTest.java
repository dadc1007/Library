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
    private User user1;
    private User user2;

    private User createUser(String name, String id) {
        User user = new User();
        user.setName(name);
        user.setId(id);

        return user;
    }
    
    @BeforeEach
    public void setUp() {
        library = new Library();

        book1 = new Book("El principito", "Antoine de Saint-Exupéry", "978-607-99498-0-8");
        book2 = new Book("El principito", "Antoine de Saint-Exupéry", "978-849-83814-9-8");
        book3 = new Book("El principito", "Antoine de Saint-Exupéry", "978-847-88871-9-4");
        book4 = new Book("cien años de soledad", "Gabriel García Márquez", "978-849-75922-0-8");
        book5 = new Book("Don Quijote de la Mancha", "Miguel de Cervantes", "978-958-30044-4-5");

        user1 = createUser("Daniel", "1032373105");
        user2 = createUser("Vicente", "1028461832");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.addUser(user1);
        library.addUser(user2);
    }

    @Test
    public void shouldAddBook() {
        Library tempLibrary = new Library();

        assertTrue(tempLibrary.addBook(book1));
        assertTrue(tempLibrary.addBook(book2));
        assertTrue(tempLibrary.addBook(book3));
        assertTrue(tempLibrary.addBook(book4));
        assertTrue(tempLibrary.addBook(book5));
    }

    @Test
    public void shouldIncreaseAmountIfBookExists() {
        library.addBook(book1);
        assertEquals(1,  library.getNumberBooks("El principito"));
        library.addBook(book2);
        assertEquals(2,  library.getNumberBooks("El principito"));
    }

    @Test
    public void shouldLoanABook() {
        // Loan to Daniel
        Loan loan1 = library.loanABook("1032373105", "978-607-99498-0-8");
        assertNotNull(loan1);
        assertEquals(LoanStatus.ACTIVE, loan1.getStatus());
        assertEquals("1032373105", loan1.getUser().getId());
        assertEquals("978-607-99498-0-8", loan1.getBook().getIsbn());
        
        // Loan to Vicente
        Loan loan2 = library.loanABook("1028461832", "978-849-75922-0-8");
        assertNotNull(loan2);
        assertEquals(LoanStatus.ACTIVE, loan2.getStatus());
        assertEquals("1028461832", loan2.getUser().getId());
        assertEquals("978-849-75922-0-8", loan2.getBook().getIsbn());
    }

    @Test
    public void notShouldLoanABookIfUserNotExist() {
        Loan loan1 = library.loanABook("1028366452", "978-849-83814-9-8");
        assertNull(loan1);
        
        Loan loan2 = library.loanABook("1029938226", "978-958-30044-4-5");
        assertNull(loan2);
    }

    @Test
    public void notShouldLoanABookForTheSameBook() {
        Loan loan1 = library.loanABook("1032373105", "978-607-99498-0-8");
        Loan loan2 = library.loanABook("1028461832", "978-607-99498-0-8");
        assertNull(loan2);

        Loan loan3 = library.loanABook("1028461832", "978-849-75922-0-8");
        Loan loan4 = library.loanABook("1032373105", "978-607-99498-0-8");
        assertNull(loan4);
    }
}
