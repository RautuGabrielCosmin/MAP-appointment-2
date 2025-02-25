package ui;

import domain.Appointment;
import domain.Dentist;
import filter.FilterAppointmentsByHour;
import filter.FilterDentistsByAge;
import filter.FilterDentistsByDentistName;
import repo.*;
import service.ServiceAppointments;
import service.ServiceDentists;



import java.util.Scanner;

public class UserInterface {
    // constants
    static final int DISPLAY_ALL_OPTION_APPOINTMENTS = 1;
    static final int ADD_APPOINTMENT_OPTION = 2;
    static final int MODIFY_APPOINTMENT_AT_ID_OPTION = 3;
    static final int REMOVE_APPOINTMENT__AT_ID_OPTION = 4;
    static final int FIND_APPOINTMENT_BY_ID=5;
    static final int GET_APPOINTMENTS_OF_DOCTOR_OPTION = 6;
    static final int GET_DOCTORS_MOST_APPOINTMENTS_OPTION = 7;

    static final int DISPLAY_ALL_OPTION_FILTER_APPOINTMENTS = 8;
    static final int ADD_APPOINTMENT_OPTION_FILTER = 9;
    static final int MODIFY_APPOINTMENT_AT_ID_OPTION_FILTER = 10;
    static final int REMOVE_APPOINTMENT_AT_ID_OPTION_FILTER = 11;
    static final int EXIT_OPTION = 0;

    static final int DISPLAY_ALL_OPTION_DENTISTS = 12;
    static final int ADD_DENTIST_OPTION = 13;
    static final int MODIFY_DENTIST_AT_ID_OPTION = 14;
    static final int REMOVE_DENTIST_AT_ID_OPTION = 15;
    static final int FIND_DENTIST_BY_ID=16;

    static final int DISPLAY_ALL_OPTION_FILTER_DENTISTS = 17;
    static final int ADD_DENTIST_OPTION_FILTER = 18;
    static final int MODIFY_DENTIST_AT_ID_OPTION_FILTER = 19;
    static final int REMOVE_DENTIST_AT_ID_OPTION_FILTER = 20;


    //private attributes
    private ServiceAppointments serviceAppointments;
    private ServiceDentists serviceDentists;

