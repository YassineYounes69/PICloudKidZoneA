package com.example.kidszonea4arctic3.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;

@Controller(value = "uploadFile")
@ELBeanName(value = "uploadFile")
public class UploadFile {
    private String folder = "C:\\jsf-upload\\";
    private String destination = "/tmp/";


    private Part uploadedFile;


    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }


    public void click(){
        System.out.println("click!");
    }

    public void saveFile() {

        if (uploadedFile!=null) {

            System.out.println("saveFile method invoked..");
            System.out.println("content-type:{0}" + uploadedFile.getContentType());
            System.out.println("filename:{0}" + uploadedFile.getName());
            System.out.println("submitted filename:{0}" + uploadedFile.getSubmittedFileName());
            System.out.println("size:{0}" + uploadedFile.getSize());
            String fileName = "";

            try {

                fileName = getFilename(uploadedFile);

                System.out.println("fileName  " + fileName);

                uploadedFile.write(folder + fileName);


            } catch (IOException ex) {
                System.out.println(ex);


            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName + " Uploaded!"));
        }
    }


    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
    }

    public void uploadaaa(FileUploadEvent event) {
        System.out.println("fired upload");
        UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        String contentType = uploadedFile.getContentType();
        byte[] contents = uploadedFile.getContents(); // Or getInputStream()
        // ... Save it, now!
    }
    public void upload(FileUploadEvent event) {
        System.out.println("click");
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
