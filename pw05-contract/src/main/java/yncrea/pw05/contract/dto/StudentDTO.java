package yncrea.pw05.contract.dto;

public class StudentDTO {

    private String lastname;

    private String firstname;


    public StudentDTO() {
    }


    public StudentDTO(final String lastname, final String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(final String lastnameValue) {
        lastname = lastnameValue;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(final String firstnameValue) {
        firstname = firstnameValue;
    }


    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDTO{");
        sb.append("lastname='").append(lastname).append('\'');
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
