package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Tarefa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TarefaDB {

    private static final String FILE_PATH = "tarefas.json";
    private Gson gson = new Gson();

    public List<Tarefa> carregar() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Tarefa>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void salvar(List<Tarefa> tarefas) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tarefas, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar JSON: " + e.getMessage());
        }
    }
}
