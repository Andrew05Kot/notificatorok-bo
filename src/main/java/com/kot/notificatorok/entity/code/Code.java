package com.kot.notificatorok.entity.code;

import com.kot.notificatorok.entity.price.Price;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "code", uniqueConstraints = {
        @UniqueConstraint(name = "name_unique", columnNames = "name")
})
public class Code {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "code", fetch = FetchType.LAZY)
    private List<Price> prices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Code code = (Code) o;

        return new EqualsBuilder()
                .append(id, code.id)
                .append(name, code.name)
                .append(prices, code.prices)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(prices)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
