// export const BASE_URL = "https://fullstack-test-e1sd.onrender.com/api";
export const BASE_URL = "http://localhost:8080/api";
export const organizeData = (data) => {
  return Object.entries(
    data.reduce((result, item) => {
      const category = item.category;
      const subcategory = item.subCategory;
      const parentSector = item.parentSector;
      if (!result[category.name]) {
        result[category.name] = { subCategories: {} };
      }
      if (subcategory !== null) {
        if (!result[category.name].subCategories[subcategory.name]) {
          result[category.name].subCategories[subcategory.name] = {};
        }
        if (parentSector) {
          if (
            !result[category.name].subCategories[subcategory.name][
              parentSector.name
            ]
          ) {
            result[category.name].subCategories[subcategory.name][
              parentSector.name
            ] = [];
          }
          result[category.name].subCategories[subcategory.name][
            parentSector.name
          ].push(item);
        } else {
          result[category.name].subCategories[subcategory.name].value = item;
        }
      } else {
        result[category.name].value = item;
      }

      return result;
    }, {})
  );
};
