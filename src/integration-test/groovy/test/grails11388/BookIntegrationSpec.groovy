package test.grails11388
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback

import org.joda.time.DateTime

import spock.lang.Specification
import test.grails11388.Book;

@Integration
@Rollback
class BookIntegrationSpec extends Specification {

    def "use DateTime clause in criteria query (integration)"() {
        given:
        Book b1 = new Book(pubDate: new DateTime(), author: "Harper Lee", title: "Go set a watchman")
        b1.save(failOnError: true, flush: true)
        
        when:
        def books = Book.withCriteria {
            gt 'pubDate', (new DateTime()).minusDays(10)
        }

        then:
        books
        books.size() == 1
    }
}
