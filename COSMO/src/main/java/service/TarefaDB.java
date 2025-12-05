package service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Tarefa;

public class TarefaDB {

    private static final String CAMINHO = "tarefas.json";
    private Gson gson = new Gson();

    public List<Tarefa> carregar() {
        try {
            File f = new File(CAMINHO);
            if (!f.exists()) return new ArrayList<>();

            FileReader fr = new FileReader(f);
            List<Tarefa> lista = gson.fromJson(fr, new TypeToken<List<Tarefa>>(){}.getType());
            fr.close();

            return lista != null ? lista : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void salvar(List<Tarefa> lista) {
        try {
            FileWriter fw = new FileWriter(CAMINHO);
            gson.toJson(lista, fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
