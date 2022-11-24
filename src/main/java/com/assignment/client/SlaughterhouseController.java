package com.assignment.client;

import com.assignment.client.dto.first_station.AnimalDto;
import com.assignment.client.dto.second_station.AnimalPartDto;
import com.assignment.client.dto.second_station.TrayDto;
import com.assignment.client.dto.third_station.PartPackDto;
import com.assignment.server.dao.first_station.AnimalDao;
import com.google.protobuf.Descriptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class SlaughterhouseController {


    private Logger logger = LoggerFactory.getLogger(SlaughterhouseController.class);


    SlaughterhouseClient slaughterhouseClient = new SlaughterhouseClient();


    @PostMapping("/animal")
    public ResponseEntity<Object> createAnimal(@RequestBody AnimalDto animal) {
        try {
            Map<Descriptors.FieldDescriptor, Object> animalResponse = slaughterhouseClient.createAnimal(animal);
            return new ResponseEntity<Object>(animalResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/animal-part")
    public ResponseEntity<Object> createAnimalPart(@RequestBody AnimalPartDto animalPart) {
        try {
            Map<Descriptors.FieldDescriptor, Object> animalPartResponse = slaughterhouseClient.createAnimalPart(animalPart);
            return new ResponseEntity<Object>(animalPartResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/tray")
    public ResponseEntity<Object> createTray(@RequestBody TrayDto tray) {
        try {
            Map<Descriptors.FieldDescriptor, Object> trayResponse = slaughterhouseClient.createTray(tray);
            return new ResponseEntity<Object>(trayResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/pack")
    public ResponseEntity<Object> createPack(@RequestBody PartPackDto pack) {
        try {
            Map<Descriptors.FieldDescriptor, Object> trayResponse = slaughterhouseClient.createPartPack(pack);
            return new ResponseEntity<Object>(trayResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animals/involvedIn/{id}")
    public ResponseEntity<Map<Long, Object>> getAnimalsInvolvedInProductId(@PathVariable long id)
    {
        try{
            return new ResponseEntity<>(slaughterhouseClient.getAnimalsInvolvedInProductId(id), HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}











/*
    @GetMapping("/animals")public List<Map<Descriptors.FieldDescriptor,Object>> getAllAnimals()
    {
        return slaughterhouseClient.getAllAnimals();
    }

    @GetMapping("/animals/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAnimalById(@PathVariable long id) throws InterruptedException {
        return slaughterhouseClient.getAnimalById(id);
    }

    @GetMapping("/animals/date/{date}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getAnimalsByDate(@PathVariable String date)
    {
        return slaughterhouseClient.getAnimalsByDate(date);
    }

    @RequestMapping(
            value="/animals/{id}",
    produces="application/json",
    method={RequestMethod.PUT})
    public ResponseEntity<Object> updateAnimal(@PathVariable long id,
                                               @RequestBody AnimalDao animalDao)
    {
        try{
            Map<Descriptors.FieldDescriptor, Object> animalResponse = slaughterhouseClient.updateAnimal(animalDao);
            return new ResponseEntity<Object>(animalResponse, HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animals/involvedIn/{productId}")
    public ResponseEntity<Object> getAnimalsInvolvedInProductId(@PathVariable long id)
    {
        try{
            List<Map<Descriptors.FieldDescriptor, Object>> animalsResponse = slaughterhouseClient.getAnimalsInvolvedInProductId(id);
            return new ResponseEntity<Object>(animalsResponse, HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/animals/products/in/animal/{id}")
    public ResponseEntity<Object> getProductsFromAnimalId(@PathVariable long id)
    {
        try{
            List<Map<Descriptors.FieldDescriptor, Object>> productsResponse = slaughterhouseClient.getProductsFromAnimalId(id);
            return new ResponseEntity<Object>(productsResponse, HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

 */


/*

    // CRUD for animal

    //CREATE
    @PostMapping("/animals")
    public ResponseEntity<Object> createAnimal(@RequestBody Animal animal)
    {
        try{
            Animal animalSaved = slaughterhouseRepo.save(animal);
            return new ResponseEntity<Object>(animalSaved, HttpStatus.OK);
        }catch(Exception e)
        {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

    }


    //READ
    @GetMapping("/animals")
    public ResponseEntity<Object> getAllAnimals()
    {
        try{
            Optional<List<Animal>> animals = slaughterhouseRepo.getAllAnimals();
            if(animals.isPresent())
            {
                return new ResponseEntity<Object>(animals.get(), HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e)
        {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/animals/id/{id}")
    public ResponseEntity<Object> getAnimalById(@PathVariable Long id)
    {
        try{
            Optional<Animal> animal =  slaughterhouseRepo.getById(id);
            if(animal.isPresent())
            {
                return new ResponseEntity<Object>(animal.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e)
        {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animals/date/{date}")
    public ResponseEntity<Object> getAnimalsByDate(@PathVariable
                                                   @DateTimeFormat(pattern="yyyy-MM-dd")
                                                   Date date)
    {
        try{
            Optional<List<Animal>> animals = slaughterhouseRepo.getAnimalsByDate(date);
            if(animals.isPresent())
            {
                return new ResponseEntity<Object>(animals.get(), HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/animals/{origin}")
    public ResponseEntity<Object> getAnimalByOrigin(@PathVariable String origin)
    {
        try{
            Optional<List<Animal>> animals = slaughterhouseRepo.getAnimalsByOrigin(origin);
            if(animals.isPresent())
            {
                return new ResponseEntity<Object>(animals, HttpStatus.OK);
            }else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable Long id,
                                               @RequestBody Animal animal)
    {
        try{
            animal.setRegistrationNr(id);
            Animal animalResponse = slaughterhouseRepo.updateAnimal(animal);
            return new ResponseEntity<Object>(animalResponse, HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/animals/{id}")
    public ResponseEntity<Object> deleteAnimal(@PathVariable Long id)
    {
        try{
            slaughterhouseRepo.deleteAnimal(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    }
}
*/




















