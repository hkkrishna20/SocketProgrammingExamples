package name.javacode.webservices.jaxrs.provider.domain;

public abstract class Car {
    @SuppressWarnings("unused")
    private String name;

    public abstract String getName();

    public void setName(String name) {
	this.name = name;
    }
}
