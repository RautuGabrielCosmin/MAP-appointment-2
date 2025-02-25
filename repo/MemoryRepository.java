package repo;

import domain.Identifiable;

import java.util.HashMap;

// generic repository for any type of objects ,structured as a hashmap
public class MemoryRepository<ID,T extends Identifiable<ID>> implements IRepository<ID, T> {
    protected HashMap<ID,T> objects = new HashMap<>();

    @Override
    public void add(ID key, T value){
        // add objects with a certain key only if it doesnt exist already
        if(!objects.containsKey(key))
            objects.put(key,value);
        else throw new ExceptionRepository("Id"+ key+" already exists");
    }
    public void delete(ID key){
        if(objects.containsKey(key))
            objects.remove(key);
        else throw new ExceptionRepository("Id"+ key+" does not exist");
    }
    public void modify(ID key, T value){
        if(objects.containsKey(key))
            objects.put(key,value);
        else throw new ExceptionRepository("Id"+ key+" does not exist. Choose another id");
    }
    public T findById(ID key){
        if(objects.containsKey(key))
            return objects.get(key);
        else throw new ExceptionRepository("Id"+ key+" does not exist. No object found");
    }
    public Iterable<T> getAll(){
        return objects.values();
    }

    public void printAll() {
        for(T object : objects.values())
            System.out.println(object);
    }
}