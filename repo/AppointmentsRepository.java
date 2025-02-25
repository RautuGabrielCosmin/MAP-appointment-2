package repo;

import domain.Appointment;

import java.util.ArrayList;

// extend the memory repository and make a special repository for handling appointments
public class AppointmentsRepository extends MemoryRepository<Integer, Appointment>{
      public AppointmentsRepository(){
       super();
   }

    // Get the ids of the appointments of a certain doctor
    public ArrayList<Integer> getAppointmentsOfDoctor(String doctorName){
        ArrayList<Integer> idsAppointmentsOfDoctor = new ArrayList<>(); // save the requested values in an arraylist

        Iterable<Appointment> values = this.getAll(); // we will work with this iterable list and traverse it
        for(Appointment appointment: values){
            if(appointment.getDoctorName().equals(doctorName)){
                idsAppointmentsOfDoctor.add(appointment.getId());
            }
        }
        return idsAppointmentsOfDoctor;
    }

    //Get the name of the doctor with the most appointments
    public Integer getNrOfAppointmentsOfDoctor(String doctorName) {
        int nrAppointments = 0;

        Iterable<Appointment> values = this.getAll();
        for (Appointment appointment: values)
            if (appointment.getDoctorName().equals(doctorName)) {
                nrAppointments++;
            }
        return nrAppointments;

    }
    public String getDoctorMostAppointments(){
        int maximNrAppointments=-1;

        Iterable<Appointment> values = this.getAll();
        String doctorMostAppointments= new String();
        for(Appointment appointment: values){
            if(getNrOfAppointmentsOfDoctor(appointment.getDoctorName())>maximNrAppointments) {
                maximNrAppointments = getNrOfAppointmentsOfDoctor(appointment.getDoctorName());
                doctorMostAppointments=appointment.getDoctorName();
            }
        }
        return doctorMostAppointments;
    }

}
