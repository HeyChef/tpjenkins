package fr.epsi.eboutique.web.controller.site;

import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.epsi.eboutique.business.service.MarqueService;
import fr.epsi.eboutique.business.service.ProduitService;

@Controller
public class PanierController {

	@Inject
	private MarqueService marqueService;

	@Inject
	private ProduitService produitService;

	@GetMapping("/commande")
	public ModelAndView displayCommande() {
		ModelAndView mv = new ModelAndView("public/commande");
		mv.addObject("marques", this.marqueService.findAll());
		mv.addObject("produits", this.produitService.findAll().stream().limit(10).collect(Collectors.toList()));
		return mv;
	}
}
