package com.isra.instruments.service;

import java.util.List;

import com.isra.instruments.entities.TypeInstrument;
import com.isra.instruments.entities.Instrument;

public interface InstrumentService {

	
	Instrument saveInstrument(Instrument p);
	Instrument updateInstrument(Instrument p);
	void deleteInstrument(Instrument p);
	void deleteInstrumentById(Long id);
	Instrument getInstrument(Long id);
	List <Instrument> getAllInstruments();
	
	List<Instrument> findByNomInstrument(String nom);
	
	 List<Instrument> findByNomInstrumentContains(String nom); 
	
	 List<Instrument> findByNomPrix ( String nom, Double prix);
	 
	 List<Instrument> findByTypeInstrument (TypeInstrument typeInstrument);
	 
	 List<Instrument> findByTypeInstrumentIdType(Long id);
	 
	 List<Instrument> findByOrderByNomInstrumentAsc();
	 
	 List<Instrument> trierInstrumentsNomsPrix ();
}
