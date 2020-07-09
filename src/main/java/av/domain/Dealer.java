package av.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Dealer {
    private Long id;

    private String dealername;

    private String address;

    private Long capacity;

    private Timestamp created;

    private Timestamp changed;

    private Date year_of_foundation;

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", dealername='" + dealername + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", created=" + created +
                ", changed=" + changed +
                ", year_of_foundation=" + year_of_foundation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealer dealer = (Dealer) o;
        return Objects.equals(id, dealer.id) &&
                Objects.equals(dealername, dealer.dealername) &&
                Objects.equals(address, dealer.address) &&
                Objects.equals(capacity, dealer.capacity) &&
                Objects.equals(created, dealer.created) &&
                Objects.equals(changed, dealer.changed) &&
                Objects.equals(year_of_foundation, dealer.year_of_foundation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dealername, address, capacity, created, changed, year_of_foundation);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealername() {
        return dealername;
    }

    public void setDealername(String dealername) {
        this.dealername = dealername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    public Date getYear_of_foundation() {
        return year_of_foundation;
    }

    public void setYear_of_foundation(Date year_of_foundation) {
        this.year_of_foundation = year_of_foundation;
    }

    public Dealer() {
    }

    public Dealer(Long id, String dealername, String address, Long capacity, Timestamp created, Timestamp changed, Date year_of_foundation) {
        this.id = id;
        this.dealername = dealername;
        this.address = address;
        this.capacity = capacity;
        this.created = created;
        this.changed = changed;
        this.year_of_foundation = year_of_foundation;
    }
}
