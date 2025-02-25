package domain;

import java.util.Objects;

public class Appointment implements Identifiable<Integer>
{
    //private attributes
    private int id;
    private String patientName;
    private String doctorName;
    private String hour;
    private String date;

    //constructor
    public Appointment(int id, String patientName, String doctorName, String hour, String date){
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        this.id=id;

        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty.");
        }
        this.patientName = patientName;

        if (doctorName == null || doctorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty.");
        }
        this.doctorName = doctorName;

        this.hour = hour;
        this.date = date;
    }


    //getters
    public String getPatientName(){
        return patientName;
    }
    public String getDoctorName(){
        return doctorName;
    }
    public String getHour(){
        return hour;
    }
    public String getDate(){
        return date;
    }

    //setters
    public void setPatientName(String patientName){
        this.patientName = patientName;
    }
    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }
    public void setHour(String hour){
        this.hour = hour;
    }
    public void setDate(String date){
        this.date = date;
    }

    @Override
    public void setId(Integer id) {   //use Integer, not int
        this.id=id;                   // it replaces ID and it represents the bigger object of int in the compliler
    }
    public Integer getId(){
        return id;
    }

    // checking if 2 objects are egual -> same data values & same bucket using hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(patientName, that.patientName) && Objects.equals(doctorName, that.doctorName) && Objects.equals(hour, that.hour) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, doctorName, hour, date);
    }

    public String toString(){
        return "Appointment [id=" + id + ", patientName=" + patientName + ", doctorName="+ doctorName + ", hour=" + hour + ", date=" + date + "]";
    }
}
