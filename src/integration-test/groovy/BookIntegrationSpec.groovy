import grails.test.mixin.integration.Integration
import grails.transaction.Transactional

import org.joda.time.DateTime

import spock.lang.Specification
import basic.grails3.Book

@Integration
@Transactional
class BookIntegrationSpec extends Specification {

    def "use DateTime clause in criteria query"() {
        given:
        (new Book(author: "Harper Lee", title: "Go set a watchman",
        pubDate: new DateTime())).save(failOnError: true, flush: true)
        
        when:
        def books = Book.withCriteria {
            gt 'pubDate', (new DateTime()).minusDays(10)
        }

        then:
        books
        books.size() == 1
    }

}
