package com.kot.notificatorok.core.entity.price;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PriceId implements Serializable {

    private Long code;
    private LocalDateTime time;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PriceId priceId = (PriceId) o;

        return new EqualsBuilder()
                .append(code, priceId.code)
                .append(time, priceId.time)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(code)
                .append(time)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "PriceId{" +
                "code=" + code +
                ", time=" + time +
                '}';
    }
}
