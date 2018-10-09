package nofbjerko.springrest.model;

public class Registration {
    private long id;
    private String carRegNr;
    private String ownerName;

    public Registration() {

    }

    public Registration(long id, String carRegNr, String ownerName) {
        this.id = id;
        this.carRegNr = carRegNr;
        this.ownerName = ownerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarRegNr() {
        return carRegNr;
    }

    public void setCarRegNr(String carRegNr) {
        this.carRegNr = carRegNr;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


}
