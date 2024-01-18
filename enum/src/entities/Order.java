package entities;
import java.util.Date;

import entities.enums.OrderStatus;
public class Order {
    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Order(Integer id, Date moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public void setId(Integer newId) {
        id = newId;
    }
    public void setMoment(Date newMoment) {
        moment = newMoment;
    }
    public void setStatus(OrderStatus newStatus) {
        status = newStatus;
    }
    public Integer getId() {
        return id;
    }
    public Date getMoment() {
        return moment;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public String toString() {
        return "id=" + id + ", moment=" + moment + ", status=" + status; 
    }
}