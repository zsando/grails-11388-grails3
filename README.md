Example Grails 3.0.4 app to test problems with joda-time support in unit tests
==============================================================================

This project as one unit test and an identical integration test.

In the test, a criteria query is used that tests a DateTime field of the Book 
domain class.

The unit test reports java.lang.IllegalArgumentException - that ``pubDate`` isn't
a field of Book.

The integration test passes.


To run
------


````
gradle test ; gradle integrationTest
````


Joda-time and Jadira usertype versions
--------------------------------------

According to issue [grails 11388](https://jira.grails.org/browse/GRAILS-11388), 
this same behaviour was exhibited with Grails 2.3.8, but that downgrading to 
joda-time 1.4 and Jadira usertypes 2.0.1 was the work-around.

The downgrades don't appear to work in Grails 3.0.4.

You can toggle the comments on these dependencies in build.gradle to try this.
