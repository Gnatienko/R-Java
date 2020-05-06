package com.gnatienko.reader.web;


import com.gnatienko.reader.model.BookContentEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public ResponseEntity<BookContentEntity> getContentEntity() {
        BookContentEntity bookContentEntity = new BookContentEntity();
        bookContentEntity.setBookId(1L);
        bookContentEntity.setId(1L);
        bookContentEntity.setContent("Test");
        bookContentEntity.setPageN(1L);
        return ResponseEntity.ok(bookContentEntity);
    }

    @PostMapping
    public ResponseEntity<BookContentEntity> postContentEntity( @RequestBody BookContentEntity bookContentEntity){
        System.out.println(bookContentEntity.getContent().toString());
        return ResponseEntity.ok(bookContentEntity);
    }



}
