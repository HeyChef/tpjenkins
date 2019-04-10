package fr.epsi.eboutique.web.controller.site;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epsi.eboutique.business.entity.Marque;
import fr.epsi.eboutique.business.entity.Produit;
import fr.epsi.eboutique.business.service.MarqueService;
import fr.epsi.eboutique.business.service.ProduitService;

@Controller
public class AccueilController {

  @Inject
  private MarqueService marqueService;
  @Inject
  private ProduitService produitService;
  
  /**
   * Permet d'afficher la page d'accueil
   * 
   * @param critere Critere de reccherche
   * @return
   */
  @GetMapping("/accueil")
  public ModelAndView displayAccueil(@RequestParam(value = "critere", required = false) String critere) {
    ModelAndView mv = new ModelAndView("public/accueil");
    mv.addObject("marques", this.marqueService.findAll());
    if(critere == null) {
        mv.addObject("produits", this.produitService.findAll().stream().limit(10).collect(Collectors.toList()));
    }
    else {
    	Collection<Produit> optionalProducts = this.produitService.findByLibelle(critere);
    	if(optionalProducts.isEmpty()) {
    		mv.addObject("errorMessage", "Aucun produit ne correspond � votre recherche !");
    	}
    	else {
            mv.addObject("produits", optionalProducts.stream().limit(10).collect(Collectors.toList()));
    	}
    }
    //TODO Recuperer les 10 premiers produits
    
    //TODO Recuperer le nombre total de produits afin de permettre la pagination
    
    return mv;
  }
  
  
  @GetMapping("/accueil/{marque}")
  public ModelAndView displayMarque(@PathVariable String marque) {
    ModelAndView mv = new ModelAndView("public/accueil");
    mv.addObject("marques", this.marqueService.findAll());
    mv.addObject("produits", this.produitService.findByMarque(marque));

    
    //TODO Recuperer les 10 premiers produits correspondant à la marque recherché
    
    //TODO Recuperer le nombre total de produits correspondant à la marque recherché 
    //afin de permettre la pagination
    
    return mv;
  }
  
  
}
