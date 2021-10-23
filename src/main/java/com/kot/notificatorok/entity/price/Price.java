package com.kot.notificatorok.entity.price;

import com.kot.notificatorok.entity.code.Code;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@IdClass(PriceId.class)
@Table(name = "price")
public class Price {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "code_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "code_key"))
    private Code code;

    @Id
    @Column(name = "type")
    private LocalDateTime time;

    @Column(name = "val", precision = 10, scale = 7)
    private BigInteger val;

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BigInteger getVal() {
        return val;
    }

    public void setVal(BigInteger val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        return new EqualsBuilder()
                .append(code, price.code)
                .append(time, price.time)
                .append(val, price.val)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(code)
                .append(time)
                .append(val)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Price{" +
                "code=" + code +
                ", time=" + time +
                ", val=" + val +
                '}';
    }
}
