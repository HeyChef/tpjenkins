package fr.epsi.eboutique.web.controller.site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.entity.CommandeLigne;
import fr.epsi.eboutique.business.entity.Produit;
import fr.epsi.eboutique.business.service.MarqueService;
import fr.epsi.eboutique.business.service.ProduitService;

@Controller
public class MobileController {

	@Inject
	private MarqueService marqueService;
	@Inject
	private ProduitService produitService;

	@GetMapping("/mobile/{id}")
	public ModelAndView displayMobile(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("public/mobile");
		mv.addObject("marques", this.marqueService.findAll());
		mv.addObject("produit", this.produitService.findById(id));
		return mv;
	}

	@RequestMapping(value = "/addPanier", method = RequestMethod.POST)
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		Integer quantite = Integer.valueOf(request.getParameter("quantite"));
		Long id = Long.valueOf(request.getParameter("produit"));

		CommandeLigne commandeLigne = new CommandeLigne();
		Produit produit = this.produitService.findById(id);
				
		commandeLigne.setQuantite(quantite);
		commandeLigne.setProduit(produit);

		Collection<CommandeLigne> commandes = new ArrayList<>();

		HttpSession session = request.getSession();
		Commande commande = new Commande();
		if (session.getAttribute("commande") != null) {
			commande = (Commande) session.getAttribute("commande");
			commandes = commande.getLignes();
			/*
			 * CommandeLigne com = commandes.stream() .filter( list ->
			 * list.getProduit().getIdentifier() == id) .findFirst() .ifPresent(list ->
			 * list.setQuantite(list.getQuantite()+quantite)) .orElse(null);
			 */
		}

		Boolean addCommandeLigne = true;

		for (CommandeLigne uneLigne : commandes) {
			if (uneLigne.getProduit().getIdentifier().equals(id)) {
				uneLigne.setQuantite(uneLigne.getQuantite() + quantite);
				addCommandeLigne = false;
			}
		}

		if (addCommandeLigne) {
			commandes.add(commandeLigne);
		}

		commande.setLignes(commandes);

		session.setAttribute("commande", commande);
		try {
			response.sendRedirect("accueil");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}