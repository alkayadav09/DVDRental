package com.springmvc.practice.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.springmvc.practice.model.Film;

@Repository("movieRepository")
public class MovieRepository {

	@PersistenceContext(unitName="punit")
	private EntityManager em;
	final static Logger logger = Logger.getLogger(MovieRepository.class);
	

	public List<Film> getAllMovies(Integer offset , Integer maxResults){
		List<Object[]> filmsRows = null;
		try{
		Query query =  em.createQuery("select f.id, f.title, f.description, f.releaseYear, f.rentalDuration from Film f order by f.title");
		
		filmsRows=query.setMaxResults(maxResults)
					.setFirstResult(offset)
					.getResultList();
		}catch(Exception ex){
			logger.error("exception occured", ex);	
		}
		List<Film> films = new ArrayList(filmsRows.size());
		for (Object[] row : filmsRows) {
			
			Film f = new Film();
			f.setId((Integer)row[0]);
			f.setTitle((String)row[1]);
			f.setDescription((String)row[2]);
			f.setReleaseYear((Integer)row[3]);
			f.setRentalDuration((Integer)row[4]);
			films.add(f);
		}
		return films ;
		
	}
	
	public List<Integer> getReleaseYears(){
		List<Integer> filmsRows = null;
		Film f = new Film();
		try{
		Query query = null;
		query = em.createQuery("select distinct f.releaseYear from Film f ");
		filmsRows=query.getResultList();
		System.out.println("hello");
		}catch(Exception ex){
			logger.error("exception occured", ex);	
		}
		List<Integer> year = new ArrayList();
		Integer releaseYear = filmsRows.size();
		for (int i=0 ; i< releaseYear ; i++) {
			
			//f.setReleaseYear((Integer)row[0]);
			
			//releaseYear.add(row[0]);
			if(filmsRows.get(i)!=null){
				year.add(filmsRows.get(i));
			}
		}
		
		return year ;
		
	}
	
	public List<Film> getPaginatedMovie(String title , Integer offset , Integer paginatedMaxResult){
		Query query;
		List films;
		if(title==null){
			query = em.createQuery("select f from Film f order by f.title");
			films=query.setMaxResults(paginatedMaxResult)
					.setFirstResult(offset)
					.getResultList();
		}
		else{
			query = em.createQuery("select f from Film f where f.title= :title");
			films=query.setParameter("title", title).getResultList();
		}
	    
		//List films = query.setParameter("title", title).getResultList();
		return films ;
		
	}
	
	public List<Film> getSortedMovies(Integer offset , Integer maxResults, String columnName){
		List<Object[]> filmsRows = null;
		try{
		Query query = null;
		if(columnName == null || columnName.equals("title")){
			query = em.createQuery("select f.id, f.title, f.description, f.releaseYear, f.rentalDuration from Film f order by f.title ");
		}
		else if(columnName.equals("id")){
			query = em.createQuery("select f from Film f order by f.id ");
		}
		else if(columnName.equals("description")){
			query = em.createQuery("select f from Film f order by f.description ");
		}
		else if(columnName.equals("releaseYear")){
			query = em.createQuery("select f from Film f order by f.releaseYear ");
		}
		else if(columnName.equals("rentalDuration")){
			query = em.createQuery("select f from Film f order by f.rentalDuration ");
		}
		filmsRows=query.setMaxResults(maxResults)
					.setFirstResult(offset)
					.getResultList();
		}catch(Exception ex){
			logger.error("exception occured", ex);
			
		}
		List<Film> films = new ArrayList(filmsRows.size());
		for (Object[] row : filmsRows) {
			
			Film f = new Film();
			f.setId((Integer)row[0]);
			f.setTitle((String)row[1]);
			f.setDescription((String)row[2]);
			f.setReleaseYear((Integer)row[3]);
			f.setRentalDuration((Integer)row[4]);
			
			
			films.add(f);
		}
		//List films = query.setParameter("title", title).getResultList();
		return films ;
		
	}
	
