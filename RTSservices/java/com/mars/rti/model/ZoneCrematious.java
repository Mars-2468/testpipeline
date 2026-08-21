package com.mars.rti.model;

import javax.persistence.*;

@Entity
@Table(name = "mst_zone_crematorium", schema = "egovrti")
public class ZoneCrematious {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zone_crematorium_seq")
    @SequenceGenerator(
        name = "zone_crematorium_seq",
        sequenceName = "zone_crematorium_seq",
        allocationSize = 1
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "zone_id", nullable = false)
    private Integer zoneId;

    @Column(name = "zone_name", nullable = false)
    private String zoneName;

    @Column(name = "crematorium_name", nullable = false)
    private String crematoriumName;

    @Column(name = "is_active")
    private Boolean isActive;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getCrematoriumName() {
        return crematoriumName;
    }

    public void setCrematoriumName(String crematoriumName) {
        this.crematoriumName = crematoriumName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
