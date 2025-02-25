package service;

import domain.Appointment;
import repo.*;

import java.util.ArrayList;

public class ServiceAppointments {
    private AppointmentsRepository appointments;

    public ServiceAppointments(AppointmentsRepository appointments) {
        this.appointments = appointments;
    }

    public void add(int id,  String patientName,  String doctorName,  String hour, String date){


        try {
            Appointment appointment = new Appointment(id, patientName, doctorName, hour, date);
            appointments.add(id, appointment);
        }catch(IllegalArgumentException | ExceptionRepository e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(int id){
        try {
            appointments.delete(id);
        }catch(ExceptionRepository e){
        System.out.println(e.getMessage());
    }
    }
    public void modify(int id_whereToModify, String patientName,  String doctorName,  String hour, String date){
        try{
        Appointment appointment = new Appointment(id_whereToModify, patientName, doctorName, hour, date);
        appointments.modify(id_whereToModify, appointment);
        }catch(IllegalArgumentException | ExceptionRepository e){
            System.out.println(e.getMessage());
        }

    }
    public Appointment findById(int id){
        try {
            return appointments.findById(id);
        }catch(ExceptionRepository e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    public Iterable<Appointment> getAll(){
        return appointments.getAll();
    }
    public ArrayList<Integer> getAppointmentsOfDoctor(String doctorName){
        return appointments.getAppointmentsOfDoctor(doctorName);
    }
//    public Integer getNrOfAppointmentsOfDoctor(String doctorName){
//        return appointments.getNrOfAppointmentsOfDoctor(doctorName);
//    }
    public String getDoctorMostAppointments(){
        return appointments.getDoctorMostAppointments();
    }
    public void printAppointments(){
        appointments.printAll();
    }
}
