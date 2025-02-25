package filter;

import domain.Dentist;
public class FilterDentistsByAge implements AbstractFilter<Dentist> {

    private int age;
    public FilterDentistsByAge(int age) {
        this.age = age;
    }
    @Override
    public boolean accept(Dentist d) {
        return d.getAge() >= age;
    }
}
