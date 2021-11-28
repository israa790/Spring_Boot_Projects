package com.isra.instruments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isra.instruments.repos.InstrumentRepository;
import com.isra.instruments.entities.Instrument;
import com.isra.instruments.entities.TypeInstrument;

@Service
public class InstrumentServiceImpl implements InstrumentService{

	@Autowired
	InstrumentRepository instrumentRepository;
	@Override
	public Instrument saveInstrument(Instrument p) {
		return instrumentRepository.save(p);
	}

	@Override
	public Instrument updateInstrument(Instrument p) {
		return instrumentRepository.save(p);
	}

	@Override
	public void deleteInstrument(Instrument p) {
		instrumentRepository.delete(p);	
	}

	@Override
	public void deleteInstrumentById(Long id) {
		instrumentRepository.deleteById(id);
		
	}

	@Override
	public Instrument getInstrument(Long id) {
		return	instrumentRepository.findById(id).get();
	}

	@Override
	public List<Instrument> getAllInstruments() {
		return instrumentRepository.findAll();
	}

	@Override
	public List<Instrument> findByNomInstrument(String nom) {

		return instrumentRepository.findByNomInstrument(nom);
	}

	@Override
	public List<Instrument> findByNomInstrumentContains(String nom) {
		return instrumentRepository.findByNomInstrumentContains(nom);
	}

	@Override
	public List<Instrument> findByNomPrix(String nom, Double prix) {
		return instrumentRepository.findByNomPrix(nom,prix);
	}

	@Override
	public List<Instrument> findByTypeInstrument(TypeInstrument typeInstrument) {
		return instrumentRepository.findByTypeInstrument(typeInstrument);
		}

	@Override
	public List<Instrument> findByTypeInstrumentIdType(Long id) {
		
		return instrumentRepository.findByTypeInstrumentIdType(id);
	}

	@Override
	public List<Instrument> findByOrderByNomInstrumentAsc() {
	
		return instrumentRepository.findByOrderByNomInstrumentAsc();
	}

	@Override
	public List<Instrument> trierInstrumentsNomsPrix() {
		
		return instrumentRepository.trierInstrumentsNomsPrix();
	}

}
