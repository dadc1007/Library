package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
        } else {
            books.put(book, 1);
        }
        
        return true;
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        User user = getUser(userId);
        Book book = getBook(isbn);
    
        if (user != null && book != null) {
            if (bookAvailable(book) && !hasActiveLoan(user, book)) {
                return createLoan(user, book);
            }
        }
    
        return null;
    }

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        Loan loanReturned = getLoan(loan);

        if(loanReturned != null){
            return actualiceLoan(loanReturned);
        }
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public int getNumberBooks(Book book) {
        return books.get(book);
    }

    public int getNumberBooks(String isbn) {
        Book book = getBook(isbn);

        if (book != null) {
            return books.get(book);
        }

        return 0;
    }

    private User getUser(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        return null;
    }

    private Book getBook(String isbn) {
        Book book = null;

        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            if (entry.getKey().getIsbn().equals(isbn)) {
                book = entry.getKey();
            }
        }

        return book;
    }

    private boolean bookAvailable(Book book) {
        if (books.get(book) > 0) {
            return true;
        }

        return false;
    }

    private boolean hasActiveLoan(User user, Book book) {
        for (Loan loan : loans) {
            if (loan.getUser().equals(user) && loan.getBook().equals(book) && loan.getStatus() == LoanStatus.ACTIVE) {
                return true;
            }
        }

        return false;
    }

    private void decreaseBookCount(Book book) {
        books.put(book, books.get(book) - 1);
    }

    private void increaseBookCount(Book book) {
        books.put(book, books.get(book) + 1);
    }

    private Loan createLoan(User user, Book book) {
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStatus(LoanStatus.ACTIVE);
        loan.setLoanDate(LocalDateTime.now());

        decreaseBookCount(book);
        loans.add(loan);

        return loan;
    }

    private Loan getLoan(Loan loan){
        for (Loan loan2:loans){
            if(loan.equals(loan2)){
                return loan2;
            }
        }
        return null;
    }

    private Loan actualiceLoan(Loan loan){
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        increaseBookCount(loan.getBook());
        return loan;
    }
}