package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Tretiak Anton on 08.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lot {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Item item;

    @ManyToOne
    @JoinColumn (name = "owner_id")
    private User owner;
    private BigDecimal startPrice;
    @Temporal(TemporalType.DATE)
    private Date datePlaced;
    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    @ManyToOne
    @JoinColumn (name = "buyer_id")
    private User buyer;
    private BigDecimal currentPrice;
}
