package basic.grails3

import grails.gorm.CriteriaBuilder
import grails.transaction.Transactional

import org.joda.time.DateTime
import org.joda.time.Weeks

@Transactional
class BookService {

    Set<Book> thisWeeksBooks() {
        
        DateTime deadline = new DateTime() - Weeks.ONE
        
        CriteriaBuilder c = Book.createCriteria()
        
        return c.list {
            gt("pubDate", deadline)
        } as Set

    }
}
