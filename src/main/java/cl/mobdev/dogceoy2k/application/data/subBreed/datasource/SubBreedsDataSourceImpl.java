package cl.mobdev.dogceoy2k.application.data.subBreed.datasource;

import cl.mobdev.dogceoy2k.application.data.subBreed.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.configuration.BreedProperties;
import org.springframework.web.client.RestOperations;

public class SubBreedsDataSourceImpl implements SubBreedsDataSource {

    private final RestOperations restOperations;
    private final BreedProperties breedProperties;

    public SubBreedsDataSourceImpl(
            RestOperations restOperations,
            BreedProperties breedProperties
    )
    {
        this.restOperations = restOperations;
        this.breedProperties = breedProperties;
    }

    @Override
    public SubBreedsEntity getSubBreeds(String breed)
    {
        return this.restOperations.getForObject(this.breedProperties.getSubBreedsURL(breed), SubBreedsEntity.class);
    }
}
