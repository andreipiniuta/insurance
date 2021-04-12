package com.eis.insurance.andreiPiniuta.Service;

import com.eis.insurance.andreiPiniuta.data.realEstate.Apartment;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ApartmentService {

    void saveApartment(Apartment apartment) throws IOException;

    Apartment readApartment () throws IOException;
}
