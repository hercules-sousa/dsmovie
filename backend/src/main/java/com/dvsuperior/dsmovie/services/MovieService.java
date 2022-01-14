package com.dvsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dsmovie.dto.MovieDTO;
import com.dvsuperior.dsmovie.entities.Movie;
import com.dvsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> temp = repository.findAll(pageable);
		Page<MovieDTO> page = temp.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie temp = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(temp);
		return dto;
	}
}
