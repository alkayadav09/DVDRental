package com.springmvc.practice.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springmvc.practice.model.Actor;

@Repository("actorRepository")
public class ActorRepository {
	
	@PersistenceContext(unitName="punit")
	private EntityManager em ;
	
	public List<Actor> getActors(){
		
		Query query  = em.createQuery(" Select a.id , a.firstName , a.lastName from Actor a order by a.firstName");
		List<Object[]> rows = query.getResultList();
		List<Actor> actors = new ArrayList(rows.size());
		for (Object[] row : rows) {
			
			Actor a = new Actor();
			a.setId((Integer)row[0]);
			a.setFirstName((String) row[1]);
			a.setLastName((String) row[2]);
			
			actors.add(a);
		}
		return actors;
	}

	public Actor saveActor(Actor actor) {
		
		em.persist(actor);
		return actor;
	}

	public Actor getActorById(Integer id) {
		Query query  = em.createQuery(" Select a.id , a.firstName , a.lastName from Actor a where a.id = :id  order by a.firstName")
						.setParameter("id", id);
		List<Object[]> rows = query.getResultList();
		List<Actor> actors = new ArrayList(rows.size());
		for (Object[] row : rows) {
			
			Actor a = new Actor();
			a.setId((Integer)row[0]);
			a.setFirstName((String) row[1]);
			a.setLastName((String) row[2]);
			
			actors.add(a);
		}
		return actors.get(0);
	}

}
