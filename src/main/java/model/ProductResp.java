package model;

public class ProductResp {
    private float id;
    private String name;
    private String description = null;
    private String manufacturer = null;
    private String category;
    private String price = null;
    private String created;
    private String status;
    private String tags = null;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getCreated() {
        return created;
    }

    public String getStatus() {
        return status;
    }

    public String getTags() {
        return tags;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}