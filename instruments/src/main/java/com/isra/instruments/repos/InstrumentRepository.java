package com.isra.instruments.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.isra.instruments.entities.TypeInstrument;
import com.isra.instruments.entities.Instrument;

@RepositoryRestResource(path = "rest")
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
	List<Instrument> findByNomInstrument(String nom);
	 List<Instrument> findByNomInstrumentContains(String nom); 
	 
	 @Query("select p from Instrument p where p.nomInstrument like %:nom and p.prixInstrument > :prix")
	 List<Instrument> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select p from Instrument p where p.typeInstrument = ?1")
	 List<Instrument> findByTypeInstrument (TypeInstrument typeInstrument);
	 
	
	 List<Instrument> findByTypeInstrumentIdType(Long keyword);
	 List<Instrument> findByOrderByNomInstrumentAsc();
	 
	 @Query("select p from Instrument p order by p.nomInstrument ASC, p.prixInstrument DESC")
	 List<Instrument> trierInstrumentsNomsPrix ();
}