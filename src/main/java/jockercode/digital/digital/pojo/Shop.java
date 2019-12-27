package jockercode.digital.digital.pojo;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer quantity;
    private Double total;
    private Long dateShop;
    private Long dateRegister;
    @OneToOne
    private Users user;
    @OneToOne
    private Provider provider;

    public Shop() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getDateShop() {
        return dateShop;
    }

    public void setDateShop(Long dateShop) {
        this.dateShop = dateShop;
    }

    public Long getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Long dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
