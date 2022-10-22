package angelbaby.database.dto;

import angelbaby.database.model.Location;
import angelbaby.database.model.Stock;
import lombok.Data;

@Data
public class LocationDto {
    private long locationID;
    private int shelfID;
    private String position;
    private Object stockID;

    public LocationDto(Location location) {
        setLocationID(location.getLocationID());
        setShelfID(location.getShelfID());
        setPosition(location.getPosition());
        setStockID(location.getStockID());
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public void setShelfID(int shelfID) {
        this.shelfID = shelfID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStockID(Stock stockID) {
        if (stockID != null)
            this.stockID = stockID.getStockID();
        else this.stockID = null;
    }
}