	public List<Film> getMovieByName(String title , Integer offset , Integer maxResults){
		Query query;
		List films;
		if(title==null){
			query = em.createQuery("select f from Film f ");
			films=query.setMaxResults(maxResults)
					.setFirstResult(offset)
					.getResultList();
		}
		else{
			query = em.createQuery("select f from Film f where f.title= :title");
			films=query.setParameter("title", title)
					.setMaxResults(maxResults)
					.setFirstResult(offset)
					.getResultList();
		}
	    
		//List films = query.setParameter("title", title).getResultList();
		return films ;
		
	}
	
	
	public List<Film> getMovieByYear(Integer year , Integer offset , Integer maxResults){
		Query query;
		List films;
		if(year==null){
			query = em.createQuery("select f from Film f ");
			films=query.setMaxResults(maxResults)
					.setFirstResult(offset)
					.getResultList();
		}
		else{
			query = em.createQuery("select f from Film f where f.releaseYear= :releaseYear");
			films=query.setParameter("releaseYear", year)
				//	.setMaxResults(maxResults)
				//	.setFirstResult(offset)
					.getResultList();
		}
	    
		//List films = query.setParameter("title", title).getResultList();
		return films ;
		
	}
	
	public List<Film> getMovieByActor(Integer actorId , Integer offset , Integer maxResults){
		Query query;
		List films;
		if(actorId==null){
			query = em.createQuery("select f from Film f ");
			films=query.setMaxResults(maxResults)
					.setFirstResult(offset)
					.getResultList();
		}
		else{
			query = em.createQuery("select f from Film f join FilmActor fa on f.id = fa.filmId join Actor a on a.id = fa actorId where a.id= :actorId");
			films=query.setParameter("actorId", actorId)
				//	.setMaxResults(maxResults)
				//	.setFirstResult(offset)
					.getResultList();
		}
	    
		//List films = query.setParameter("title", title).getResultList();
		return films ;
		
	}
	
	public List<Film> getFilteredMovies(String title, Integer year, Integer actorId, int pageSize , int pageNumber ){
		Query query;
		List films = null;
//		StringBuilder st = new StringBuilder();
		
//		st.append("Select f from Film f ");
//		st.append("where ");
		
		
//		if(title != null){
//			st.append("f.title= :title ");
//		}
//		if(year != null){
//			st.append(" and");
//			st.append(" f.releaseYear= :year ");
//			
//		}
//		if(actorId != null){
//			st.append(" and");
//			st.append(" fa.actorId= :actorId ");
//		}
		
//		String qlString = st.toString();
		String qlString = "Select f from Film f where ";
		List<String> list = new ArrayList<String>();
		if(title != null){
			list.add("f.title= :title");
		}
		if(year != null){
			list.add("f.releaseYear= :year");
			
		}
		if(actorId != null){
			list.add("fa.actorId= :actorId");
		}
		 String st = String.join(" and ", list);
		String string = qlString.concat(st);
		query = em.createQuery(string);
		
		if(title != null){
			query.setParameter("title", title);
		}
		if(year != null){
			query.setParameter("year", year);
		}
		if(actorId != null){
			query.setParameter("actorId", actorId);
		}
		
		films=query.setMaxResults(pageSize)
					.setFirstResult(pageNumber)
					.getResultList();
		
//		< Solving the Query Using Criteria Builder >
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Film> cQuery = cb.createQuery(Film.class);
//		Root<Film> filmRoot = cQuery.from(Film.class);
//		cQuery.select(filmRoot).where(cb.equal(filmRoot.get("title"), title));
//		
//		TypedQuery<Film> filmQuery = em.createQuery(cQuery); 
//		if()
//		List<Film> films = filmQuery.getResultList();
		
		
		
		return films ;
		
	}
	
	public Long count(String title, Integer year){
		Query query = null;
		
		if(title==null && year==null){
			query = em.createQuery("select count(f) from Film f ");
		}
		else if(!(title==null)){
			query = em.createQuery("select count(f) from Film f where f.title= :title").setParameter("title", title);
		}
		else if(!(year==null)){
			query = em.createQuery("select count(f) from Film f where f.releaseYear= :year").setParameter("year", year);
		}
		//Query query = em.createQuery("select count(f) from Film f ");
		Long count = ((Number)query.getSingleResult()).longValue();
		//System.out.println("count is -----"+count);
		logger.info("The count is : " + count);
		return  count ;
	}
	
	public Film saveFilm(Film film){
		
//		Movie movie = new Movie();
//		movie.setName("DDLJ");
//		movie.setDescription("Romantic Movie");
//		movie.setReleaseYear(2000);
//		movie.setRentalRate(100);
		
		
		em.persist(film);
		em.flush();
		return film ;
	}
}
