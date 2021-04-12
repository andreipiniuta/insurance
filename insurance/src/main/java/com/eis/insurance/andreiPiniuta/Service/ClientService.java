package com.eis.insurance.andreiPiniuta.Service;

import com.eis.insurance.andreiPiniuta.data.Client;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ClientService {

    void saveClient (Client client) throws IOException;

    Client readClient () throws IOException;
}
