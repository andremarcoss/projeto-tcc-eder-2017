package com.eder.tcc.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.eder.tcc.util.MatreialUtil;

@ManagedBean
@ViewScoped
public class MaterialBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<File> arquivos = new ArrayList<>();
	private StreamedContent streamedContent;

	@PostConstruct
	public void postConstruct() {
		arquivos = new ArrayList<>(MatreialUtil.listar());
	}

	public void carregar(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();

		try {
			File arquivo = MatreialUtil.escrever(uploadedFile.getFileName(), uploadedFile.getContents());

			arquivos.add(arquivo);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Carregamento completo", "O arquivo " + arquivo.getName() + " foi salvo!"));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
		}
	}

	public void baixar(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);

		streamedContent = new DefaultStreamedContent(inputStream, Files.probeContentType(file.toPath()),
				file.getName());
	}

	public String remover(File arquivo) {
		// Se o arquivo passado for um diretório
		if (arquivo.isDirectory()) {
			/*
			 * Lista todos os arquivos do diretório em um array de objetos File
			 */
			File[] files = arquivo.listFiles();
			// Identa a lista (foreach) e deleta um por um
			for (File file : files) {
				file.delete();
			}
		}
		arquivo.delete();
		return "restrito/material_apoio";
		// System.out.println(arquivo.getName() + " - " + arquivo.getPath());
	}

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public List<File> getArquivos() {
		return arquivos;
	}

}
