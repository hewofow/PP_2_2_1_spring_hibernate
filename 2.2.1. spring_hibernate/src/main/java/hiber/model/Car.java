package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private int series;

    @OneToOne
    private User user;

    public Car(){
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}
