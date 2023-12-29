package com.example.mod6.service;

import com.example.mod6.data.book.Book;
import com.example.mod6.data.book.links.Book2GenreEntity;
import com.example.mod6.data.genre.GenreEntity;
import com.example.mod6.repository.Book2GenreEntityRepository;
import com.example.mod6.repository.GenreEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {

    @Autowired
    private GenreEntityRepository genreEntityRepository;

    @Autowired
    private Book2GenreEntityRepository book2GenreEntityRepository;

    public List<GenreEntity> getByParentId(Integer id) {
        return genreEntityRepository.findByParentId(id);
    }

    public GenreEntity getBySlug(String slug){
        return genreEntityRepository.findBySlug(slug);
    }

    public Page<Book2GenreEntity> getAllByGenre(int offset, int limit, GenreEntity genre){
        var nextPage = PageRequest.of(offset, limit);

        return book2GenreEntityRepository.findAllBookByGenre(genre,nextPage);
    }
}
