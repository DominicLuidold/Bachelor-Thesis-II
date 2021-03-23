package at.fhv.dlu9576.vaadin.userstory1.presentation;

import at.fhv.dlu9576.vaadin.userstory1.persistence.entity.Attendee;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The {@code AttendeesColumn} class creates a reusable column consisting of an {@link H3} heading,
 * an information {@link Text} and a pre-configured {@link Grid<Attendee>} of {@link Attendee}s.
 *
 * @author Dominic Luidold
 * @version 1.0.0
 */
final class AttendeesColumn extends VerticalLayout {
    private static final long serialVersionUID = -5326992900212400476L;

    /**
     * Creates a {@link VerticalLayout} with a reusable {@link Attendee}s-{@link Grid} column inside
     *
     * @param heading  The heading
     * @param infoText The info text
     * @param grid     The {@link Grid<Attendee>} of {@link Attendee}s
     */
    public AttendeesColumn(String heading, String infoText, Grid<Attendee> grid) {
        configureGrid(grid);
        add(new H3(heading), new Text(infoText), grid);
    }

    /**
     * Configures the default behaviour for a grid for the entrance control.
     *
     * @param grid The grid to configure
     */
    private void configureGrid(Grid<Attendee> grid) {
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.removeColumnByKey("id");
        grid.removeColumnByKey("phone");
        grid.setColumns("firstName", "lastName", "email");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
