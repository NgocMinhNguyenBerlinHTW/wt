package de.htwberlin.webtech.webtech.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.htwberlin.webtech.webtech.web.api.OrderProduct;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private String status;

    /**@JsonManagedReference
    @OneToMany
    private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
*/


}
