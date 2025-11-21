package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDB {

    private static final String FILE_PATH = "usuarios.json"; //arquivo onde os dados são armazenados
    private Gson gson = new Gson();

    public List<Usuario> carregarUsuarios() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Usuario>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            return new ArrayList<>(); // caso arquivo não exista
        }
    }

    public void salvarUsuarios(List<Usuario> usuarios) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo JSON: " + e.getMessage());
        }
    }
}
