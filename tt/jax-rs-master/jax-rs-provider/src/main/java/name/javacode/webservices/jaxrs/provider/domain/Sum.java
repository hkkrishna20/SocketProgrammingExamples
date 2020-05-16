package name.javacode.webservices.jaxrs.provider.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "sum", namespace = "http://javacode.name/webservices/jaxrs/provider/")
public class Sum {
    public Sum() {

    }

    public Sum(int augend, int addend) {
	this.sum = augend + addend;
    }

    @XmlValue
    private int sum;

    public int getSum() {
	return sum;
    }
}
