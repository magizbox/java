# Log4j

**log4j** is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. log4j is a popular logging package written in Java. log4j has been ported to the C, C++, C#, Perl, Python, Ruby, and Eiffel languages.

log4j is highly configurable through external configuration files at runtime. It views the logging process in terms of levels of priorities and offers mechanisms to direct logging information to a great variety of destinations, such as a database, file, console, UNIX Syslog, etc.

**log4j** has three main components:

* **loggers**: Responsible for capturing logging information.
* **appenders**: Responsible for publishing logging information to various preferred destinations.
* **layouts**: Responsible for formatting logging information in different styles.

**log4j** features

* It is thread-safe.
* It is optimized for speed.
* It is based on a named logger hierarchy.
* It supports multiple output appenders per logger.
* It supports internationalization.
* It is not restricted to a predefined set of facilities.
* Logging behavior can be set at runtime using a configuration file.
* It is designed to handle Java Exceptions from the start.
* It uses multiple levels, namely ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL.
* The format of the log output can be easily changed by extending the Layout class.
* The target of the log output as well as the writing strategy can be altered by implementations of the Appender interface.
* It is fail-stop. However, although it certainly strives to ensure delivery, log4j does not guarantee that each log statement will be delivered to its destination.

# Example

Step 1: Add *log4j* dependency to your *build.gradle* file

```
compile group: 'log4j', name: 'log4j', version: '1.2.17'
```

Step 2: Add log configuration in *main/resources/log4j.property*

```
# Set root logger level to DEBUG and its only appender to A1.
log4j.rootLogger=DEBUG, A1

# A1 is set to be a ConsoleAppender.
log4j.appender.A1=org.apache.log4j.ConsoleAppender

# A1 uses PatternLayout.
log4j.appender.A1.layout=org.apache.log4j.PatternLayout
log4j.appender.A1.layout.ConversionPattern=%-4r [%t] %-5p %c %x - %m%n

# Print only messages of level WARN or above in the package com.foo.
log4j.logger.com.foo=WARN
Here is another configuration file that uses multiple appenders:

log4j.rootLogger=debug, stdout, R

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

# Pattern to output the caller's file name and line number.
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] (%F:%L) - %m%n

log4j.appender.R=org.apache.log4j.RollingFileAppender
log4j.appender.R.File=example.log

log4j.appender.R.MaxFileSize=100KB
# Keep one backup file
log4j.appender.R.MaxBackupIndex=1

log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%p %t %c - %m%n
```

Step 3: Sample log4j program

```java
package logging;

import org.apache.log4j.Logger;

public class LoggingDemo {
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(LoggingDemo.class);
        logger.debug("debug statement");
        logger.info("info statement");
        logger.error("error statement");
    }
}
```

Output

```
DEBUG [main] (LoggingDemo.java:10) - debug statement
 INFO [main] (LoggingDemo.java:11) - info statement
ERROR [main] (LoggingDemo.java:12) - error statement
```

# Suggested Readings

* "Log4j Tutorial". 2016. *www.tutorialspoint.com*. [http://www.tutorialspoint.com/log4j/](http://www.tutorialspoint.com/log4j/).
* "Java Logging". 2016. *tutorials.jenkov.com*. [http://tutorials.jenkov.com/java-logging/index.html](http://tutorials.jenkov.com/java-logging/index.html).