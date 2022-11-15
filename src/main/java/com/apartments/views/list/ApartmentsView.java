package com.apartments.views.list;

import com.apartments.domain.apartments.Apartment;
import com.apartments.domain.apartments.ApartmentFacade;
import com.apartments.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import java.util.Objects;

@Component
@Scope("prototype")
@Route(value = "", layout = MainLayout.class)
@PageTitle("Apartamenty | AP")
@PermitAll
public class ApartmentsView extends VerticalLayout {

    Grid<Apartment> grid = new Grid<>(Apartment.class);
    TextField filterText = new TextField();
    ApartmentForm form;

    private final ApartmentFacade facade;

    public ApartmentsView(ApartmentFacade facade) {
        this.facade = facade;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        form = new ApartmentForm();
        form.setWidth("25em");
        form.addListener(ApartmentForm.SaveEvent.class, this::saveApartment);
        form.addListener(ApartmentForm.DeleteEvent.class, this::deleteApartment);
        form.addListener(ApartmentForm.CloseEvent.class, e -> closeEditor());

        FlexLayout content = new FlexLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.setFlexShrink(0, form);
        content.addClassNames("content", "gap-m");
        content.setSizeFull();

        add(getToolbar(), content);
        updateList();
        closeEditor();
        grid.asSingleSelect().addValueChangeListener(event -> editApartment(event.getValue()));
    }

    private void configureGrid() {
        grid.addClassNames("apartment-grid");
        grid.setSizeFull();
        grid.setColumns("id", "createdDate", "name", "location", "price");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filtrowanie po nazwie ...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addApartmentButton = new Button("Dodaj apartament");
        addApartmentButton.addClickListener(click -> addApartment());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addApartmentButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void saveApartment(ApartmentForm.SaveEvent event) {
        Apartment apartment = event.getApartment();
        if (Objects.isNull(apartment.getId())) {
            facade.save(apartment);
        } else {
            facade.update(apartment);
        }
        updateList();
        closeEditor();
    }

    private void deleteApartment(ApartmentForm.DeleteEvent event) {
        facade.delete(event.getApartment());
        updateList();
        closeEditor();
    }

    public void editApartment(Apartment apartment) {
        if (apartment == null) {
            closeEditor();
        } else {
            form.setApartmentBean(apartment);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    void addApartment() {
        grid.asSingleSelect().clear();
        editApartment(new Apartment());
    }

    private void closeEditor() {
        form.setApartmentBean(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(facade.findAll(filterText.getValue()));
    }
}
