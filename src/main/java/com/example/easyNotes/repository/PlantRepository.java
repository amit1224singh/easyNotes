package com.example.easyNotes.repository;

import com.example.easyNotes.model.PlantDetails;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlantRepository extends CrudRepository<PlantDetails,Integer> {

/**
 * Find all the details
 */
    public Iterable<PlantDetails> findAll();


//@Query("Select p from PlantDetails p where p.genus =:genus and p.species =:species ")
    List<PlantDetails> findByGenusAndSpecies(String genus,String species);





    /**
     *  FIND THE PLANT BY ITS HABIT
     *  USE IT TO SEARCH ALL THE PLANT BELONGS TO SAME HABIT
     *  USE IN MAIN PAGE (/PLANT/HABIT)
     */

//    @Query("SELECT p from PlantDetails p where p.habit =:habit")
   // public  List<PlantDetails> findAllByHabit(@Param("habit") String habit);
    public  List<PlantDetails> findAllByHabit(String habit);

    /**
     * FIND BY THE FLOWER COLOUR
     *
     * (/PLANT/FLOWERCOLOUT)
     */
   List<PlantDetails>findByFlowerColour(String flowerColour);


   // Method to find from local name

//    List<PlantDetails>findBySynonymsContains(String synonym);
//    @Query("select p from PlantDetails p where p.local_name =:local_name")

    List<PlantDetails>findByLocalNameContaining(String LocalName);

    // Method to find from the leaf type leaf arrangement	leaf type	leaf shape	leaf base	leaf tip 	leaf margin


    List<PlantDetails>findByLeafArrangementContainsOrLeafBaseContainsOrLeafShapeContainsOrLeafTipContainsOrLeafMarginContainsAllIgnoreCase(String arrangement,
                                                                                                                                           String base,String shape,
                                                                                                                                           String tip,String margin);

    @Query("Select p from PlantDetails p where LOWER(p.leafArrangement) like lower(concat('%',:searchTerm,'%'))" +
            "or lower(p.leafBase) like lower(concat('%',:searchTerm,'%') )" +
            "or lower(p.leafMargin) like lower(concat('%',:searchTerm,'%'))" +
            "or lower(p.leafShape) like lower(concat('%',:searchTerm,'%'))" +
            "or lower(p.leafType)like lower(concat('%',:searchTerm,'%')) " +
            "or lower(p.leafTip) like lower(concat('%',:searchTerm,'%')) ")
    List<PlantDetails> findByLeafCharacterstics(@Param("searchTerm") String searchTerm);
}
