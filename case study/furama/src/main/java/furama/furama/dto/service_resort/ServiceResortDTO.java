package furama.furama.dto.service_resort;

import furama.furama.model.serviceResort.RentType;
import furama.furama.model.serviceResort.ServiceType;
import furama.furama.utils.CodeConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


public class ServiceResortDTO {
    @CodeConstraint()
    @Pattern(regexp = "^DV\\d{4}$", message = "Tên bắt đầu KH|DV|HD|NV  và  phải có 4 số")
    @NotBlank(message = "mã Dịch vụ không được để trống (NotBlank)")
    private String codeServiceResort;

    @Positive(message = "usableArea phải lớn hơn 0")
    private Double usableArea;

    @Positive(message = "numberOfPeople phải lớn hơn 0")
    private Integer numberOfPeople;

    @NotBlank(message = " không được để trống (NotBlank)")
    private String standardRoom;
    @Positive(message = "poolArea phải lớn hơn 0")
    private Double poolArea;

    @Positive(message = "numberOfFloors phải lớn hơn 0")
    private Integer numberOfFloors;


    private String descriptionOtherConvenience;
    private ServiceType serviceType;
    private RentType rentType;

    public ServiceResortDTO() {
    }

    public ServiceResortDTO(@Pattern(regexp = "^(KH|DV|HD|NV)\\d{4}$", message = "Tên bắt đầu KH|DV|HD|NV  và  phải có 4 số") @NotBlank(message = "mã Dịch vụ không được để trống (NotBlank)") String codeServiceResort, @Positive(message = "usableArea phải lớn hơn 0") @NotBlank(message = "không được để trống (NotBlank)") Double usableArea, @Positive(message = "numberOfPeople phải lớn hơn 0") @NotBlank(message = "không được để trống (NotBlank)") Integer numberOfPeople, @Positive(message = "standardRoom phải lớn hơn 0") @NotBlank(message = "không được để trống (NotBlank)") String standardRoom, @Positive(message = "poolArea phải lớn hơn 0") @NotBlank(message = "không được để trống (NotBlank)") Double poolArea, @Positive(message = "numberOfFloors phải lớn hơn 0") @NotBlank(message = "không được để trống (NotBlank)") Integer numberOfFloors, String descriptionOtherConvenience, ServiceType serviceType, RentType rentType) {
        this.codeServiceResort = codeServiceResort;
        this.usableArea = usableArea;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public String getCodeServiceResort() {
        return codeServiceResort;
    }

    public void setCodeServiceResort(String codeServiceResort) {
        this.codeServiceResort = codeServiceResort;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
