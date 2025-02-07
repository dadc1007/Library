package edu.eci.cvds.tdd.library;

import org.junit.jupiter.api.BeforeAll;

import edu.eci.cvds.tdd.library.book.Book;

public class LibraryTest {
    public LibraryTest() {
        Library library = new Library();
    }

    @BeforeAll
    public void setUp() {
        Book book1 = new Book("El principito", "Antoine de Saint-Exupéry", "978-607-99498-0-8");
        Book book2 = new Book("El principito", "Antoine de Saint-Exupéry", "978-849-83814-9-8");
        Book book3 = new Book("El principito", "Antoine de Saint-Exupéry", "978-847-88871-9-4");
        Book book4 = new Book("cien años de soledad", "Gabriel García Márquez", "978-849-75922-0-8");
        Book book5 = new Book("Don Quijote de la Mancha", "Miguel de Cervantes", "978-958-30044-4-5");
    }
}
