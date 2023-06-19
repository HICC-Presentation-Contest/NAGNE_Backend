package com.hicc.nagne_backend.domain.locationinfo.domain.service;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;

public interface AddressConvertLatitudeLongitudeService {

    Address convertAddressToLatitudeLongitude(String tripAddress, String LocationAddress);

}
