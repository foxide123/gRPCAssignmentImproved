package com.assignment.client;

import com.assignment.protobuf.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class SlaughterhouseController {


    private Logger logger = LoggerFactory.getLogger(SlaughterhouseController.class);


    SlaughterhouseClient slaughterhouseClient;


    @GetMapping("/animals/{id}")
    public ResponseEntity<Object> getAnimalById(@PathVariable long id) {
        try {
            Optional<Animal> animal = slaughterhouseClient.getAnimalById(id);
            if (animal.isPresent()) {
                return new ResponseEntity<Object>(animal.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

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

 */
    }
}





















