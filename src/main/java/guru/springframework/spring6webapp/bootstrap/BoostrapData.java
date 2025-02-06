package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub1 = new Publisher();
        pub1.setAddress("1234 Fake St");
        pub1.setCity("Chicago");
        pub1.setState("IL");
        pub1.setZip("60016");
        Publisher pub1Saved = publisherRepository.save(pub1);

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        Book dddSaved = bookRepository.save(ddd);

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        eric.getBooks().add(dddSaved);
        Author ericSaved = authorRepository.save(eric);

        Publisher pub2 = new Publisher();
        pub2.setAddress("4567 Fake St");
        pub2.setCity("Miami");
        pub2.setState("Fl");
        pub2.setZip("41523");
        Publisher pub2Saved = publisherRepository.save(pub2);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");
        Book noEJBSaved = bookRepository.save(noEJB);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        rod.getBooks().add(noEJBSaved);
        Author rodSaved = authorRepository.save(rod);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
