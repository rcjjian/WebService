package team.sevendwarfs.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.sevendwarfs.persistence.entities.Movie;
import team.sevendwarfs.persistence.entities.Person;
import team.sevendwarfs.persistence.repository.MovieRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * MovieService 服务类
 * Created by deng on 2017/4/25.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void create(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public void delete(Integer id) {
        this.movieRepository.delete(id);
    }

    @Override
    public void delete(Movie movie) {
        this.movieRepository.delete(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie findById(Integer id) {
        return this.movieRepository.findOne(id);
    }

    @Override
    public Movie findByChineseName(String name) {
        return this.movieRepository.findByChineseName(name);
    }

    @Override
    public Movie findByEnglishName(String name) {
        return this.movieRepository.findByEnglishName(name);
    }

    @Override
    public List<Movie> findByDate(Date date) {
        return this.movieRepository.findByReleaseDate(date);
    }

    @Override
    public List<Movie> findDateAfter(Date date) {
        return this.movieRepository.findByReleaseDateAfter(date);
    }

    @Override
    public List<Movie> findShowing() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);

        return this.movieRepository.findByReleaseDateAfter(calendar.getTime());
    }

    @Override
    public List<Movie> findByPerson(Person person) {
        return this.movieRepository.findByMoviersContains(person);
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = this.movieRepository.findAll();
//        for (Movie movie : movies) { movie.getMoviers(); }
        return movies;
    }
}
