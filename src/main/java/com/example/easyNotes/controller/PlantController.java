package com.example.easyNotes.controller;

//import org.springframework.stereotype.Controller;
import com.example.easyNotes.model.PlantDetails;
import com.example.easyNotes.repository.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantController {

    private static final Logger logger = LoggerFactory
            .getLogger(PlantController.class);
    @Autowired
    PlantRepository plantRepository;
    @GetMapping("/showAll")
    public List<PlantDetails> findAllPlants()
    {

        return  (List<PlantDetails>)plantRepository.findAll();
    }


    // find the plant details by the species and genus

    @GetMapping(value="/plants/{genus}/{species}")
    public  List<PlantDetails> getPlantByGenusAndSpecies(@PathVariable String genus,@PathVariable String species)
    {
        List<PlantDetails> plantDetails = plantRepository.findByGenusAndSpecies(genus,species);

//        List<PlantDetails> plantList = new ArrayList<>();
        if(plantDetails.size()<1)
        {
            logger.error("no plant record found");
            //throw the error here
        }

        else
        {

        //
        //
        //}


        }

        return plantDetails;
    }





/*MEHTOD TO RETRIVE PLANTS OF SAME HABIT*/

@GetMapping("/plants/habits/{habit}")
    public  List<PlantDetails> findPlantOfSameHabit(@PathVariable( value ="habit") String habit){
        List<PlantDetails> list = plantRepository.findAllByHabit(habit);

    return  list;
}


/*Method to find plant by flower colour
*mapping(/plants/flowerColour) */
@GetMapping("/plants/flowerColour/{colour}")
    public  List<PlantDetails> findByFlowerColour(@PathVariable(value = "colour") String colour)
{
    List<PlantDetails> plantDetails= plantRepository.findByFlowerColour(colour);

        logger.error("fetching flower ");


    return plantDetails;
}
// find the plant details by synonym
@GetMapping("/plants/localName/{localName}")
    public  List<PlantDetails> findByLocalName(@PathVariable(value = "localName") String localName)
{
    List<PlantDetails> list= plantRepository.findByLocalNameContaining(localName);
    return  list;
}

// find the details from the leaf character

@GetMapping("/plants/leaf/{arrangement}/{base}/{shape}/{tip}/{margin}")
    List<PlantDetails> getPlantByLeaf(@PathVariable(value = "arrangement")String arrangement,
                                      @PathVariable(value="base") String base,
                                      @PathVariable(value = "shape")String shape,
                                      @PathVariable(value = "tip")String tip,
                                      @PathVariable(value = "margin")String margin)

{
    List<PlantDetails> list = plantRepository.findByLeafArrangementContainsOrLeafBaseContainsOrLeafShapeContainsOrLeafTipContainsOrLeafMarginContainsAllIgnoreCase(arrangement, base, shape, tip, margin);
    return list;
}

    @GetMapping("/plants/leaf/search/{SearchTerm}")
List<PlantDetails> getbyLeafCharacterstics(@PathVariable(value = "SearchTerm") String searchTerm)
{
    List<PlantDetails> plantlist = plantRepository.findByLeafCharacterstics(searchTerm);

    return  plantlist;
}

}

