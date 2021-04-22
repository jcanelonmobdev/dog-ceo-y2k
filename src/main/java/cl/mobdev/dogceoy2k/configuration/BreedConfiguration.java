package cl.mobdev.dogceoy2k.configuration;

import cl.mobdev.dogceoy2k.application.data.breed.mapper.BreedDetailsModelMapper;
import cl.mobdev.dogceoy2k.application.data.breed.repository.BreedRepositoryImpl;
import cl.mobdev.dogceoy2k.application.data.images.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.images.datasource.BreedImagesDataSourceImpl;
import cl.mobdev.dogceoy2k.application.data.subbreeds.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.subbreeds.datasource.SubBreedsDataSourceImpl;
import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedRepository;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedDetailUseCase;
import cl.mobdev.dogceoy2k.application.presentation.controller.BreedDetailController;
import cl.mobdev.dogceoy2k.application.presentation.controller.BreedDetailControllerImpl;
import cl.mobdev.dogceoy2k.common.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BreedConfiguration {

    // Presentation

    @Bean
    BreedDetailController breedDetailController(BreedDetailUseCase breedDetailUseCase){
        return new BreedDetailControllerImpl(breedDetailUseCase);
    }

    // Domain.useCase

    @Bean
    BreedDetailUseCase breedDetailUseCase(
            BreedRepository breedRepository
    ){
        return new BreedDetailUseCase(breedRepository);
    }

    // Data.repository

    @Bean
    BreedRepository breedDetailRepository(
            BreedImagesDataSource breedImagesDataSource,
            SubBreedsDataSource subBreedsDataSource,
            Mapper<BreedDetailsModel, String> breedDetailModelStringMapper
    ){
        return new BreedRepositoryImpl(
                breedImagesDataSource, subBreedsDataSource, breedDetailModelStringMapper);
    }

    // Data.mapper

    @Bean
    Mapper<BreedDetailsModel, String> breedDetailModelStringMapper(){
        return new BreedDetailsModelMapper();
    }

    // Data.datasource

    @Bean
    SubBreedsDataSource subBreedsDataSource(
            RestOperations restOperations,
            BreedProperties breedProperties
    ){
        return new SubBreedsDataSourceImpl(restOperations, breedProperties);
    }

    @Bean
    BreedImagesDataSource breedImagesDataSource(
            RestOperations restOperations,
            BreedProperties breedProperties
    ){
        return new BreedImagesDataSourceImpl(restOperations, breedProperties);
    }

    // Configuration

    @Bean
    BreedProperties breedProperties() {

        return new BreedProperties();
    }

    // FrameWorks

    @Bean
    RestOperations restOperations() {

        return new RestTemplate();
    }
}