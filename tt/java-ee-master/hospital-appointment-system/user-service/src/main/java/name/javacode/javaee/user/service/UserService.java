package name.javacode.javaee.user.service;

import static java.util.Collections.unmodifiableList;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;

import name.javacode.javaee.user.domain.Doctor;
import name.javacode.javaee.user.domain.Doctors;
import name.javacode.javaee.user.domain.Patient;
import name.javacode.javaee.user.domain.Patients;
import name.javacode.javaee.user.domain.User;

import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class UserService {
    @Inject
    private ObjectMapper objectMapper;

    private List<Doctor> doctors;
    private List<Patient> patients;

    @PostConstruct
    void initUsers() {
	doctors = getUsers("/doctors.json", Doctor.class);
	patients = getUsers("/patients.json", Patient.class);
    }

    @Produces
    @Doctors
    List<Doctor> getDoctors() {
	return doctors;
    }

    @Produces
    @Patients
    List<Patient> getPatients() {
	return patients;
    }

    public List<? extends User> getUsersByType(String type) {
	User.Type userType = null;

	userType = User.Type.valueOf(type);

	switch (userType) {
	case Doctor:
	    return doctors;
	case Patient:
	    return patients;
	}

	/*
	 * This can never happen because if the string couldn't be converted to
	 * the enum, we'd already have thrown IllegalArgumentException. Only if
	 * the compiler knew that.
	 */
	return null;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
	this.objectMapper = objectMapper;
    }

    private <T extends User> List<T> getUsers(String filename, Class<T> clazz) {
	try {
	    List<T> users = objectMapper.readValue(UserService.class
		    .getResource(filename), objectMapper.getTypeFactory()
		    .constructCollectionType(List.class, clazz));

	    return unmodifiableList(users);
	} catch (IOException e) {
	    throw new UncheckedIOException(e);
	}
    }
}
