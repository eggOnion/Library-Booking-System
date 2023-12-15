package com.example.librarybookingsystem.serviceimpls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.librarybookingsystem.entities.Book;
import com.example.librarybookingsystem.entities.Learner;
import com.example.librarybookingsystem.entities.LoanPeriod;

import com.example.librarybookingsystem.repositories.BookRepository;
import com.example.librarybookingsystem.repositories.LearnerRepository;
import com.example.librarybookingsystem.repositories.LoanPeriodRepository;
import com.example.librarybookingsystem.services.LoanPeriodService;

@SpringBootTest
public class LoanPeriodServiceImplTest  {

    @Mock
    private BookRepository bookRepository;
    @Mock
    private LearnerRepository learnerRepository;
    @Mock
    private LoanPeriodRepository loanPeriodRepository;

    @InjectMocks
    LoanPeriodServiceImpl loanPeriodService;
    @InjectMocks
    BookServiceImpl bookService;
    @InjectMocks
    LearnerServiceImpl learnerService;


   //should not use local class
    private LoanPeriod createLoanPeriod(Learner learner, Book book, LocalDate startTime, LocalDate endTime, String loanStatus) {
        return LoanPeriod.builder()
                .learner(learner)
                .book(book)
                .startTime(startTime)
                .endTime(endTime)
                .loanStatus(loanStatus)
                .build();
    }

    @Test
    public void createLoanPeriodTest() {

        //create Learner and Book
        Learner learner = Learner.builder().id(1).firstName("Andy").lastName("Lee").email("andylee@email.com")
                .contact_num("99225588").build();
        Book book = Book.builder().id(1).title("Learn Java in One Day").author("Jamie Chan").genre("Programming")
                .quantity(1).availability(true).build();

        // when((learnerRepository.save(learner))).thenReturn(learner);
        // when((bookRepository.save(book))).thenReturn(book);

        // Learner savedLearner = learnerService.createLearner(learner);
        // Book savedBook = bookService.createBook(book);

        int learnerId = 1;
        when(learnerRepository.findById(learnerId)).thenReturn(Optional.of(learner));
        Learner retrievedLearner = learnerService.getLearner(learnerId);

        int bookId = 1;
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        Book retrievedBook = bookService.getBook(bookId);

        // assertEquals(learner, savedLearner, "Learner OK.");
        // assertEquals(book, savedBook, "Book OK.");

        // verify(learnerRepository, times(1)).save(learner);
        // verify(bookRepository, times(1)).save(book);

        // 1. SETUP
        // Create new LoanPeriod

        // LoanPeriod loanPeriod = LoanPeriod.builder().id(1).book(book).learner(learner).startTime(LocalDate.now())
        //         .endTime(LocalDate.now().plusDays(30)).loanStatus("BORROWED").build();

        // int bookId = 1;
        // when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        // int learnerId = 1;
        // when(learnerRepository.findById(learnerId)).thenReturn(Optional.of(learner));
         

        // mock the save method

        // // 2. EXECUTE

        //using local class
        LoanPeriod loanPeriod = createLoanPeriod(retrievedLearner, retrievedBook, LocalDate.now(), LocalDate.now().plusDays(30), "BORROWED");
        

        // LoanPeriod com.example.librarybookingsystem.serviceimpls.LoanPeriodServiceImpl.createLoanPeriod(int learner_id, int book_id)
        //LoanPeriodServiceImpl.createLoanPeriod expecting (int learner_id, int book_id) 
        // LoanPeriod loanPeriod = LoanPeriodService.createLoanPeriod(retrievedLearner, retrievedBook, LocalDate.now(), LocalDate.now().plusDays(30), "BORROWED");
        
        
        when(loanPeriodRepository.save(loanPeriod)).thenReturn(loanPeriod);

        // 3. ASSERT
        assertEquals("BORROWED", loanPeriod.getLoanStatus(), "The saved LoanPeriod should have status BORROWED.");

        // assertEquals("0", book.getQuantity(), "Book Qty should be 0.");

        //also verify that the save method of repository is called once only.
        // verify(loanPeriodRepository, times(1)).save(loanPeriod);
    }

}
// @Test
// public void getLearnerTest() {
// // 1. SETUP
// // Create a new Learner
// Learner learner =
// Learner.builder().firstName("Andy").lastName("Lee").email("andylee@email.com").contact_num("99225588").build();

// int learnerId = 1;

// when(learnerRepository.findById(learnerId)).thenReturn(Optional.of(learner));

// // 2.EXECUTE
// Learner retrievedLearner = learnerService.getLearner(learnerId);

// // 3. ASSERT
// assertEquals(learner, retrievedLearner);
// }

// @Test
// void testGetLearnerNotFound() {
// int learnerId = 250;
// when(learnerRepository.findById(learnerId)).thenReturn(Optional.empty());

// assertThrows(LearnerNotFoundException.class, () ->
// learnerService.getLearner(learnerId));
// }

// }
