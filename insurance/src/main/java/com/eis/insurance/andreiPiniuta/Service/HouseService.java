package com.eis.insurance.andreiPiniuta.Service;

import com.eis.insurance.andreiPiniuta.data.realEstate.House;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HouseService {

    void saveHouse(House house) throws IOException;

    House readHouse () throws IOException;
}
