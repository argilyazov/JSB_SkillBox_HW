package com.example.mod7.service;

import com.example.mod7.data.book.review.BookReviewEntity;
import com.example.mod7.data.book.review.BookReviewLikeEntity;
import com.example.mod7.data.dto.BookReviewLikeDTO;
import com.example.mod7.repository.BookReviewLikeEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookReviewLikeEntityService {

    private final BookReviewLikeEntityRepository bookReviewLikeEntityRepository;


    public BookReviewLikeDTO getLikesByReview(BookReviewEntity bookReviewEntity){
        var like = bookReviewLikeEntityRepository.countByReviewIdAndValueGreaterThan(bookReviewEntity.getId(), (short) 0);
        var dislike = bookReviewLikeEntityRepository.countByReviewIdAndValueLessThan(bookReviewEntity.getId(), (short) 0);

        return new BookReviewLikeDTO(like,dislike);
    }

}
