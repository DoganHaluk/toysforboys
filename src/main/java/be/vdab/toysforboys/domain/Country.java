package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Version
    private long version;
    @OneToMany(mappedBy = "country")
    private Set<Customer> customers;

    public Country(String name) {
        this.name = name;
        this.customers = new LinkedHashSet<>();
    }

    protected Country() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Customer> getCustomers() {
        return Collections.unmodifiableSet(customers);
    }
}