    //constructor
    public UserInterface(ServiceAppointments serviceAppointments, ServiceDentists serviceDentists) {
        this.serviceAppointments=serviceAppointments;
        this.serviceDentists=serviceDentists;
    }
    //methods
    public static String printMenuAppointments(){
        return "\nMENU APPOINTMENTS\n"+
                DISPLAY_ALL_OPTION_APPOINTMENTS +".Print appointments\n"+
                ADD_APPOINTMENT_OPTION+".Add appointment\n"+ MODIFY_APPOINTMENT_AT_ID_OPTION +".Modify at id " +
                "\n"+REMOVE_APPOINTMENT__AT_ID_OPTION+".Remove appointment\n"+
                FIND_APPOINTMENT_BY_ID+".Find appointment by id\n"+
                GET_APPOINTMENTS_OF_DOCTOR_OPTION+".Get the ids of the appointments of a certain doctor" +
                "\n"+GET_DOCTORS_MOST_APPOINTMENTS_OPTION+".Get the name of the doctor with the most appointments" +
                "\n"+"\nMENU FILTERED APPOINTMENTS\n"+ DISPLAY_ALL_OPTION_FILTER_APPOINTMENTS +".Print appointments\n"+ADD_APPOINTMENT_OPTION_FILTER+".Add appointment\n"+ MODIFY_APPOINTMENT_AT_ID_OPTION_FILTER +".Modify at id"
                + "\n"+ REMOVE_APPOINTMENT_AT_ID_OPTION_FILTER +".Remove appointment\n";
    }
    public static String printMenuDentists(){
        return "MENU DENTISTS\n"+ DISPLAY_ALL_OPTION_DENTISTS +".Print dentists\n"+ADD_DENTIST_OPTION+".Add dentist\n"+ MODIFY_DENTIST_AT_ID_OPTION +".Modify at id " +
                "\n"+REMOVE_DENTIST_AT_ID_OPTION+".Remove dentist\n"+
                FIND_DENTIST_BY_ID+".Find dentist by id\n"+
                "\n"+"MENU FILTERED DENTISTS\n"+ DISPLAY_ALL_OPTION_FILTER_DENTISTS +".Print dentists\n"+ADD_DENTIST_OPTION_FILTER+".Add dentist\n"+ MODIFY_DENTIST_AT_ID_OPTION_FILTER +".Modify at id"
                + "\n"+ REMOVE_DENTIST_AT_ID_OPTION_FILTER +".Remove dentist\n"+
                "\n"+ EXIT_OPTION +".Exit all";
    }
//    public void printAppointments(){
//        for(Appointment a: this.serviceAppointments.getAll())
//            System.out.println(a);
//    }
    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt())
            return scanner.nextInt();
        return 0;
    }
    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String []Args){

        Appointment appointment1= new Appointment(123,"Dragos Trandafir","Andrei Ionescu","07:00","12.12.2004");
        Appointment appointment2= new Appointment(341,"Patient0","Doctor0","10:00","10.10.2010");
        Appointment appointment3= new Appointment(342,"Patient1","Doctor1","10:00","13.10.2010");
        Appointment appointment4= new Appointment(343,"Patient2","Doctor2","11:00","10.1.2010");
        Appointment appointment5= new Appointment(344,"Patient3","Doctor0","17:00","8.7.2010");

        Dentist dentist1= new Dentist(1,"Dragos",34);
        Dentist dentist2= new Dentist(2,"Doctor0",36);
        Dentist dentist3= new Dentist(3,"Doctor1",40);
        Dentist dentist4= new Dentist(4,"Andrei Ionescu",59);
        Dentist dentist5= new Dentist(5,"Dragos2",44);

        AppointmentsRepository appointmentsRepository = new AppointmentsRepository();
        ServiceAppointments serviceAppointments = new ServiceAppointments(appointmentsRepository);

        IRepository<Integer,Dentist> dentistsRepository= new DentistsRepository();
        ServiceDentists serviceDentists = new ServiceDentists(dentistsRepository);

        UserInterface userInterface = new UserInterface(serviceAppointments, serviceDentists);

        //adding some objects directly in the repository appointments
        appointmentsRepository.add(appointment1.getId(),appointment1);
        appointmentsRepository.add(appointment2.getId(),appointment2);
        appointmentsRepository.add(appointment3.getId(),appointment3);
        appointmentsRepository.add(appointment4.getId(),appointment4);
        appointmentsRepository.add(appointment5.getId(),appointment5);

        //adding some objects directly in the repository dentistsRepository
        dentistsRepository.add(dentist1.getId(),dentist1);
        dentistsRepository.add(dentist2.getId(),dentist2);
        dentistsRepository.add(dentist3.getId(),dentist3);
        dentistsRepository.add(dentist4.getId(),dentist4);
        dentistsRepository.add(dentist5.getId(),dentist5);




        // filtered appointments
        //FilteredRepository<Integer,Appointment> filteredAppointmentsRepository= new FilteredRepository<Integer,Appointment>(new FilterByDoctorName("Doctor0"));// decide here what filter with value you want to impose
        FilteredRepository<Integer,Appointment> filteredAppointmentsRepository= new FilteredRepository<Integer,Appointment>(new FilterAppointmentsByHour("08:00","16:00"));// decide here what filter with value you want to impose


        filteredAppointmentsRepository.add(appointment1.getId(),appointment1);
        filteredAppointmentsRepository.add(appointment2.getId(),appointment2);
        filteredAppointmentsRepository.add(appointment3.getId(),appointment3);
        filteredAppointmentsRepository.add(appointment4.getId(),appointment4);
        filteredAppointmentsRepository.add(appointment5.getId(),appointment5);



        // filtered dentists
        FilteredRepository<Integer,Dentist> filteredDentistsRepository = new FilteredRepository<Integer,Dentist>(new FilterDentistsByAge(40));
        //FilteredRepository<Integer,Dentist> filteredDentistsRepository = new FilteredRepository<Integer,Dentist>(new FilterDentistsByDentistName("Doctor0"));

        filteredDentistsRepository.add(dentist1.getId(),dentist1);
        filteredDentistsRepository.add(dentist2.getId(),dentist2);
        filteredDentistsRepository.add(dentist3.getId(),dentist3);
        filteredDentistsRepository.add(dentist4.getId(),dentist4);
        filteredDentistsRepository.add(dentist5.getId(),dentist5);


        boolean exit = false;
            while (!exit) {
                System.out.println(printMenuAppointments());
                System.out.println(printMenuDentists());
                System.out.print("\nOption chosen: ");
                int option = readInteger();

                switch (option) {
                    //normal options APPOINTMENTS
                    case DISPLAY_ALL_OPTION_APPOINTMENTS:
                        serviceAppointments.printAppointments();
                        break;
                    case ADD_APPOINTMENT_OPTION:
                        System.out.println("Id:");
                        int id_add_appointment = readInteger();

                        System.out.println("Patient name:");
                        String patientName_add_appointment = readString();

                        System.out.println("Doctor name:");
                        String doctorName_add_appointment = readString();

                        System.out.println("Hour:");
                        String hour_add_appointment = readString();

                        System.out.println("Date:");
                        String date_add_appointment = readString();

                        //Appointment readAppointment_add_appointment = new Appointment(id_add_appointment,patientName_add_appointment,doctorName_add_appointment,hour_add_appointment,date_add_appointment);
                        serviceAppointments.add(id_add_appointment, patientName_add_appointment, doctorName_add_appointment, hour_add_appointment, date_add_appointment);
                        break;
                    case MODIFY_APPOINTMENT_AT_ID_OPTION:
                        System.out.println("Modify at this id:");
                        int idWhereToModify = readInteger();

                        //System.out.println("Id:");
                        //int id_modify_appointment = readInteger();

                        System.out.println("Patient name:");
                        String patientName_modify_appointment = readString();

                        System.out.println("Doctor name:");
                        String doctorName_modify_appointment = readString();

                        System.out.println("Hour:");
                        String hour_modify_appointment = readString();

                        System.out.println("Date:");
                        String date_modify_appointment = readString();

                        //Appointment readAppointment_modify_appointment = new Appointment(id_modify_appointment,patientName_modify_appointment,doctorName_modify_appointment,hour_modify_appointment,date_modify_appointment);
                        serviceAppointments.modify(idWhereToModify, patientName_modify_appointment, doctorName_modify_appointment, hour_modify_appointment, date_modify_appointment);
                        break;
                    case REMOVE_APPOINTMENT__AT_ID_OPTION:
                        System.out.println("Remove at this id:");
                        int idWhereToRemove = readInteger();

                        serviceAppointments.delete(idWhereToRemove);
                        break;
                    case FIND_APPOINTMENT_BY_ID:
                        System.out.println("Id:");
                        int id_find_appointment = readInteger();

                        System.out.println(serviceAppointments.findById(id_find_appointment));
                        break;
                    case GET_APPOINTMENTS_OF_DOCTOR_OPTION:
                        System.out.println("Doctor name:");
                        String doctorName_appointments_of_doctor = readString();

                        System.out.println(serviceAppointments.getAppointmentsOfDoctor(doctorName_appointments_of_doctor));
                        break;
                    case GET_DOCTORS_MOST_APPOINTMENTS_OPTION:
                        System.out.println(serviceAppointments.getDoctorMostAppointments());
                        break;
                    case EXIT_OPTION:
                        exit = true;
                        break;

                    // Filter options APPOINTMENTS
                    case DISPLAY_ALL_OPTION_FILTER_APPOINTMENTS:
                        filteredAppointmentsRepository.printAll();
                        break;
                    case ADD_APPOINTMENT_OPTION_FILTER:
                        System.out.println("Id:");
                        int id_add_appointment_filtered = readInteger();

                        System.out.println("Patient name:");
                        String patientName_add_appointment_filtered = readString();

                        System.out.println("Doctor name:");
                        String doctorName_add_appointment_filtered = readString();

                        System.out.println("Hour:");
                        String hour_add_appointment_filtered = readString();

                        System.out.println("Date:");
                        String date_add_appointment_filtered = readString();

                        try{
                        Appointment readAppointment_add_appointment_filtered = new Appointment(id_add_appointment_filtered, patientName_add_appointment_filtered, doctorName_add_appointment_filtered, hour_add_appointment_filtered, date_add_appointment_filtered);
                        filteredAppointmentsRepository.add(id_add_appointment_filtered, readAppointment_add_appointment_filtered);
                        }catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }

                        break;
                    case MODIFY_APPOINTMENT_AT_ID_OPTION_FILTER:
                        System.out.println("Modify at this id:");
                        int idWhereToModify_filtered = readInteger();

//                    System.out.println("Id:");
//                    int id_modify_appointment_f = readInteger();

                        System.out.println("Patient name:");
                        String patientName_modify_appointment_filtered = readString();

                        System.out.println("Doctor name:");
                        String doctorName_modify_appointment_filtered = readString();

                        System.out.println("Hour:");
                        String hour_modify_appointment_filtered = readString();

                        System.out.println("Date:");
                        String date_modify_appointment_filtered = readString();

                        try {
                            Appointment readAppointment_modify_appointment_filtered = new Appointment(idWhereToModify_filtered, patientName_modify_appointment_filtered, doctorName_modify_appointment_filtered, hour_modify_appointment_filtered, date_modify_appointment_filtered);
                            filteredAppointmentsRepository.modify(idWhereToModify_filtered, readAppointment_modify_appointment_filtered);
                        }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        }


                        break;
                    case REMOVE_APPOINTMENT_AT_ID_OPTION_FILTER:
                        System.out.println("Remove at this id:");
                        int idWhereToRemove_filtered = readInteger();

                        filteredAppointmentsRepository.delete(idWhereToRemove_filtered);
                        break;


                    //normal options DENTISTS
                    case DISPLAY_ALL_OPTION_DENTISTS:
                        serviceDentists.printDentists();
                        break;
                    case ADD_DENTIST_OPTION:
                        System.out.println("Id:");
                        int id_add_dentist = readInteger();

                        System.out.println("Name:");
                        String name_add_dentists = readString();

                        System.out.println("Age:");
                        int age_add_dentist = readInteger();


                        serviceDentists.add(id_add_dentist, name_add_dentists, age_add_dentist);
                        break;
                    case MODIFY_DENTIST_AT_ID_OPTION:
                        System.out.println("Modify at this id:");
                        int idWhereToModify_dentists = readInteger();

                        System.out.println("Name:");
                        String name_modify_dentists = readString();

                        System.out.println("Age:");
                        int age_modify_dentist = readInteger();


                        serviceDentists.modify(idWhereToModify_dentists, name_modify_dentists, age_modify_dentist);
                        break;
                    case REMOVE_DENTIST_AT_ID_OPTION:
                        System.out.println("Remove at this id:");
                        int idWhereToRemove_dentists = readInteger();

                        serviceDentists.delete(idWhereToRemove_dentists);
                        break;
                    case FIND_DENTIST_BY_ID:
                        System.out.println("Id:");
                        int id_find_dentist = readInteger();

                        System.out.println(serviceDentists.findById(id_find_dentist));
                        break;

                    // Filter options DENTISTS
                    case DISPLAY_ALL_OPTION_FILTER_DENTISTS:
                        filteredDentistsRepository.printAll();
                        break;
                    case ADD_DENTIST_OPTION_FILTER:
                        System.out.println("Id:");
                        int id_add_dentist_filtered = readInteger();

                        System.out.println("Name:");
                        String name_add_dentists_filtered = readString();

                        System.out.println("Age:");
                        int age_add_dentist_filtered = readInteger();

                        try{
                        Dentist dentist_add_filtered = new Dentist(id_add_dentist_filtered, name_add_dentists_filtered, age_add_dentist_filtered);
                        filteredDentistsRepository.add(id_add_dentist_filtered, dentist_add_filtered);
                        }catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case MODIFY_DENTIST_AT_ID_OPTION_FILTER:
                        System.out.println("Modify at this id:");
                        int idWhereToModify_dentist_filtered = readInteger();

                        System.out.println("Name:");
                        String name_modify_dentists_filtered = readString();

                        System.out.println("Age:");
                        int age_modify_dentist_filtered = readInteger();

                        try {
                            Dentist dentist_modify_filtered = new Dentist(idWhereToModify_dentist_filtered, name_modify_dentists_filtered, age_modify_dentist_filtered);
                            filteredDentistsRepository.modify(idWhereToModify_dentist_filtered, dentist_modify_filtered);
                        }catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case REMOVE_DENTIST_AT_ID_OPTION_FILTER:
                        System.out.println("Remove at this id:");
                        int idWhereToRemove_dentist_filtered = readInteger();

                        filteredDentistsRepository.delete(idWhereToRemove_dentist_filtered);
                        break;
                }

            }
    }
}
