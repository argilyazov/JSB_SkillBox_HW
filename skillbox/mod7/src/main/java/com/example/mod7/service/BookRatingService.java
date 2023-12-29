package com.example.mod7.service;

import com.example.mod7.data.book.Book;
import com.example.mod7.data.book.BookRating;
import com.example.mod7.data.dto.BookRatingDTO;
import com.example.mod7.repository.BookRatingRepository;
import com.example.mod7.repository.BookRepository;
import com.example.mod7.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@AllArgsConstructor
public class BookRatingService {
    @Autowired
    private BookRatingRepository bookRatingRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;

    public boolean rateBook(Integer userId, Integer bookId, short rating) {
        var book = bookRepository.findById(bookId);
        var user = userEntityRepository.findById(userId);


        if (book.isPresent() && user.isPresent() && 1 <= rating && rating <= 5) {
            var bk = bookRatingRepository.findAllByBookAndUser(book.get(), user.get());
            var ids = new ArrayList<Long>();

            for(var bkItem : bk)
                ids.add(bkItem.getId());

            if(!ids.isEmpty())
                bookRatingRepository.deleteAllById(ids);

            var brating = new BookRating();
            brating.setRating(rating);
            brating.setBook(book.get());


            brating.setUser(user.get());

            bookRatingRepository.save(brating);
            return true;
        }
        return false;
    }

    public BookRatingDTO getRatingByBook(Book book) {
        var bookRating = bookRatingRepository.getBookRating(book.getId());
        var sum = 0;
        var bookRatingDTO = new BookRatingDTO();

        bookRatingDTO.setRating(bookRating.orElse(0));
        for (int i = 1; i <= 5; i++) {
            var bookRatingForX = bookRatingRepository.countUsersByRating(book.getId(), i);
            bookRatingDTO.getUsersCountByRating().put(i, bookRatingForX.orElse(0));
            sum += bookRatingForX.orElse(0);
        }
        bookRatingDTO.setCountSum(sum);

        return bookRatingDTO;
    }

}
