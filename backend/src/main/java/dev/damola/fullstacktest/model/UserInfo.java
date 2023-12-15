package dev.damola.fullstacktest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String name;
    private boolean agreeToTerms;
    @OneToMany(mappedBy = "userInfo",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"userInfo"})
    private List<UserSector> selectedSectors;
}
