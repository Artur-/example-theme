package org.vaadin.artur.myproject.views.java;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller.ScrollDirection;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.vaadin.artur.myproject.views.java.MainView;

/**
 * The main view is a top-level placeholder for other views.
 */
@Route("")
public class MainView extends AppLayout {

    private H2 viewTitle;

    public MainView() {
        setPrimarySection(Section.DRAWER);
        createHeaderContent();
        createDrawerContent();

        VerticalLayout content = new VerticalLayout();
        content.setPadding(false);
        content.getThemeList().add("padding-l");
        content.add(new H2("Heading 2"), new Paragraph("Paragraph of text, for long form text."),
                new DatePicker("Date picker"), new Button("Button"), new ComboBox<String>("Combo box", "Option one",
                        "Option two", "Option three", "Option four", "Option five"));
        Button btn = new Button("Button");
        btn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        content.add(btn);

        setContent(content);
    }

    private void createHeaderContent() {
        viewTitle = new H2("Dashboard");
        viewTitle.addClassName("view-title");

        Div avatar = new Div();
        avatar.addClassName("avatar");
        // avatar.setText("AB");

        addToNavbar(new DrawerToggle(), viewTitle, avatar);
    }

    private void createDrawerContent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(false);
        layout.setPadding(false);
        layout.setMargin(false);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);

        H1 appTitle = new H1("My App");
        appTitle.addClassName("app-title");

        Tabs menu = new Tabs();
        menu.setOrientation(Tabs.Orientation.VERTICAL);
        menu.getThemeNames().add("menu");

        H3 menuTitle = new H3("Views");
        menuTitle.addClassName("menu-title");
        menu.getElement().appendChild(menuTitle.getElement());
        menu.add(new Tab("Dashboard"), new Tab("Projects"), new Tab("Sessions"), new Tab("Workbench"));

        menuTitle = new H3("Favorites");
        menuTitle.addClassName("menu-title");
        menu.getElement().appendChild(menuTitle.getElement());
        menu.add(new Tab("My great project"), new Tab("Previous week sessions"));
        menu.setSelectedIndex(1);

        layout.add(appTitle, menu);
        layout.expand(menu);
        addToDrawer(layout);
    }
}
