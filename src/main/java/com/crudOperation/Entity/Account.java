package com.crudOperation.Entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue
    private UUID acc_id;

    @Column(name="acc_no")
    private int acc_no;

    @Column(name="transition_value")
    private double transition_value;

    @Column(name="transition_type")
    private String transition_type;

    @Column(name="acc_type")
    private String acc_type;

    @Column(name="time")
    private LocalDateTime time;

    @Column(name="deleted")
    private boolean deleted;

    @Override
    public String toString() {
        return "Account [acc_id=" + acc_id + ", acc_no=" + acc_no + ", transition_value=" + transition_value
                + ", transition_type=" + transition_type + ", acc_type=" + acc_type + ", time=" + time + ", deleted="
                + deleted + "]";
    }

 
  
}
