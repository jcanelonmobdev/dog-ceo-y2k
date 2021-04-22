package cl.mobdev.dogceoy2k.configuration;

import cl.mobdev.dogceoy2k.application.data.images.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.subbreeds.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedRepository;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedDetailUseCase;
import cl.mobdev.dogceoy2k.application.presentation.controller.BreedDetailController;
import cl.mobdev.dogceoy2k.common.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.web.client.RestOperations;

import static org.assertj.core.api.Assertions.assertThat;


class BreedConfigurationTest {

    /*
     * Setup a context runner with the class BreedConfiguration
     * in it. For that, I use ApplicationContextRunner#withUserConfiguration()
     * methods to populate the context.
     */
    ApplicationContextRunner context = new ApplicationContextRunner()
            .withUserConfiguration(BreedConfiguration.class);

    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldCheckPresenceOf_breedDetailController() {
        context.run(it -> assertThat(it).hasSingleBean(BreedDetailController.class));
    }

    @Test
    void shouldCheckPresenceOf_breedDetailUseCase() {
        context.run(it -> assertThat(it).hasSingleBean(BreedDetailUseCase.class));
    }

    @Test
    void shouldCheckPresenceOf_breedDetailRepository() {
        context.run(it -> assertThat(it).hasSingleBean(BreedRepository.class));
    }

    @Test
    void shouldCheckPresenceOf_breedDetailModelStringMapper() {
        context.run(it -> assertThat(it).hasSingleBean(Mapper.class));
    }

    @Test
    void shouldCheckPresenceOf_subBreedsDataSource() {
        context.run(it -> assertThat(it).hasSingleBean(SubBreedsDataSource.class));
    }

    @Test
    void shouldCheckPresenceOf_breedImagesDataSource() {
        context.run(it -> assertThat(it).hasSingleBean(BreedImagesDataSource.class));
    }

    @Test
    public void shouldCheckPresenceOf_breedProperties(){
        context.run(it -> assertThat(it).hasSingleBean(BreedProperties.class));
    }

    @Test
    public void shouldCheckPresenceOf_restOperations(){
        context.run(it -> assertThat(it).hasSingleBean(RestOperations.class));
    }
}