package test.grails11388

import grails.test.mixin.TestMixin
import grails.test.mixin.gorm.Domain
import grails.test.mixin.hibernate.HibernateTestMixin
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Domain(Book)
@TestMixin(HibernateTestMixin)
class BookSpec extends Specification {

    def "use DateTime clause in criteria query (unit)"() {
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
