package av.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

//import java.util.Date;

public class Cars {
    private Long id;

    private String model;

    private Date guarantee_expiration_date;

    private Double price;

    private Long dealer_id;

    private Long user_id;

    private Date dateCar;

    public Cars(Long id, String model, Double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getGuarantee_expiration_date() {
        return guarantee_expiration_date;
    }

    public void setGuarantee_expiration_date(Date guarantee_expiration_date) {
        this.guarantee_expiration_date = guarantee_expiration_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(Long dealer_id) {
        this.dealer_id = dealer_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getDateCar() {
        return dateCar;
    }

    public void setDateCar(Date dateCar) {
        this.dateCar = dateCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(id, cars.id) &&
                Objects.equals(model, cars.model) &&
                Objects.equals(guarantee_expiration_date, cars.guarantee_expiration_date) &&
                Objects.equals(price, cars.price) &&
                Objects.equals(dealer_id, cars.dealer_id) &&
                Objects.equals(user_id, cars.user_id) &&
                Objects.equals(dateCar, cars.dateCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, guarantee_expiration_date, price, dealer_id, user_id, dateCar);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", guarantee_expiration_date=" + guarantee_expiration_date +
                ", price=" + price +
                ", dealer_id=" + dealer_id +
                ", user_id=" + user_id +
                ", dateCar=" + dateCar +
                '}';
    }

}
