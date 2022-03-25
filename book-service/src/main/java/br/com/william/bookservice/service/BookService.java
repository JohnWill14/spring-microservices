package br.com.william.bookservice.service;

import br.com.william.bookservice.model.Book;
import br.com.william.bookservice.repository.BookRepository;
import br.com.william.bookservice.response.Cambio;
import br.com.william.bookservice.util.EnvironmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final CambioService cambioService;
    private final EnvironmentUtil environmentUtil;

    public Book findBookByIdForACurrency(Long id, String currency){
        Book book = findBookById(id);
        Cambio cambio = cambioService.getCambio(book.getPrice(), "USD", currency);

        BigDecimal bookPrice = cambio.getConversionValue();
        book.setConversionValue(bookPrice);

        return book;
    }

    public Book findBookById(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new RuntimeException("ERRO ! id not found"));

        book.setEnvironment(environmentUtil.getLocalSeverPort());

        return book;
    }
}
