package com.eder.tcc.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class BaixarMaterialBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private StreamedContent streamedContent;
    
    public void descarregar(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        
        streamedContent = new DefaultStreamedContent(inputStream, 
                Files.probeContentType(file.toPath()), file.getName());
    }
    
    public void remover(File f) {
        // Se o arquivo passado for um diretório
        if (f.isDirectory()) {
                /* Lista todos os arquivos do diretório em um array 
                   de objetos File */
                File[] files = f.listFiles();
                // Identa a lista (foreach) e deleta um por um
                for (File file : files) {
                        file.delete();
                }
        }
}
    
    public StreamedContent getStreamedContent() {
        return streamedContent;
    }
}