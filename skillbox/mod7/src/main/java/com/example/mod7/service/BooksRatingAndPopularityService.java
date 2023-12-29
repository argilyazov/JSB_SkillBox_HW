package com.example.mod7.service;

import com.example.mod7.data.book.Book;
import com.example.mod7.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BooksRatingAndPopularityService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit) {
        bookRepository.updStatB();
        bookRepository.updStatC();
        bookRepository.updStatK();
        bookRepository.updStatP();
        bookRepository.updNullStat();

        var li = bookRepository.findAll();

        for (var x : li) {
            var e = x.getStatB() + x.getStatC() * 0.7 + x.getStatK() * 0.4;
            x.setStatP(e);
            bookRepository.save(x);
        }

        var nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAllByOrderByStatPDesc(nextPage);
    }

}
