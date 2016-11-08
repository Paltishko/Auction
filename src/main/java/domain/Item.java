package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tretiak Anton on 08.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private long id;
    private String title;
    private String description;
}
