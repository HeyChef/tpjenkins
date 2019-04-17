package fr.epsi.eboutique.web.controller.site;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.service.CommandeService;
import fr.epsi.eboutique.business.service.MarqueService;
import fr.epsi.eboutique.business.service.ProduitService;

@Controller
public class PanierController {

    @Inject
    private MarqueService   marqueService;

    @Inject
    private ProduitService  produitService;

    @Inject
    private CommandeService commandeService;

    @GetMapping( "/commande" )
    public ModelAndView displayCommande() {
        ModelAndView mv = new ModelAndView( "public/commande" );
        mv.addObject( "marques", this.marqueService.findAll() );
        mv.addObject( "produits", this.produitService.findAll().stream().limit( 10 ).collect( Collectors.toList() ) );
        return mv;
    }

    @RequestMapping( value = "/addCommande", method = RequestMethod.POST )
    public void handleRequest( HttpServletRequest request, HttpServletResponse response ) {

        HttpSession session = request.getSession();
        Commande commande = (Commande) session.getAttribute( "commande" );

        this.commandeService.addCommande( commande );

        session.removeAttribute( "commande" );

        try {
            response.sendRedirect( "accueil" );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
