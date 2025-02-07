package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.eci.cvds.tdd.library.book.Book;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    
    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("El principito", "Antoine de Saint-Exupéry", "978-607-99498-0-8");
        book2 = new Book("El principito", "Antoine de Saint-Exupéry", "978-849-83814-9-8");
        book3 = new Book("El principito", "Antoine de Saint-Exupéry", "978-847-88871-9-4");
        book4 = new Book("cien años de soledad", "Gabriel García Márquez", "978-849-75922-0-8");
        book5 = new Book("Don Quijote de la Mancha", "Miguel de Cervantes", "978-958-30044-4-5");
    }

    @Test
    public void shouldAddBook() {
        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
        assertTrue(library.addBook(book3));
        assertTrue(library.addBook(book4));
        assertTrue(library.addBook(book5));
    }
}
