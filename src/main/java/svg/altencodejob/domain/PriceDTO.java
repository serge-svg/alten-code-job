package svg.altencodejob.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceDTO {
    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private String startDate;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private String endDate;
    private String price;

    public PriceDTO() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
