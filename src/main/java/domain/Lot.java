package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Tretiak Anton on 08.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lot {
    private long id;
    private Item item;
    private User owner;
    private BigDecimal startPrice;
    private Date datePlaced;
    private Date dateEnd;
    private User buyer;
    private BigDecimal currentPrice;
}
