package repo;
import domain.Identifiable;

import java.util.ArrayList;

public interface IRepository<ID,T extends Identifiable<ID>> {
    public void add(ID key, T value);
    public void delete(ID key);
    public void modify(ID key, T value);
    public T findById(ID key);
    public Iterable<T> getAll();
    public void printAll();
}
