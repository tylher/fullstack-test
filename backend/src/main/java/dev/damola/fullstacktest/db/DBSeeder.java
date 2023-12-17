package dev.damola.fullstacktest.db;

import dev.damola.fullstacktest.model.Category;
import dev.damola.fullstacktest.model.ParentSector;
import dev.damola.fullstacktest.model.Sector;
import dev.damola.fullstacktest.model.SubCategory;
import dev.damola.fullstacktest.repository.CategoryRepository;
import dev.damola.fullstacktest.repository.ParentSectorRepository;
import dev.damola.fullstacktest.repository.SectorRepository;
import dev.damola.fullstacktest.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    ParentSectorRepository parentSectorRepository;

    @Autowired
    SectorRepository sectorRepository;

    @Override
    public void run(String... args) throws Exception {
//        seedData();
    }

    private void seedData() {
        List<Category> categories = new ArrayList<>();

        Category manufacturingCategory = new Category();
        manufacturingCategory.setName("Manufacturing");

        Category serviceCategory = new Category();
        serviceCategory.setName("Service");

        Category otherCategory = new Category();
        otherCategory.setName("Other");

        categories.add(manufacturingCategory);
        categories.add(serviceCategory);
        categories.add(otherCategory);

        categoryRepository.saveAll(categories);

        List<SubCategory> subCategoryList = new ArrayList<>();
        SubCategory subCategory1 = new SubCategory();
        SubCategory subCategory2 = new SubCategory();
        SubCategory subCategory3 = new SubCategory();
        SubCategory subCategory4 = new SubCategory();
        SubCategory subCategory5 = new SubCategory();
        SubCategory subCategory6 = new SubCategory();
        SubCategory subCategory7 = new SubCategory();
        SubCategory subCategory8 = new SubCategory();
        SubCategory subCategory9 = new SubCategory();
        SubCategory subCategory10 = new SubCategory();

        subCategory1.setCategory(manufacturingCategory);
        subCategory1.setName("Construction Materials");

        subCategory2.setCategory(manufacturingCategory);
        subCategory2.setName("Electronics And Optics");

        subCategory3.setCategory(manufacturingCategory);
        subCategory3.setName("Food And Beverage");

        subCategory4.setCategory(manufacturingCategory);
        subCategory4.setName("Furniture");

        subCategory5.setCategory(manufacturingCategory);
        subCategory5.setName("Machinery");

        subCategory6.setCategory(manufacturingCategory);
        subCategory6.setName("Metalworking");

        subCategory7.setCategory(manufacturingCategory);
        subCategory7.setName("Plastic And Rubber");

        subCategory8.setCategory(manufacturingCategory);
        subCategory8.setName("Printing");

        subCategory9.setCategory(manufacturingCategory);
        subCategory9.setName("Textile And Clothing");

        subCategory10.setCategory(manufacturingCategory);
        subCategory10.setName("Wood");

        SubCategory subCategory11 = new SubCategory();
        SubCategory subCategory12 = new SubCategory();
        SubCategory subCategory13 = new SubCategory();
        SubCategory subCategory14 = new SubCategory();
        SubCategory subCategory15 = new SubCategory();
        SubCategory subCategory16 = new SubCategory();

        subCategory11.setCategory(serviceCategory);
        subCategory11.setName("Business Services");
        subCategory12.setCategory(serviceCategory);
        subCategory12.setName("Engineering");
        subCategory13.setCategory(serviceCategory);
        subCategory13.setName("Information Technology And Telecommunications");
        subCategory14.setCategory(serviceCategory);
        subCategory14.setName("Tourism");
        subCategory15.setCategory(serviceCategory);
        subCategory15.setName("Translation Services");
        subCategory16.setCategory(serviceCategory);
        subCategory16.setName("Transport And Logistics");

        SubCategory subCategory17 = new SubCategory();
        SubCategory subCategory18 = new SubCategory();
        SubCategory subCategory19 = new SubCategory();

        subCategory17.setCategory(otherCategory);
        subCategory17.setName("Creative Industries");
        subCategory18.setCategory(otherCategory);
        subCategory18.setName("Energy Technology");
        subCategory19.setCategory(otherCategory);
        subCategory19.setName("Environment");

        subCategoryList.add(subCategory1);
        subCategoryList.add(subCategory2);
        subCategoryList.add(subCategory3);
        subCategoryList.add(subCategory4);
        subCategoryList.add(subCategory5);
        subCategoryList.add(subCategory6);
        subCategoryList.add(subCategory7);
        subCategoryList.add(subCategory8);
        subCategoryList.add(subCategory9);
        subCategoryList.add(subCategory10);
        subCategoryList.add(subCategory11);
        subCategoryList.add(subCategory12);
        subCategoryList.add(subCategory13);
        subCategoryList.add(subCategory14);
        subCategoryList.add(subCategory15);
        subCategoryList.add(subCategory16);
        subCategoryList.add(subCategory17);
        subCategoryList.add(subCategory18);
        subCategoryList.add(subCategory19);

        subCategoryRepository.saveAll(subCategoryList);

        ParentSector parentSector1 =new ParentSector();
        ParentSector parentSector2 =new ParentSector();
        ParentSector parentSector3 =new ParentSector();
        ParentSector parentSector4 =new ParentSector();
        ParentSector parentSector5 =new ParentSector();
        ParentSector parentSector6 =new ParentSector();
        ParentSector parentSector7 =new ParentSector();

        parentSector1.setSubCategory(subCategory3);
        parentSector1.setName("Bakery & confectionery products");

        parentSector2.setSubCategory(subCategory3);
        parentSector2.setName("Beverages");

        parentSector3.setSubCategory(subCategory3);
        parentSector3.setName("Fish & fish products");

        parentSector4.setSubCategory(subCategory3);
        parentSector4.setName("Meat & meat products");

        parentSector5.setSubCategory(subCategory3);
        parentSector5.setName("Milk & dairy products");

        parentSector6.setSubCategory(subCategory3);
        parentSector6.setName("Other");

        parentSector7.setSubCategory(subCategory3);
        parentSector7.setName("Sweets & snack food");

        ParentSector parentSector8 =new ParentSector();
        ParentSector parentSector9 =new ParentSector();
        ParentSector parentSector10 =new ParentSector();
        ParentSector parentSector11 =new ParentSector();
        ParentSector parentSector12 =new ParentSector();
        ParentSector parentSector13 =new ParentSector();
        ParentSector parentSector14 =new ParentSector();
        ParentSector parentSector15 =new ParentSector();
        ParentSector parentSector16 =new ParentSector();


        parentSector8.setSubCategory(subCategory4);
        parentSector8.setName("Bathroom/sauna");

        parentSector9.setSubCategory(subCategory4);
        parentSector9.setName("Bedroom");

        parentSector10.setSubCategory(subCategory4);
        parentSector10.setName("Childrenâ€™s room");

        parentSector11.setSubCategory(subCategory4);
        parentSector11.setName("Kitchen");

        parentSector12.setSubCategory(subCategory4);
        parentSector12.setName("Living room");

        parentSector13.setSubCategory(subCategory4);
        parentSector13.setName("Office");

        parentSector14.setSubCategory(subCategory4);
        parentSector14.setName("Other (Furniture)");

        parentSector15.setSubCategory(subCategory4);
        parentSector15.setName("Outdoor");

        parentSector16.setSubCategory(subCategory4);
        parentSector16.setName("Project furniture");

        //Machinery components        Machinery equipment/tools        Manufacture of machinery  subCategory5
        //       Maritime   Metal structures        Other        Repair and maintenance service

        ParentSector parentSector17 =new ParentSector();
        ParentSector parentSector18 =new ParentSector();
        ParentSector parentSector19 =new ParentSector();
        ParentSector parentSector20 =new ParentSector();
        ParentSector parentSector21 =new ParentSector();
        ParentSector parentSector22 =new ParentSector();
        ParentSector parentSector23 =new ParentSector();

        parentSector17.setSubCategory(subCategory5);
        parentSector17.setName("Machinery components ");

        parentSector18.setSubCategory(subCategory5);
        parentSector18.setName("Machinery equipment/tools");

        parentSector19.setSubCategory(subCategory5);
        parentSector19.setName("Manufacture of machinery");

        parentSector20.setSubCategory(subCategory5);
        parentSector20.setName("Maritime");

        parentSector21.setSubCategory(subCategory5);
        parentSector21.setName("Metal structures");

        parentSector22.setSubCategory(subCategory5);
        parentSector22.setName("Other");

        parentSector23.setSubCategory(subCategory5);
        parentSector23.setName("Repair and maintenance service");




        //                           subCategory6
        ParentSector parentSector24 =new ParentSector();
        ParentSector parentSector25 =new ParentSector();
        ParentSector parentSector26 =new ParentSector();
        ParentSector parentSector27 =new ParentSector();

        parentSector24.setSubCategory(subCategory6);
        parentSector24.setName("Construction of metal structures");

        parentSector25.setSubCategory(subCategory6);
        parentSector25.setName("Houses and buildings");

        parentSector26.setSubCategory(subCategory6);
        parentSector26.setName("Metal products");

        parentSector27.setSubCategory(subCategory6);
        parentSector27.setName("Metal works");



        //                     subCategory7
        ParentSector parentSector28 =new ParentSector();
        ParentSector parentSector29 =new ParentSector();
        ParentSector parentSector30 =new ParentSector();
        ParentSector parentSector31 =new ParentSector();

        parentSector28.setSubCategory(subCategory7);
        parentSector28.setName("Packaging");

        parentSector29.setSubCategory(subCategory7);
        parentSector29.setName("Plastic goods");

        parentSector30.setSubCategory(subCategory7);
        parentSector30.setName("Plastic processing technology");

        parentSector31.setSubCategory(subCategory7);
        parentSector31.setName("Plastic profiles");


        //                   subCategory8

        ParentSector parentSector32 =new ParentSector();
        ParentSector parentSector33 =new ParentSector();
        ParentSector parentSector34 =new ParentSector();

        parentSector32.setSubCategory(subCategory8);
        parentSector32.setName("Advertising");

        parentSector33.setSubCategory(subCategory8);
        parentSector33.setName("Book/Periodicals printing");

        parentSector34.setSubCategory(subCategory8);
        parentSector34.setName("Labelling and packaging printing");


        //         subCategory9
        ParentSector parentSector35 =new ParentSector();
        ParentSector parentSector36 =new ParentSector();


        parentSector35.setSubCategory(subCategory9);
        parentSector35.setName("Clothing");

        parentSector36.setSubCategory(subCategory9);
        parentSector36.setName("Textile");


        //                 subCategory10

        ParentSector parentSector37 =new ParentSector();
        ParentSector parentSector38 =new ParentSector();
        ParentSector parentSector39 =new ParentSector();

        parentSector37.setSubCategory(subCategory10);
        parentSector37.setName("Other (Wood)");

        parentSector38.setSubCategory(subCategory10);
        parentSector38.setName("Wooden building materials");

        parentSector39.setSubCategory(subCategory10);
        parentSector39.setName("Wooden houses");

        //                         subCategory13
        ParentSector parentSector40 =new ParentSector();
        ParentSector parentSector41 =new ParentSector();
        ParentSector parentSector42 =new ParentSector();
        ParentSector parentSector43 =new ParentSector();

        parentSector40.setSubCategory(subCategory13);
        parentSector40.setName("Data processing, Web portals, E-marketing");

        parentSector41.setSubCategory(subCategory13);
        parentSector41.setName("Programming, Consultancy");

        parentSector42.setSubCategory(subCategory13);
        parentSector42.setName("Software, Hardware");

        parentSector43.setSubCategory(subCategory13);
        parentSector43.setName("Telecommunications");

        //                             subCategory16
        ParentSector parentSector44 =new ParentSector();
        ParentSector parentSector45 =new ParentSector();
        ParentSector parentSector46 =new ParentSector();
        ParentSector parentSector47 =new ParentSector();

        parentSector44.setSubCategory(subCategory16);
        parentSector44.setName("Air");

        parentSector45.setSubCategory(subCategory16);
        parentSector45.setName("Rail");

        parentSector46.setSubCategory(subCategory16);
        parentSector46.setName("Road");

        parentSector47.setSubCategory(subCategory16);
        parentSector47.setName("Water");


        List<ParentSector> parentSectorList = new ArrayList<>(List.of(parentSector1, parentSector2, parentSector3,
                parentSector4, parentSector5, parentSector6, parentSector7, parentSector8, parentSector9, parentSector10
                , parentSector11, parentSector12, parentSector13, parentSector14, parentSector15, parentSector16,
                parentSector17, parentSector18, parentSector19, parentSector20, parentSector21, parentSector22,
                parentSector23, parentSector24, parentSector25, parentSector26, parentSector27, parentSector28,
                parentSector29, parentSector30, parentSector31, parentSector32, parentSector33, parentSector34,
                parentSector35, parentSector36, parentSector37, parentSector38, parentSector39, parentSector40,
                parentSector41, parentSector42, parentSector43, parentSector44, parentSector45, parentSector46,
                parentSector47));
        parentSectorRepository.saveAll(parentSectorList);


        Sector sector1 = new Sector();
        sector1.setName("Manufacturing");
        sector1.setCategory(manufacturingCategory);

        Sector sector2 = new Sector();
        sector2.setName("Service");
        sector2.setCategory(serviceCategory);

        Sector sector3 = new Sector();
        sector3.setName("Other");
        sector3.setCategory(otherCategory);


        Sector sector4 = new Sector();
        sector4.setCategory(manufacturingCategory);
        sector4.setName("Construction Materials");
        sector4.setSubCategory(subCategory1);


        Sector sector5 = new Sector();
        sector5.setSubCategory(subCategory2);
        sector5.setCategory(manufacturingCategory);
        sector5.setName("Electronics And Optics");

        Sector sector6 = new Sector();
        sector6.setSubCategory(subCategory3);
        sector6.setCategory(manufacturingCategory);
        sector6.setName("Food And Beverage");

        Sector sector7 = new Sector();
        sector7.setSubCategory(subCategory4);
        sector7.setCategory(manufacturingCategory);
        sector7.setName("Furniture");

        Sector sector8 = new Sector();
        sector8.setSubCategory(subCategory5);
        sector8.setCategory(manufacturingCategory);
        sector8.setName("Machinery");


        Sector sector9 = new Sector();
        sector9.setSubCategory(subCategory6);
        sector9.setCategory(manufacturingCategory);
        sector9.setName("Metalworking");

        Sector sector10 = new Sector();
        sector10.setSubCategory(subCategory7);
        sector10.setCategory(manufacturingCategory);
        sector10.setName("Plastic And Rubber");

        Sector sector11 = new Sector();
        sector11.setSubCategory(subCategory8);
        sector11.setCategory(manufacturingCategory);
        sector11.setName("Printing");

        Sector sector12 = new Sector();
        sector12.setSubCategory(subCategory9);
        sector12.setCategory(manufacturingCategory);
        sector12.setName("Textile And Clothing");


        Sector sector13 = new Sector();
        sector13.setSubCategory(subCategory10);
        sector13.setCategory(manufacturingCategory);
        sector13.setName("Wood");

        Sector sector14 = new Sector();
        sector14.setSubCategory(subCategory11);
        sector14.setCategory(serviceCategory);
        sector14.setName("Business Services");

        Sector sector15 =new Sector();
        sector15.setSubCategory(subCategory12);
        sector15.setCategory(serviceCategory);
        sector15.setName("Engineering");

        Sector sector16 = new Sector();
        sector16.setSubCategory(subCategory13);
        sector16.setCategory(serviceCategory);
        sector16.setName("Information Technology And Telecommunications");

        Sector sector17 = new Sector();
        sector17.setSubCategory(subCategory14);
        sector17.setCategory(serviceCategory);
        sector17.setName("Tourism");

        Sector sector18 = new Sector();
        sector18.setSubCategory(subCategory15);
        sector18.setCategory(serviceCategory);
        sector18.setName("Translation Services");

        Sector sector19 = new Sector();
        sector19.setSubCategory(subCategory16);
        sector19.setCategory(serviceCategory);
        sector19.setName("Transport And Logistics");


        Sector sector20 = new Sector();
        sector20.setSubCategory(subCategory17);
        sector20.setCategory(otherCategory);
        sector20.setName("Creative Industries");

        Sector sector21 = new Sector();
        sector21.setSubCategory(subCategory18);
        sector21.setCategory(otherCategory);
        sector21.setName("Energy Technology");

        Sector sector22 = new Sector();
        sector22.setSubCategory(subCategory19);
        sector22.setCategory(otherCategory);
        sector22.setName("Environment");

        Sector sector23 = new Sector();
        sector23.setParentSector(parentSector1);
        sector23.setCategory(manufacturingCategory);
        sector23.setSubCategory(subCategory3);
        sector23.setName("Bakery & confectionery products");

        Sector sector24 = new Sector();
        sector24.setParentSector(parentSector2);
        sector24.setCategory(manufacturingCategory);
        sector24.setSubCategory(subCategory3);
        sector24.setName("Beverages");

        Sector sector25 = new Sector();
        sector25.setParentSector(parentSector3);
        sector25.setCategory(manufacturingCategory);
        sector25.setSubCategory(subCategory3);
        sector25.setName("Fish & fish products");

        Sector sector26 = new Sector();
        sector26.setParentSector(parentSector4);
        sector26.setCategory(manufacturingCategory);
        sector26.setSubCategory(subCategory3);
        sector26.setName("Meat & meat products");

        Sector sector27 = new Sector();
        sector27.setParentSector(parentSector5);
        sector27.setCategory(manufacturingCategory);
        sector27.setSubCategory(subCategory3);
        sector27.setName("Milk & dairy products");

        Sector sector28 = new Sector();
        sector28.setParentSector(parentSector6);
        sector28.setCategory(manufacturingCategory);
        sector28.setSubCategory(subCategory3);
        sector28.setName("Other");

        Sector sector29 = new Sector();
        sector29.setParentSector(parentSector7);
        sector29.setCategory(manufacturingCategory);
        sector29.setSubCategory(subCategory3);
        sector29.setName("Sweets & snack food");

        Sector sector30 = new Sector();
        sector30.setParentSector(parentSector8);
        sector30.setCategory(manufacturingCategory);
        sector30.setSubCategory(subCategory4);
        sector30.setName("Bathroom/sauna");

        Sector sector31 = new Sector();
        sector31.setParentSector(parentSector9);
        sector31.setCategory(manufacturingCategory);
        sector31.setSubCategory(subCategory4);
        sector31.setName("Bedroom");

        Sector sector32 = new Sector();
        sector32.setParentSector(parentSector10);
        sector32.setCategory(manufacturingCategory);
        sector32.setSubCategory(subCategory4);
        sector32.setName("Childrenâ€™s room");

        Sector sector33 = new Sector();
        sector33.setParentSector(parentSector11);
        sector33.setCategory(manufacturingCategory);
        sector33.setSubCategory(subCategory4);
        sector33.setName("Kitchen");

        Sector sector34 = new Sector();
        sector34.setParentSector(parentSector12);
        sector34.setCategory(manufacturingCategory);
        sector34.setSubCategory(subCategory4);
        sector34.setName("Living room");

        Sector sector35 = new Sector();
        sector35.setParentSector(parentSector13);
        sector35.setCategory(manufacturingCategory);
        sector35.setSubCategory(subCategory4);
        sector35.setName("Office");

        Sector sector36 = new Sector();
        sector36.setParentSector(parentSector14);
        sector36.setCategory(manufacturingCategory);
        sector36.setSubCategory(subCategory4);
        sector36.setName("Other (Furniture)");

        Sector sector37 = new Sector();
        sector37.setParentSector(parentSector15);
        sector37.setCategory(manufacturingCategory);
        sector37.setSubCategory(subCategory4);
        sector37.setName("Outdoor");

        Sector sector38 = new Sector();
        sector38.setParentSector(parentSector16);
        sector38.setCategory(manufacturingCategory);
        sector38.setSubCategory(subCategory4);
        sector38.setName("Project furniture");

        Sector sector39 = new Sector();
        sector39.setParentSector(parentSector17);
        sector39.setCategory(manufacturingCategory);
        sector39.setSubCategory(subCategory5);
        sector39.setName("Machinery components ");

        Sector sector40 = new Sector();
        sector40.setParentSector(parentSector18);
        sector40.setCategory(manufacturingCategory);
        sector40.setSubCategory(subCategory5);
        sector40.setName("Machinery equipment/tools");

        Sector sector41 = new Sector();
        sector41.setParentSector(parentSector19);
        sector41.setCategory(manufacturingCategory);
        sector41.setSubCategory(subCategory5);
        sector41.setName("Manufacture of machinery");

        Sector sector42 = new Sector();
        sector42.setParentSector(parentSector20);
        sector42.setCategory(manufacturingCategory);
        sector42.setSubCategory(subCategory5);
        sector42.setName("Maritime");

        Sector sector43 = new Sector();
        sector43.setParentSector(parentSector21);
        sector43.setCategory(manufacturingCategory);
        sector43.setSubCategory(subCategory5);
        sector43.setName("Metal structures");

        Sector sector44 = new Sector();
        sector44.setParentSector(parentSector22);
        sector44.setCategory(manufacturingCategory);
        sector44.setSubCategory(subCategory5);
        sector44.setName("Other");

        Sector sector45 = new Sector();
        sector45.setParentSector(parentSector23);
        sector45.setCategory(manufacturingCategory);
        sector45.setSubCategory(subCategory5);
        sector45.setName("Repair and maintenance service");

        Sector sector46 = new Sector();
        sector46.setParentSector(parentSector24);
        sector46.setCategory(manufacturingCategory);
        sector46.setSubCategory(subCategory6);
        sector46.setName("Construction of metal structures");

        Sector sector47 = new Sector();
        sector47.setParentSector(parentSector25);
        sector47.setCategory(manufacturingCategory);
        sector47.setSubCategory(subCategory6);
        sector47.setName("Houses and buildings");

        Sector sector48 = new Sector();
        sector48.setParentSector(parentSector26);
        sector48.setCategory(manufacturingCategory);
        sector48.setSubCategory(subCategory6);
        sector48.setName("Metal products");

        Sector sector49 = new Sector();
        sector49.setParentSector(parentSector27);
        sector49.setCategory(manufacturingCategory);
        sector49.setSubCategory(subCategory6);
        sector49.setName("Metal works");

        Sector sector50 = new Sector();
        sector50.setParentSector(parentSector28);
        sector50.setCategory(manufacturingCategory);
        sector50.setSubCategory(subCategory7);
        sector50.setName("Packaging");

        Sector sector51 = new Sector();
        sector51.setParentSector(parentSector29);
        sector51.setCategory(manufacturingCategory);
        sector51.setSubCategory(subCategory7);
        sector51.setName("Plastic goods");

        Sector sector52 = new Sector();
        sector52.setParentSector(parentSector30);
        sector52.setCategory(manufacturingCategory);
        sector52.setSubCategory(subCategory7);
        sector52.setName("Plastic processing technology");

        Sector sector53 = new Sector();
        sector53.setParentSector(parentSector31);
        sector53.setCategory(manufacturingCategory);
        sector53.setSubCategory(subCategory7);
        sector53.setName("Plastic profiles");

        Sector sector54 = new Sector();
        sector54.setParentSector(parentSector32);
        sector54.setCategory(manufacturingCategory);
        sector54.setSubCategory(subCategory8);
        sector54.setName("Advertising");

        Sector sector55 = new Sector();
        sector55.setParentSector(parentSector33);
        sector55.setCategory(manufacturingCategory);
        sector55.setSubCategory(subCategory8);
        sector55.setName("Book/Periodicals printing");

        Sector sector56 = new Sector();
        sector56.setParentSector(parentSector34);
        sector56.setCategory(manufacturingCategory);
        sector56.setSubCategory(subCategory8);
        sector56.setName("Labelling and packaging printing");

        Sector sector57 = new Sector();
        sector57.setParentSector(parentSector35);
        sector57.setCategory(manufacturingCategory);
        sector57.setSubCategory(subCategory9);
        sector57.setName("Clothing");

        Sector sector58 = new Sector();
        sector58.setParentSector(parentSector36);
        sector58.setCategory(manufacturingCategory);
        sector58.setSubCategory(subCategory9);
        sector58.setName("Textile");

        Sector sector59 = new Sector();
        sector59.setParentSector(parentSector37);
        sector59.setCategory(manufacturingCategory);
        sector59.setSubCategory(subCategory10);
        sector59.setName("Other (Wood)");

        Sector sector60 = new Sector();
        sector60.setParentSector(parentSector38);
        sector60.setCategory(manufacturingCategory);
        sector60.setSubCategory(subCategory10);
        sector60.setName("Wooden building materials");

        Sector sector61 = new Sector();
        sector61.setParentSector(parentSector39);
        sector61.setCategory(manufacturingCategory);
        sector61.setSubCategory(subCategory10);
        sector61.setName("Wooden houses");

        Sector sector62 = new Sector();
        sector62.setParentSector(parentSector40);
        sector62.setCategory(serviceCategory);
        sector62.setSubCategory(subCategory13);
        sector62.setName("Data processing, Web portals, E-marketing");

        Sector sector63 = new Sector();
        sector63.setParentSector(parentSector41);
        sector63.setCategory(serviceCategory);
        sector63.setSubCategory(subCategory13);
        sector63.setName("Programming, Consultancy");

        Sector sector64 = new Sector();
        sector64.setParentSector(parentSector42);
        sector64.setCategory(serviceCategory);
        sector64.setSubCategory(subCategory13);
        sector64.setName("Software, Hardware");

        Sector sector65 = new Sector();
        sector65.setParentSector(parentSector43);
        sector65.setCategory(serviceCategory);
        sector65.setSubCategory(subCategory13);
        sector65.setName("Telecommunications");

        Sector sector66 = new Sector();
        sector66.setParentSector(parentSector44);
        sector66.setCategory(serviceCategory);
        sector66.setSubCategory(subCategory16);
        sector66.setName("Air");

        Sector sector67 = new Sector();
        sector67.setParentSector(parentSector45);
        sector67.setCategory(serviceCategory);
        sector67.setSubCategory(subCategory16);
        sector67.setName("Rail");

        Sector sector68 = new Sector();
        sector68.setParentSector(parentSector46);
        sector68.setCategory(serviceCategory);
        sector68.setSubCategory(subCategory16);
        sector68.setName("Road");

        Sector sector69 = new Sector();
        sector69.setParentSector(parentSector47);
        sector69.setCategory(serviceCategory);
        sector69.setSubCategory(subCategory16);
        sector69.setName("Water");

        //              Boat/Yacht building
        Sector sector70 = new Sector();
        sector70.setParentSector(parentSector20);
        sector70.setCategory(manufacturingCategory);
        sector70.setSubCategory(subCategory5);
        sector70.setName("Aluminium and steel workboats");

        Sector sector71 = new Sector();
        sector71.setParentSector(parentSector20);
        sector71.setCategory(manufacturingCategory);
        sector71.setSubCategory(subCategory5);
        sector71.setName("Boat/Yacht building ");

        Sector sector72 = new Sector();
        sector72.setParentSector(parentSector20);
        sector72.setCategory(manufacturingCategory);
        sector72.setSubCategory(subCategory5);
        sector72.setName("Ship repair and conversion");

        //
        Sector sector73 = new Sector();
        sector73.setParentSector(parentSector27);
        sector73.setCategory(manufacturingCategory);
        sector73.setSubCategory(subCategory6);
        sector73.setName("CNC-machining");

        Sector sector74 = new Sector();
        sector74.setParentSector(parentSector27);
        sector74.setCategory(manufacturingCategory);
        sector74.setSubCategory(subCategory6);
        sector74.setName("Forgings, Fasteners");

        Sector sector75 = new Sector();
        sector75.setParentSector(parentSector27);
        sector75.setCategory(manufacturingCategory);
        sector75.setSubCategory(subCategory6);
        sector75.setName("Gas, Plasma, Laser cutting");

        Sector sector76 = new Sector();
        sector76.setParentSector(parentSector27);
        sector76.setCategory(manufacturingCategory);
        sector76.setSubCategory(subCategory6);
        sector76.setName("MIG, TIG, Aluminum welding");

        //

        Sector sector77 = new Sector();
        sector77.setParentSector(parentSector30);
        sector77.setCategory(manufacturingCategory);
        sector77.setSubCategory(subCategory7);
        sector77.setName("Blowing");

        Sector sector78 = new Sector();
        sector78.setParentSector(parentSector30);
        sector78.setCategory(manufacturingCategory);
        sector78.setSubCategory(subCategory7);
        sector78.setName("Moulding");

        Sector sector79 = new Sector();
        sector79.setParentSector(parentSector30);
        sector79.setCategory(manufacturingCategory);
        sector79.setSubCategory(subCategory7);
        sector79.setName("Plastics welding and processing");

        List<Sector> sectorList = new ArrayList<>(List.of(sector1, sector2, sector3, sector4, sector5
                , sector6, sector7, sector8, sector9, sector10, sector11, sector12, sector13, sector14, sector15
                , sector16, sector17, sector18, sector19, sector20, sector21, sector22, sector23, sector24, sector25
                , sector26, sector27, sector28, sector29, sector30, sector31, sector32, sector33, sector34, sector35
                , sector36, sector37, sector38, sector39, sector40, sector41, sector42, sector43, sector44, sector45
                , sector46, sector47, sector48, sector49, sector50, sector51, sector52, sector53, sector54, sector55
                , sector56, sector57, sector58, sector59, sector60, sector61, sector62, sector63, sector64, sector65
                , sector66, sector67, sector68, sector69, sector70, sector71, sector72, sector73, sector74, sector75
                , sector76, sector77, sector78, sector79
        ));
        sectorRepository.saveAll(sectorList);
    }
}
