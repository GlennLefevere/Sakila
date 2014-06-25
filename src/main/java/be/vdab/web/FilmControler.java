package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.entities.Film;
import be.vdab.entities.FilmActor;
import be.vdab.services.ActorService;
import be.vdab.services.FilmActorService;
import be.vdab.services.FilmService;


@Controller
@RequestMapping("/films")
public class FilmControler {
	private static final String OPTITEL_VIEW = "/films/optitel";
	private static final String FILM_VIEW = "/films/film";
	private FilmService filmService;
	private ActorService actorService;
	private FilmActorService  filmActorService;
	
	@Autowired
	public FilmControler(FilmService filmService, ActorService actorService, FilmActorService  filmActorService){
		this.filmService = filmService;
		this.actorService = actorService;
		this.filmActorService = filmActorService;
	}

	@RequestMapping(value = "optitel", method = RequestMethod.GET)
	ModelAndView createSort() {
		return new ModelAndView(OPTITEL_VIEW).addObject(new FilmTitel());
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"titel"}, value = "optitel")
	ModelAndView testje(@Valid FilmTitel filmTitel, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView(OPTITEL_VIEW);
		if (!bindingResult.hasErrors()) {
			modelAndView.addObject("films", filmService.findByStukNaam(filmTitel.getTitel()));
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "{film}")
	ModelAndView filmMetActeurs(@PathVariable Film film){
		return new ModelAndView(FILM_VIEW).addObject(film).addObject(new ActeurNaam());
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"naamdeel"}, value="{film}")
	ModelAndView findActeurs(@PathVariable Film film , @Valid ActeurNaam acteurNaam, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView(FILM_VIEW).addObject(film);
		if (!bindingResult.hasErrors()) {
			modelAndView.addObject("acteurs", actorService.findByLastNameStartingWith(acteurNaam.getNaamdeel())).addObject(acteurNaam).addObject(new ActorForm());
		}
		return modelAndView;
	}
	
	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/films/{id}";
	@RequestMapping(method = RequestMethod.POST, value="{film}/toevoegen")
	ModelAndView create(@PathVariable Film film, @Valid ActorForm actorForm, BindingResult bindingResult, @RequestParam String naamdeel, RedirectAttributes redirectAttributes) {
		if(!bindingResult.hasErrors()){
			filmActorService.create(new FilmActor(film, actorForm.getActor()));
			redirectAttributes.addAttribute("id", film.getId());
			return new ModelAndView(REDIRECT_NA_TOEVOEGEN);			
		}
		ModelAndView modelAndView = new ModelAndView(FILM_VIEW);
		modelAndView.addObject(film);
		ActeurNaam acteurNaam=new ActeurNaam();
		acteurNaam.setNaamdeel(naamdeel);
		modelAndView.addObject(acteurNaam);
		modelAndView.addObject("acteurs", actorService.findByLastNameStartingWith(acteurNaam.getNaamdeel()));
		return modelAndView;
	}
	
}
