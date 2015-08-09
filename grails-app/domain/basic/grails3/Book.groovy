package basic.grails3

import org.joda.time.DateTime

class Book {
    
    String title
    String author
    
    DateTime pubDate

    static constraints = {
    }
    
    static mapping = {
        pubDate(type: org.jadira.usertype.dateandtime.joda.PersistentDateTime.class)
    }

}
