package com.eis.insurance.andreiPiniuta.Service.impl;

import com.eis.insurance.andreiPiniuta.Service.ClientService;
import com.eis.insurance.andreiPiniuta.data.Client;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientServiceImpl implements ClientService {

    @Override
    public void saveClient(Client client) throws IOException {
        Path dest =Files.createFile(Paths.get("D:/insurance/ClientJson.json"));
        FileWriter writer = new FileWriter(String.valueOf(dest));
        JSONWriter jsonwriter = new JSONWriter(writer);
        jsonwriter.object();
        jsonwriter.key("firstName").value(client.getFirstName());
        jsonwriter.key("lastName").value(client.getLastName());
        jsonwriter.endObject();
        writer.close();
    }

    @Override
    public Client readClient() throws IOException {
        Client client = new Client();
        if(Files.exists(Paths.get("D:/insurance/ClientJson.json"))) {
            FileReader reader = new FileReader("D:/insurance/ClientJson.json");
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject ClientObject = (JSONObject) tokener.nextValue();
            String firstName = ClientObject.getString("firstName");
            String lastName = ClientObject.getString("lastName");
            client.setFirstName(firstName);
            client.setLastName(lastName);
            reader.close();
        } else{
            System.out.println("NO CLIENT INFO");
            return null;
        }
        return client;
    }
}
