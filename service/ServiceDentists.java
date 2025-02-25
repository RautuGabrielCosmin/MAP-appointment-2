package service;
 import domain.Dentist;
 import repo.ExceptionRepository;
 import repo.IRepository;

public class ServiceDentists {
    private IRepository<Integer,Dentist> dentists;

    public ServiceDentists(IRepository<Integer,Dentist> dentists) {
        this.dentists = dentists;
    }

    public void add(int id, String name, int age) {

        Dentist dentist= new Dentist(id,name,age);

        try{
        dentists.add(id,dentist);
        }catch(ExceptionRepository e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(int id) {
        try{
        dentists.delete(id);
        }catch(ExceptionRepository e){
            System.out.println(e.getMessage());
        }
    }
    public void modify(int id_whereToModify, String name, int age){
        Dentist dentist= new Dentist(id_whereToModify,name,age);

        try{
        dentists.modify(id_whereToModify,dentist);
        }catch(ExceptionRepository e){
            System.out.println(e.getMessage());
        }
    }
    public Dentist findById(int id) {
        try{
        return dentists.findById(id);
        }catch(ExceptionRepository e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Iterable<Dentist> getAll() {
        return dentists.getAll();
    }
    public void printDentists(){
        dentists.printAll();
    }
}
