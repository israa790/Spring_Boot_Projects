package com.isra.instruments;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isra.instruments.entities.TypeInstrument;
import com.isra.instruments.entities.Instrument;
import com.isra.instruments.repos.InstrumentRepository;

@SpringBootTest
class InstrumentsApplicationTests {

	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateInstrument()
	{
		Instrument Instr=new Instrument("Guitare",300.0);
		instrumentRepository.save(Instr);
	}
	
	@Test
	public void testFindInstrument()
	{
		Instrument p=instrumentRepository.findById(1L).get();
		System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit()
	{
		Instrument p = instrumentRepository.findById(1L).get();
	p.setPrixInstrument(1000.0);
	instrumentRepository.save(p);
	}
	
	@Test
	public void testDeleteProduit()
	{
		instrumentRepository.deleteById(3L);;
	}
	 
	@Test
	public void testListerTousProduits()
	{
	List<Instrument> prods = instrumentRepository.findAll();
	for (Instrument p : prods)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testFindByNomInstrument()
	{
	List<Instrument> instrs = instrumentRepository.findByNomInstrument("violon");
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	
	@Test
	public void testFindByNomInstrumentContains ()
	{
	List<Instrument> instrs=instrumentRepository.findByNomInstrumentContains("p");
	for (Instrument p : instrs)
	{
	System.out.println(p);
	} }
	
	@Test
	public void testfindByNomPrix()
	{
	List<Instrument> instrs = instrumentRepository.findByNomPrix("violon", 100.0);
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByTypeInstrument()
	{
		TypeInstrument cat = new TypeInstrument();
	cat.setIdType(1L);
	List<Instrument> instrs = instrumentRepository.findByTypeInstrument(cat);
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByTypeInstrumentIdType()
	{
	List<Instrument> instrs = instrumentRepository.findByTypeInstrumentIdType(1L);
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	 }
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Instrument> instrs =
			instrumentRepository.findByOrderByNomInstrumentAsc();
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Instrument> instrs = instrumentRepository.trierInstrumentsNomsPrix();
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
}
