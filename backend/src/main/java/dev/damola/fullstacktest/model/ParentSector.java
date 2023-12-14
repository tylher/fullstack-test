package dev.damola.fullstacktest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ParentSector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int parentSectorId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subCategoryId")
    private SubCategory subCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "parentSector", cascade = CascadeType.ALL)
    private List<Sector> SectorList;
}
