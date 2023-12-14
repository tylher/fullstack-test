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
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subCategoryId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<ParentSector> parentSectorList;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
