package com.softserve.edu.opencart.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.data.Product;

public final class ProductUtils {

    public static final String COMPONENTS_MONITORS_CSV = "src/test/resources/products_component_test.csv";

    public List<String> getDataCSV(String path) {
        List<String> list = new ArrayList<>();
        try {
            System.out.println(ProductUtils.class.getResource(path));
            list = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductsCSV(String path) {
        List<String> data = getDataCSV(path);
        List<Product> result = new ArrayList<>();

        for (String line : data) {
            String[] array = line.split(",");
            Product product = new Product(array[0], array[1], array[2], array[3], array[4], array[5]);
            result.add(product);
        }
        return result;
    }
}
