package dev.damola.fullstacktest.model;

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
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sectorId;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "parentSectorId")
    private ParentSector parentSector;

    @ManyToOne
    @JoinColumn(name = "subCategoryId")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

}
