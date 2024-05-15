package LibraryManagementSystem.LibraryManagement.Services;

import LibraryManagementSystem.LibraryManagement.Model.Book;
import LibraryManagementSystem.LibraryManagement.Model.LibraryCard;
import LibraryManagementSystem.LibraryManagement.Model.Transaction;
import LibraryManagementSystem.LibraryManagement.Repositories.BookRepository;
import LibraryManagementSystem.LibraryManagement.Repositories.CardRepository;
import LibraryManagementSystem.LibraryManagement.Repositories.TransactionRepository;
//import LibraryManagementSystem.LibraryManagement.Enum.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.resource.transaction.spi.TransactionStatus.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private  CardRepository cardRepository;


    public String issueBook(Integer bookId, Integer cardId) throws Exception {
        Book book = bookRepository.findById(bookId).get();


        LibraryCard card = cardRepository.findById(cardId).get();
        Transaction transaction = new Transaction();
//        private TransactionStatus transaction;


        if (book.getIsIssued()) {
            throw new Exception("book is already issued");
        }
        if (card.getNoOfBooksIssued() == 3) {
            throw new Exception("card  Book issue Limit is reached");
        }
        transaction.setTransactionStatus(TransactionStatus.COMMITTED);
        //Set Foreign Key entities (Book and Card)
        transaction.setBook(book);
        transaction.setCard(card);

        //set book to isIssued : True
        book.setIsIssued(true);

        //Set card : noOfBooksIssued + 1
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction = transactionRepository.save(transaction);
        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction is saved with transactionId : "+transaction.getTransactionId();
    }
}
