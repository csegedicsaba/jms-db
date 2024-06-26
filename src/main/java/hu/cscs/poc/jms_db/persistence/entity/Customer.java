package hu.cscs.poc.jms_db.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(name = "id_generator", sequenceName = "CUSTOMER_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_generator")
    private long id;

    @Column(name = "NAME")
    private String name;

}
