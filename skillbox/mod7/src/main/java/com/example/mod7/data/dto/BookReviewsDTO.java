package com.example.mod7.data.dto;

import com.example.mod7.data.book.review.BookReviewEntity;
import com.example.mod7.data.book.review.BookReviewLikeEntity;
import lombok.Data;


public class BookReviewsDTO {

    private BookReviewEntity bookReviewEntity;
    private BookReviewLikeDTO bookReviewLikeDTO;

    public BookReviewsDTO(BookReviewEntity bookReviewEntity, BookReviewLikeDTO bookReviewLikeDTO) {
        this.bookReviewEntity = bookReviewEntity;
        this.bookReviewLikeDTO = bookReviewLikeDTO;
    }

    @Override
    public String toString() {
        return "BookReviewsDTO{" +
                "bookReviewEntity=" + bookReviewEntity +
                ", bookReviewLikeDTO=" + bookReviewLikeDTO +
                '}';
    }

    public BookReviewEntity getBookReviewEntity() {
        return bookReviewEntity;
    }

    public void setBookReviewEntity(BookReviewEntity bookReviewEntity) {
        this.bookReviewEntity = bookReviewEntity;
    }

    public BookReviewLikeDTO getBookReviewLikeDTO() {
        return bookReviewLikeDTO;
    }

    public void setBookReviewLikeDTO(BookReviewLikeDTO bookReviewLikeDTO) {
        this.bookReviewLikeDTO = bookReviewLikeDTO;
    }
}
