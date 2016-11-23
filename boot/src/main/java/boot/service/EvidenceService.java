package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.EvidenceRepository;
import boot.model.Evidence;

@Service @Transactional
public class EvidenceService {
	
private final EvidenceRepository evidenceRepository;
	
	public EvidenceService(EvidenceRepository evidenceRepository) {
		super();
		this.evidenceRepository = evidenceRepository;
	}
	
	public List<Evidence> findAll(){
		List<Evidence> evidences = new ArrayList<Evidence>();
		for (Evidence evidence : evidenceRepository.findAll()) {
			evidences.add(evidence);
		}
		return evidences;
	}
	
	public void save(Evidence evidence){
		evidenceRepository.save(evidence);
	}
	
	public void delete(int id){
		evidenceRepository.delete(id);
	}
	
	public Evidence findEvidence(int id){
		return evidenceRepository.findOne(id);
	}
}
