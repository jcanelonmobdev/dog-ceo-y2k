package cl.mobdev.dogceoy2k.application.domain.model;

import java.util.ArrayList;
import java.util.List;

public class BreedModel {
    public String breed;
    public List<String> subBreed;
    public List<String> images;

    public BreedModel(){
        this.breed = "";
        this.subBreed = new ArrayList<>();
        this.images = new ArrayList<> ();
    }

    public BreedModel(String breed, SubBreedsModel subBreeds, BreedImagesModel breedImages){
        this.breed = breed;
        this.subBreed = subBreeds.subBreed;
        this.images = breedImages.images;
    }
}
