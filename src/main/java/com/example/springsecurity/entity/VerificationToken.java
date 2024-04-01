package com.example.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final int EXPIRATION_TIME= 10;

    private String token;

    private Date expirationTime;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name= "user_id",
                nullable = false,
                foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(User user, String token){
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = calculatedExpirationDate(EXPIRATION_TIME);
    }
   public  VerificationToken(String token){
        super();
        this.token = token;
        this.expirationTime = calculatedExpirationDate(EXPIRATION_TIME);
   }
    private Date calculatedExpirationDate(int expirationTime ) {
        Calendar calender= Calendar.getInstance();
        calender.setTimeInMillis(new Date().getTime());
        calender.add(Calendar.MINUTE, expirationTime);
        return new Date(calender.getTime().getTime());

    }
}
