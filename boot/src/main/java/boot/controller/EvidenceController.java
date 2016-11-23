package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Evidence;
import boot.service.EvidenceService;

@Controller
public class EvidenceController {

	@Autowired
	private EvidenceService evidenceService;
	
	@GetMapping("evidence")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "evidence";
	}
		
	@GetMapping("/all-evidences")
	public String allEvidences(HttpServletRequest request){
		request.setAttribute("evidences", evidenceService.findAll());
		request.setAttribute("mode", "MODE_EVIDENCES");
		return "evidence";
	}
	
	@GetMapping("/new-evidence")
	public String newEvidence(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_EVIDENCE");
		return "evidence";
	}
	
	@PostMapping("/save-evidence")
	public String saveEvidence(@ModelAttribute Evidence evidence, BindingResult bindingResult, HttpServletRequest request){
		evidenceService.save(evidence);
		request.setAttribute("evidences", evidenceService.findAll());
		request.setAttribute("mode", "MODE_EVIDENCES");
		return "evidence";
	}
	
	@GetMapping("/update-evidence")
	public String updateEvidence(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("evidence", evidenceService.findEvidence(id));
		request.setAttribute("mode", "MODE_UPDATE_EVIDENCE");
		return "evidence";
	}
	
	@GetMapping("/delete-evidence")
	public String deleteEvidence(@RequestParam int id, HttpServletRequest request){
		evidenceService.delete(id);
		request.setAttribute("evidences", evidenceService.findAll());
		request.setAttribute("mode", "MODE_EVIDENCES");
		return "evidence";
	}
}
