package com.example.mod7.service;

import com.example.mod7.data.book.Book;
import com.example.mod7.data.book.review.BookReviewEntity;
import com.example.mod7.data.dto.BookReviewsDTO;
import com.example.mod7.repository.BookReviewEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookReviewService {

    private final BookReviewEntityRepository bookReviewEntityRepository;

    @Autowired
    private BookReviewLikeEntityService bookReviewLikeEntityService;

    @Autowired
    public BookReviewService(BookReviewEntityRepository bookReviewEntityRepository) {
        this.bookReviewEntityRepository = bookReviewEntityRepository;
    }


    public List<BookReviewsDTO> getReviewByBook(Book book) {
        var reviews = bookReviewEntityRepository.findAllByBook(book);
        var reviewsDTO = new ArrayList<BookReviewsDTO>();

        for(var r : reviews){
            var likes = bookReviewLikeEntityService.getLikesByReview(r);
            var brdto = new BookReviewsDTO(r,likes);
            reviewsDTO.add(brdto);
        }

        return reviewsDTO;
    }

}


