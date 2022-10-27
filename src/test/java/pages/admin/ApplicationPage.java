package pages.admin;

import elements.TableRawElement;

public class ApplicationPage {
    public String getRequestedPrincipal() {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("Requested principal").replaceAll("[^0-9]", "");
    }
    public String getRequestedTenor() {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("Requested tenor");
    }
    public String getState() {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("State");
    }
}
