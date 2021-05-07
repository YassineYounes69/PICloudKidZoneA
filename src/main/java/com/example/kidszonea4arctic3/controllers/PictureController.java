package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Picture;
import com.example.kidszonea4arctic3.services.PictureService;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.InputStream;

@Named
@ManagedBean
@Scope(value = "session")
public class PictureController {

    @Inject
    public Picture picture;

    public UploadedFile file;

    @Inject
    PictureService pictureService;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void clicked(){
        System.out.println("click !");
    }

    public void upload() {

        if(file != null) {
            try {
                System.out.println("entered picture controller upload try");
                InputStream inputstream = file.getInputstream();
                Picture picture = new Picture();
                picture.setName("image");
                // pass the photo data and the photo metadata to our business logic layer.
                pictureService.savePhoto(picture, inputstream);

                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("entered picture controller upload catch");
                e.printStackTrace();
                FacesMessage message = new FacesMessage("There was a problem, your file was not uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

        } else {
            System.out.println("file null");
        }

    }
}
