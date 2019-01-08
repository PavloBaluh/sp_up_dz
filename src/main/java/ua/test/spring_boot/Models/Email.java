package ua.test.spring_boot.Models;

import lombok.*;

import javax.persistence.*;


@Data
@ToString(exclude = "user")
@NoArgsConstructor
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @NonNull
    private String email;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;
}
