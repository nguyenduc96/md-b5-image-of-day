package com.nguyenduc.repository.comment;

import com.nguyenduc.model.Comment;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements ICommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        String q = "SELECT * FROM Comment WHERE DATE_FORMAT(date, 'dd-MM-yyyy') =  DATE_FORMAT(NOW(), 'dd-MM-yyyy');";
        Query<Comment> query = (Query<Comment>) entityManager.createNativeQuery(q, Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        Long id = comment.getId();
        if (id != null) {
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }
    }

    @Override
    public void delete(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            entityManager.remove(comment);
        }
    }

    @Override
    public List<Comment> findByName(String name) {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        String queryString = "SELECT c FROM Comment AS c WHERE c.id = ?1";
        TypedQuery<Comment> commentTypedQuery = entityManager.createQuery(queryString, Comment.class);
        commentTypedQuery.setParameter(1, id);
        return commentTypedQuery.getSingleResult();
    }

    @Override
    public List<Comment> findByVote(Long vote) {
        String queryString;
        queryString = "SELECT * FROM Comment  WHERE vote = ?1 and (DATE_FORMAT(date, 'dd-MM-yyyy') =  DATE_FORMAT(NOW(), 'dd-MM-yyyy'))";
        Query<Comment> commentQuery = (Query<Comment>) entityManager.createNativeQuery(queryString, Comment.class);
        commentQuery.setParameter(1, vote);
        return commentQuery.getResultList();
    }
}
