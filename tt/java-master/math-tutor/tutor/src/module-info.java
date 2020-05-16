/**
 * @author Abhijit Sarkar
 */
module org.javacode.java.mathtutor {
    // can't use 'to' because we don't know which modules are going to implement ProblemProvider
    exports org.javacode.java.mathtutor.spi;
    exports org.javacode.java.mathtutor.model;

    // tells the JVM to look for implementations of ProblemProvider
    uses org.javacode.java.mathtutor.spi.ProblemProvider;
}