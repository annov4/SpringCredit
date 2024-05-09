package credit.SpringCredit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private int price;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)

    private User user;

    public Car(String model, int price) {
        this.model = model;
        this.price = price;

    }

}
