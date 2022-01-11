package furama.furama.model.serviceResort;


import furama.furama.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public  class ServiceResort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceResortId;

    private String codeServiceResort;
    private Double usableArea;
    private Integer numberOfPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;

    @ManyToOne
    @JoinColumn()
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn()
    private RentType rentType;

    @OneToMany(mappedBy = "serviceResort", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public ServiceResort() {
    }

    public ServiceResort(String codeServiceResort, Double usableArea, Integer numberOfPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.codeServiceResort = codeServiceResort;
        this.usableArea = usableArea;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public ServiceResort(Integer serviceResortId, String codeServiceResort, Double usableArea, Integer numberOfPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.serviceResortId = serviceResortId;
        this.codeServiceResort = codeServiceResort;
        this.usableArea = usableArea;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public Integer getServiceResortId() {
        return serviceResortId;
    }

    public void setServiceResortId(Integer serviceResortId) {
        this.serviceResortId = serviceResortId;
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

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
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
