package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Disciplina;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDB {

    private static final String FILE_PATH = "disciplinas.json";
    private Gson gson = new Gson();

    public List<Disciplina> carregar() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Disciplina>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void salvar(List<Disciplina> disciplinas) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(disciplinas, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }
}
