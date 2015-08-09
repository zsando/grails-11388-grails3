package basic.grails3

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Weeks

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BookService)
@Mock(Book)
class BookServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test criteria query with DateTime clause"() {
        when:
            Book b1 = new Book(author: "Harper Lee", 
                title: "Go set a watchman", 
                pubDate: new DateTime())
            Book b2 = new Book(author: "E.L. James", 
                title: "Grey", 
                pubDate: new DateTime() - Days.TWO)
            Book b3 = new Book(author: "Paula Hawkins", 
                title: "The girl on the train", 
                pubDate: new DateTime() - Weeks.TWO)
            
            Set<Book> thisWeeksBooks = service.thisWeeksBooks()
            
        then:
            thisWeeksBooks.size() == 2
    }
}
