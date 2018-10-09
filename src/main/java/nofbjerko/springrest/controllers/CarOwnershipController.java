package nofbjerko.springrest.controllers;

import nofbjerko.springrest.model.Registration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CarOwnershipController {

    private List<Registration> registrationList = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @GetMapping("/")
    public String doRegister() {
        return "Her skal du registrere!";
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Registration newRegistration(@RequestBody Registration registration) {
        // Set registration to have next ID
        registration.setId(nextId.incrementAndGet());

        registrationList.add(registration);
        return registration;
    }

    @GetMapping("/registrations")
    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    @GetMapping("registrations/{id}")
    public Registration getOneRegistration(@PathVariable("id") long registrationId) {
        for (Registration registration : registrationList) {
            if(registration.getId() == registrationId){
                return registration;
            }
        }

        throw new IllegalArgumentException();
    }

    @PutMapping("registrations/{id}")
    public Registration editOneRegistration(
            @PathVariable("id") long registrationId,
            @RequestBody Registration newRegistration
    ) {

        for (Registration registration : registrationList) {
            if (registration.getId() == registrationId) {
                registrationList.remove(registration);
                newRegistration.setId(registrationId);
                registrationList.add(newRegistration);
                return registration;
            }
        }

        throw new IllegalArgumentException();
    }

    // Create Expection Handle

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
        reason = "Request ID not found."
    )
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        // Nothing to do.
    }

}


