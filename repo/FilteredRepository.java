package repo;

import domain.Identifiable;
import filter.AbstractFilter;

// special repository which will contain only objects respecting a certain filter
public class FilteredRepository<ID,T extends Identifiable<ID>> extends MemoryRepository<ID,T> {

    private AbstractFilter<T> filter;
    public FilteredRepository(AbstractFilter<T> filter){
        this.filter=filter;
    }

    @Override
    public void add(ID key, T value) {
        // // add objects with a value that is accepted by the filter
        try {
            if (filter.accept(value))
                super.add(key, value);
        }catch(IllegalArgumentException | ExceptionRepository e){
        System.out.println(e.getMessage());
    }
    }
    @Override
    // // modify objects with a value that is accepted by the filter
    public void modify(ID key, T value) {
        try{
        if (filter.accept(value))
            super.modify(key, value);
        }catch(IllegalArgumentException | ExceptionRepository e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "FilteredRepository{" +
                "filter=" + filter +
                '}';
    }
}
