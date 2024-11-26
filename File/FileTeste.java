package Teste;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTeste {

    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try {
            // Cria o arquivo e verifica se foi criado
            System.out.println("Arquivo criado? " + file.createNewFile());

            // Verifica se o arquivo existe
            boolean exists = file.exists();
            System.out.println("Permissão de leitura? " + file.canRead());
            System.out.println("Caminho relativo: " + file.getPath());
            System.out.println("Caminho absoluto: " + file.getAbsolutePath());
            System.out.println("É diretório? " + file.isDirectory());
            System.out.println("Está oculto? " + file.isHidden());
            System.out.println("Última modificação: " + new Date(file.lastModified()));

            // Deleta o arquivo se ele existe
            if (exists) {
                System.out.println("Deletado? " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
