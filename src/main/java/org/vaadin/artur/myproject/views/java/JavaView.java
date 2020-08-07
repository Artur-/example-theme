package org.vaadin.artur.myproject.views.java;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "java")
@RouteAlias(value = "")
public class JavaView extends VerticalLayout {

    public JavaView() {
        add(new TextField("This is a default text field"));
        TextField fancy = new TextField("This is a class=fancy text field");
        fancy.addClassName("fancy");
        add(fancy);
        add(new Button("Standard button", e -> Notification.show("Hello")));

        Chart chart = new Chart(ChartType.LINE);
        chart.getConfiguration().addSeries(new ListSeries(1, 2, 3, 4, 5));
        chart.getConfiguration().addSeries(new ListSeries(6, 5, 4, 3, 2));
        chart.getConfiguration().addSeries(new ListSeries(3, 3, 3, 3, 3));
        add(chart);
    }

}
