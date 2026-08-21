package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.CitizenZone;

@Transactional(readOnly = true)
public interface CitizenZoneService 
{
    public List<CitizenZone> getzones();
    
 
}
