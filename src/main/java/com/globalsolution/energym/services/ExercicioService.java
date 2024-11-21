package com.globalsolution.energym.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.globalsolution.energym.domain.entities.Academia;
import com.globalsolution.energym.domain.entities.Exercicio;
import com.globalsolution.energym.domain.entities.Praticante;
import com.globalsolution.energym.domain.enums.TipoExercicio;
import com.globalsolution.energym.dto.NovoExercicioDTO;
import com.globalsolution.energym.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AcademiaService academiaService;

    @Autowired
    private NotificadorPraticante notificadorPraticante;

    @Autowired
    private PraticanteService praticanteService;

    public Page<Exercicio> getPageExercicios(int page, int size) {
        Academia academiaAutenticada = academiaService.findByUserId(userService.authenticated().getId());
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id"));
        return repository.findAllByAcademiaId(pageable,academiaAutenticada.getId());
    }

    public Exercicio save(Exercicio exercicio) {
        return repository.save(exercicio);
    }

    public void saveNewExercicio(NovoExercicioDTO novoExercicioDTO) throws JsonProcessingException {
        Academia academia = academiaService.findById(novoExercicioDTO.getAcademiaId());
        Praticante praticante = praticanteService.findById(novoExercicioDTO.getPraticanteId());

        Exercicio exercicio = new Exercicio();
        exercicio.setAcademia(academia);
        exercicio.setPraticante(praticante);
        exercicio.setTipo(TipoExercicio.toEnum(novoExercicioDTO.getTipo()));
        exercicio.setKm(novoExercicioDTO.getKm());
        exercicio.setPontos(somarPontos(exercicio.getKm(), exercicio.getTipo()));

        save(exercicio);
        praticante.setPontos(praticante.getPontos() + exercicio.getPontos());
        notificadorPraticante.integrar("Parabéns! Você gerou "+exercicio.getKm()+"Km usando a "+exercicio.getTipo().getDescricao()+" e foi recompensado com "+exercicio.getPontos()+" pontos!");

        praticanteService.save(praticante);
    }

    private double somarPontos(double km, TipoExercicio tipoExercicio){
        return km * (tipoExercicio.getCod() == 2 ? 100 : 150);
    }
}
