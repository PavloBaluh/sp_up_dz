package ua.test.spring_boot.Models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(exclude = "emails")
@Entity
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 @NonNull
 private String name;

 @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "user")
 private List<Email> emails = new ArrayList<>();
}

