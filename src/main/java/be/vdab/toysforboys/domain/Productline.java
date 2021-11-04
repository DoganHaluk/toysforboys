package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "productlines")
public class Productline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Version
    private long version;
    @OneToMany(mappedBy = "productline")
    private Set<Product> products;

    public Productline(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new LinkedHashSet<>();
    }

    protected Productline() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }
}
