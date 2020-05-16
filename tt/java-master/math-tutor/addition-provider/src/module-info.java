module org.javacode.java.additionprovider {
    requires org.javacode.java.mathtutor;

    provides org.javacode.java.mathtutor.spi.ProblemProvider
            with org.javacode.java.additionprovider.AdditionProblemProvider;
}