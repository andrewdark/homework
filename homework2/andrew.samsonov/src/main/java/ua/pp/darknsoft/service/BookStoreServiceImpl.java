package ua.pp.darknsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.models.Book;
import ua.pp.darknsoft.models.Buyer;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    @Autowired
    Buyer buyer;

    @Override
    public String byuBook(Book book) {
        if(buyer.buyBook(book))
        return "The book - " + book + "was bought";
        return buyer.getFirstName() + " hasn't bought this book";
    }
}
