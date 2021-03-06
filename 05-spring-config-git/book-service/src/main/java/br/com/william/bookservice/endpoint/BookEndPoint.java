package br.com.william.bookservice.endpoint;

import br.com.william.bookservice.model.Book;
import br.com.william.bookservice.repository.BookRepository;
import br.com.william.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "book endpoint")
@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
public class BookEndPoint {
    private BookService bookService;

    @Operation(summary = "busca book pelo id")
    @GetMapping("/{id}/{currency}")
    public ResponseEntity<?> getBook(@PathVariable("id") Long id,
                                     @PathVariable("currency") String currency){
        Book book = bookService.findBookByIdForACurrency(id, currency);
        return ResponseEntity.ok(book);
    }

}
