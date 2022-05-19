package com.company.tutorial.screen.productcatalog;

import com.company.tutorial.entity.Product;
import io.jmix.ui.component.DataGrid;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Productcatalog")
@UiDescriptor("ProductCatalog.xml")
public class Productcatalog extends Screen {
    @Autowired
    protected DataGrid<Product> productsTable;
    @Autowired
    protected Label<String> productNameValue;
    @Autowired
    protected Label <String> descriptionValue;
    @Autowired
    protected Label <String> skuValue;

    @Subscribe("productsTable")
    public void onProductsTableSelection(DataGrid.SelectionEvent<Product> event) {
        Product selected = productsTable.getSingleSelected();

        String name = selected.getProductName();
        String description = selected.getProductDescription();
        String sku= selected.getSku();

        productNameValue.setValue(name);
        descriptionValue.setValue(description);
        skuValue.setValue(sku);
    }
}