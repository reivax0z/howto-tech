package reivax.norac.samplewebbapp.search;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reivax.norac.samplewebbapp.model.HowToModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.springframework.transaction.annotation.Isolation.READ_UNCOMMITTED;

/**
 * Created by xavier caron on 28/01/2015.
 */
@Component
public class HibernateSearch {

    @PersistenceContext(unitName = "sample")
    private EntityManager entityManager;

    private FullTextEntityManager fullTextEntityManager;

    @Transactional
    public List<HowToModel> getSearchResults(String text){
        fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        /*try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch(Exception e){
            System.out.println("Error: "+e);
        }*/

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(HowToModel.class).get();

        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onFields("title", "intro", "steps.intro", "steps.content")
                .matching(text)
                .createQuery();

        // wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, HowToModel.class);
        return jpaQuery.getResultList();
    }

}
