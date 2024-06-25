package com.crudOperation.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
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



    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    

  
}
