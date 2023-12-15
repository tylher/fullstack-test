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


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSector {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userSectorId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"selectedSectors","userInfo"})
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "sectorId")
    @JsonIgnoreProperties({"selectedSectors","userInfo"})
    private Sector sector;

    public UserSector(UserInfo userInfo, Sector sector) {
        this.userInfo = userInfo;
        this.sector = sector;
    }
}
